package stepdefs;

import io.cucumber.java.en.Given;
import org.FlightFinder.pages.AccountSettings;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.DriverFactory;
import io.cucumber.java.en.Then;
import utilities.Perform;
import java.time.Duration;


public class AccountSettingsStepDef {
    private AccountSettings elements;
    private AppUtilities apputils;
    public Perform perform;
    private String email;

    WebDriver driver = DriverFactory.getDriver();


    @Given("navigates to my account section")
    public void navigates_to_my_account_section() {
        apputils = new AppUtilities(driver);
        perform = new Perform(driver, 3, 1000);
        elements = new AccountSettings(driver);
        perform.retryClick(elements.getAccountButton());
        elements.getMyAccountButton().click();
    }

    @Given("clicks on update email button")
    public void clicks_on_update_email_button() {
        elements.getUpdateEmailButton().click();
    }

    @Given("clicks on change password button")
    public void clicks_on_change_password_button() {
        elements.getChangePasswordButton().click();
    }

    @Then("deletes existing secondary email")
    public void deletes_existing_secondary_email() {
        elements.getDeleteEmailButton().click();
    }

    @Then("opens a new tab and navigates to emailondeck and fetch email address")
    public void opens_a_new_tab_and_navigates_to_emailondeck_and_fetch_email_address() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get("chrome-extension://mkpcaklladfpajiaikehdinfaabmnajh/popup/popup.html");

