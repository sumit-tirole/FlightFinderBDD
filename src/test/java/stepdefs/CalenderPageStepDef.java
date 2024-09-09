package stepdefs;

import org.openqa.selenium.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.CalenderPageElements;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.CalenderUtility;
import utilities.DriverFactory;

public class CalenderPageStepDef {
    private CalenderPageElements elements;
    private AppUtilities apputils;
    private Boolean inboundAvailability= false;
    private Boolean outboundAvailability= false;
    private String xpath;
    private String date;
    WebDriver driver = DriverFactory.getDriver();

    @When("clicks on random date")
    public void clicks_on_random_date() {
        elements = new CalenderPageElements(driver);
        String Month = CalenderUtility.getCurrentMonth();
        int i = java.util.concurrent.ThreadLocalRandom.current().nextInt(20, 30);
        if(i<=9) {
            WebElement date = driver.findElement(By.xpath("(//div[contains(@aria-label,'" + Month + " 0" + i + " 2024')])[1]"));
            date.click();
        }
        else {
            WebElement date = driver.findElement(By.xpath("(//div[contains(@aria-label,'" + Month + " " + i + " 2024')])[1]"));
            date.click();
        }
    }

    @Then("user should see the scheduled flights availability")
    public void user_should_see_the_scheduled_flights_availability() {

        Assert.assertTrue(elements.getScheduledFlightsTab().isDisplayed());
        elements.getCloseButton().click();
    }

    @When("checks seats availability for complete next month")
    public void checks_seats_availability_for_complete_next_month() {
        apputils = new AppUtilities(driver);

        for (int i = 1; i <= 30; i++) {
            date = CalenderUtility.getNextMonthDate(i);
            xpath = "//div[@aria-label='" + date + "']/div[@data-for='outbound']//div[@class='color-circle ']";
            if(apputils.checkElementPresence(xpath)){
               outboundAvailability = true;
               break;
            }
        }
        for (int i = 1; i <= 30; i++) {
            date = CalenderUtility.getNextMonthDate(i);
            xpath = "//div[@aria-label='" + date + "']/div[@data-for='inbound']//div[@class='color-circle ']";
            if(apputils.checkElementPresence(xpath)){
                inboundAvailability = true;
                break;
            }
        }
    }

    @Then("colored circles indicating seats availability should be displayed.")
    public void colored_circles_indicating_seats_availability_should_be_displayed() {
        Assert.assertTrue(inboundAvailability);
        Assert.assertTrue(outboundAvailability);

    }
}