        Thread.sleep(5000);
        email = driver.findElement(By.id("eaddr")).getAttribute("data-clipboard-text");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('target', '_self');", driver.findElement(By.xpath("//a[@href='https://www.emailondeck.com/']")));
        driver.findElement(By.xpath("//a[@href='https://www.emailondeck.com/']")).click();
    }

    @Then("navigates back to RFF website and adds the email")
    public void navigates_back_to_rff_website_and_adds_the_email() {
        utilities.SwitchWindows.switchWindow(driver, "https://rewardflightfinder.com/dashboard/account-settings");
        elements.getAddEmailField().sendKeys(email);
        elements.getAddButton().click();
    }

    @Then("switch back to emailondeck and verifies email")
    public void switch_back_to_emailondeck_and_verifies_email() throws InterruptedException {
        utilities.SwitchWindows.switchWindow(driver, "https://www.emailondeck.com/eod.php");
        elements.getOpenVerificationEmail().click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        driver.switchTo().frame(elements.getIframeEmailOnDeck());
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('target', '_self');", elements.getVerifyEmailButton());
        elements.getVerifyEmailButton().click();
        Thread.sleep(2000);
        driver.close();
    }

    @Then("switch back to RFF and refresh the page")
    public void switch_back_to_rff_and_refresh_the_page() {
        utilities.SwitchWindows.switchWindow(driver, "https://rewardflightfinder.com/dashboard/account-settings");
        driver.navigate().refresh();
    }

    @Then("Checks if email is verified")
    public void checks_if_email_is_verified() {
        elements.getUpdateEmailButton().click();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            Assert.assertEquals(elements.getUnverifiedTag().isDisplayed(), false);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    @Then("enter old and new password and clicks save button")
    public void enter_old_and_new_password_and_clicks_save_button() throws InterruptedException {
        elements.getOldPassword().sendKeys("Password@123");
        elements.getNewPassword().sendKeys("Test@123");
        elements.getConfirmPassword().sendKeys("Test@123");
        elements.getSaveButton().click();
        apputils.waitForElement(elements.getToastMessage());
        if (elements.getToastMessage().getText().equals("Your current password is incorrect.")) {
            apputils.waitForInvisibilityOfElement("//div[@class='Toastify__toast-body']");
            elements.getOldPassword().sendKeys(Keys.CONTROL + "a");
            elements.getOldPassword().sendKeys(Keys.DELETE);
            elements.getNewPassword().sendKeys(Keys.CONTROL + "a");
            elements.getNewPassword().sendKeys(Keys.DELETE);
            elements.getConfirmPassword().sendKeys(Keys.CONTROL + "a");
            elements.getConfirmPassword().sendKeys(Keys.DELETE);
            elements.getOldPassword().sendKeys("Test@123");
            elements.getNewPassword().sendKeys("Password@123");
            elements.getConfirmPassword().sendKeys("Password@123");
            elements.getSaveButton().click();
        }
    }

    @Then("user should see the successfull toast message")
    public void user_should_see_the_successfull_toast_message() {
        apputils.waitForElement(elements.getToastMessage());
        String toastMessage = elements.getToastMessage().getText();
        Assert.assertEquals(toastMessage, "Password updated successfully");
    }

    @Given("click on Airline Membership Tier button")
    public void click_on_airline_membership_tier_button() {
        elements.getAirlineMembershipTierButton().click();
    }

    @Given("selects any membership tier other than existing")
    public void selects_any_membership_tier_other_than_existing() {
        if(elements.getCurrentAMT().getText().equals("Gold")){
        elements.getSilverAMT().click();
        }
        else{
        elements.getGoldAMT().click();
        }
    }

    @Then("user should see the Airline tier updated successfully toast message")
    public void user_should_see_the_airline_tier_updated_successfully_toast_message() {
        apputils.waitForElement(elements.getToastMessage());
        String toastMessage = elements.getToastMessage().getText();
        Assert.assertEquals(toastMessage, "Airline tier updated successfully.");
    }

    @Given("click on Notification Settings button")
    public void click_on_notification_settings_button() {
        elements.getNotificationSettingsButton().click();
    }
    @Given("click on disable sms alert notifications button")
    public void click_on_disable_sms_alert_notifications_button() {
        elements.getToggleSMSNotifications().click();
    }
    @Then("sms notification disabled successfully toast message should be displayed")
    public void sms_notification_disabled_successfully_toast_message_should_be_displayed() {
        apputils.waitForElement(elements.getToastMessage());
        Assert.assertEquals(elements.getToastMessage().getText(),"SMS notification disabled successfully.");
    }
    @Then("click on disable email alert notifications button")
    public void click_on_disable_email_alert_notifications_button() {
        apputils.waitForInvisibilityOfElement("//div[@class='Toastify__toast-body']");
        elements.getToggleEmailNotifications().click();
    }

    @Then("email notification disabled successfully toast message should be displayed")
    public void Email_notification_disabled_successfully_toast_message_should_be_displayed() {
        apputils.waitForElement(elements.getToastMessage());
        Assert.assertEquals(elements.getToastMessage().getText(),"Email notification disabled successfully.");
    }

    @Then("click on enable sms alert notifications button")
    public void click_on_enable_sms_alert_notifications_button() {
        apputils.waitForInvisibilityOfElement("//div[@class='Toastify__toast-body']");
        elements.getToggleSMSNotifications().click();
    }
    @Then("sms notification enabled successfully toast message should be displayed")
    public void sms_notification_enabled_successfully_toast_message_should_be_displayed() {
        apputils.waitForElement(elements.getToastMessage());
        Assert.assertEquals(elements.getToastMessage().getText(),"SMS notification enabled successfully.");
    }
    @Then("click on enable email alert notifications button")
    public void click_on_enable_email_alert_notifications_button() {
        apputils.waitForInvisibilityOfElement("//div[@class='Toastify__toast-body']");
        elements.getToggleEmailNotifications().click();
    }

    @Then("email notification enabled successfully toast message should be displayed")
    public void email_notification_enabled_successfully_toast_message_should_be_displayed() {
        apputils.waitForElement(elements.getToastMessage());
        Assert.assertEquals(elements.getToastMessage().getText(),"Email notification enabled successfully.");
    }

    @Given("click on Personal Info button")
    public void click_on_personal_info_button() {
        elements.getPersonalInfoButton().click();
    }

    @Then("Updates first name")
    public void updates_first_name() {
        if(elements.getFirstName().getText().equals("Nicole")){
            elements.getFirstName().sendKeys(Keys.CONTROL + "a");
            elements.getFirstName().sendKeys(Keys.DELETE);
            elements.getFirstName().sendKeys("Nicholous");
        }
        else{
            elements.getFirstName().sendKeys(Keys.CONTROL + "a");
            elements.getFirstName().sendKeys(Keys.DELETE);
            elements.getFirstName().sendKeys("Nicole");
        }
    }

    @Then("Updates last name")
    public void updates_last_name() {

        if(elements.getLastName().getText().equals("Mullin")){
            elements.getLastName().sendKeys(Keys.CONTROL + "a");
            elements.getLastName().sendKeys(Keys.DELETE);
            elements.getLastName().sendKeys("Murphy");
        }
        else{
            elements.getLastName().sendKeys(Keys.CONTROL + "a");
            elements.getLastName().sendKeys(Keys.DELETE);
            elements.getLastName().sendKeys("Mullin");
        }

    }

    @Then("Updates Closest airport, Age Band and gender")
    public void updates_closest_airport_age_band_and_gender() {
        // Updating closest airport
        if(elements.getClosestAirport().getText().equals("London (LCY, LGW, LHR, LTN, STN, SEN)")){
            Actions action = new Actions(driver);
            action.click(elements.getClosestAirport()).pause(100).perform();
            action.pause(1000).sendKeys("nyc", Keys.ENTER).build().perform();
        }
        else{
            Actions action = new Actions(driver);
            action.click(elements.getClosestAirport()).pause(100).perform();
            action.pause(1000).sendKeys("london", Keys.ENTER).build().perform();
        }

        // Updating Age
        if(elements.getAgeBand().getText().equals("21-29")){
            Actions action = new Actions(driver);
            action.click(elements.getAgeBand()).pause(100).perform();
            action.pause(1000).sendKeys("30", Keys.ENTER).build().perform();
        }
        else{
            Actions action = new Actions(driver);
            action.click(elements.getAgeBand()).pause(100).perform();
            action.pause(1000).sendKeys("21", Keys.ENTER).build().perform();
        }

        //Updating Gender
        if(elements.getGender().getText().equals("Male")){
            Actions action = new Actions(driver);
            action.click(elements.getGender()).pause(100).perform();
            action.pause(1000).sendKeys("Female", Keys.ENTER).build().perform();
        }
        else{
            Actions action = new Actions(driver);
            action.click(elements.getGender()).pause(100).perform();
            action.pause(1000).sendKeys("Male", Keys.ENTER).build().perform();
        }

    }
    @Then("Updates Average flights and travel abroad plan")
    public void updates_average_flights_and_travel_abroad_plan() {

        //Updating Average flights
        if(elements.getAverageFlights().getText().equals("1-3")){
            Actions action = new Actions(driver);
            action.click(elements.getAverageFlights()).pause(100).perform();
            action.pause(1000).sendKeys("3-6", Keys.ENTER).build().perform();
        }
        else{
            Actions action = new Actions(driver);
            action.click(elements.getAverageFlights()).pause(100).perform();
            action.pause(1000).sendKeys("1-3", Keys.ENTER).build().perform();
        }

        //Updating Travel plans
        if(elements.getTravelPlan().getText().equals("Likely")){
            Actions action = new Actions(driver);
            action.click(elements.getTravelPlan()).pause(100).perform();
            action.pause(1000).sendKeys("Unlikely", Keys.ENTER).build().perform();
        }
        else{
            Actions action = new Actions(driver);
            action.click(elements.getTravelPlan()).pause(100).perform();
            action.pause(1000).sendKeys("Likely", Keys.ENTER).build().perform();
        }

    }
    @Then("clicks on save changes button")
    public void clicks_on_save_changes_button() {
        elements.getSaveButton().click();
    }
    @Then("personal info updated successfully toast message should be displayed")
    public void personal_info_updated_successfully_toast_message_should_be_displayed() {
        apputils.waitForElement(elements.getToastMessage());
        Assert.assertEquals(elements.getToastMessage().getText(),"Your personal information has been updated successfully");
    }

}
