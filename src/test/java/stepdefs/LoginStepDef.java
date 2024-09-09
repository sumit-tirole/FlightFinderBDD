package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.Perform;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class LoginStepDef {
    public LoginPage elements;
    public ConfigReader configReader;
    public Perform perform;
    private AppUtilities apputils;
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));


    @Given("user is on login page")
    public void user_is_on_login_page() throws Throwable {
        elements = new LoginPage(driver);
        configReader = new ConfigReader();
        apputils = new AppUtilities(driver);
        perform = new Perform(driver, 3, 1000);
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
        try{
            elements.getAcceptCookies().click();}
        catch(WebDriverException e) {
            elements.getAcceptCookies().click();
        }
        perform.retryClick(elements.getSignInLink());
    }

    @When("user enters username")
    public void user_enters_username() throws IOException {
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("email1"));
    }
    @And("user enters password")
    public void user_enters_password() throws IOException {
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("pass1"));
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        elements.getPasswordTextField().sendKeys("Password123");
    }

    @Then("user should get an error message")
    public void user_should_get_an_error() {
        String errorMsg = elements.getErrorMsg().getText();
        org.testng.Assert.assertEquals(errorMsg, "Invalid email or password.");
    }

    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        elements.getSignInButton().click();

    }

    @When("user click on the Facebook sign-in button")
    public void user_click_on_the_facebook_sign_in_button() throws InterruptedException {
        Thread.sleep(1000);
        elements.getFbSignInButton().click();

    }
    @When("user switch to the Facebook login window")
    public void user_switch_to_the_facebook_login_window() {
        Set<String> windows= driver.getWindowHandles();

        for(String window:windows) {
            driver.switchTo().window(window);
            if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
            }
            else {
                break;
            }
        }
    }
    @When("user enter his Facebook email and password")
    public void user_enter_his_facebook_email_and_password() throws IOException {
        elements.getFbEmailTextField().sendKeys(configReader.readFromPropertyFile("facebookemail"));
        elements.getFbPasswordTextField().sendKeys(configReader.readFromPropertyFile("facebookpassword"));

    }
    @When("user click on the Facebook login button")
    public void user_click_on_the_facebook_login_button() throws InterruptedException {
        elements.getFbLoginButton().click();
        for(;;){
            try{
                elements.getContinueAsUser().click();
                break;
            }
            catch (StaleElementReferenceException e) {

            }
        }


    }
    @When("I switch back to the Reward Flight Finder window")
    public void i_switch_back_to_the_reward_flight_finder_window() {
        Set<String> windows= driver.getWindowHandles();
        for(String window:windows) {
            driver.switchTo().window(window);
            if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
                break;
            }
        }
    }

    @When("user click on the Google sign-in button")
    public void user_click_on_the_google_sign_in_button() throws InterruptedException {
        Thread.sleep(3000);
        elements.getGoogleSignInButton().click();
        elements.getGoogleSignInButton().click();
    }

    @When("user switch to the Google login window")
    public void user_switch_to_the_google_login_window() {
        Set<String> windows= driver.getWindowHandles();

        for(String window:windows) {
            driver.switchTo().window(window);
            if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
            }
            else {
                break;
            }
        }

    }

    @When("user enter his Google email and clicks on next")
    public void user_enter_his_google_email_and_clicks_on_next() throws IOException {
        elements.getGoogleEmailTextField().sendKeys(configReader.readFromPropertyFile("gmail"));
        elements.getNextButton().click();
    }
    @When("user enter his Google password and clicks on next")
    public void user_enter_his_google_password_and_clicks_on_next() throws IOException {
        elements.getGooglePasswordTextField().sendKeys(configReader.readFromPropertyFile("gmailpassword"));
        elements.getPasswordNext().click();
    }

    @Then("verify the page title")
    public void page_title_should_be() {

        String title = "Easily Find Reward Flight Availability: Redeem British Airways Avios Points";
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(title,driver.getTitle());
    }

    @And("user clicks on account button")
    public void user_clicks_on_account_button() {
        apputils.waitForVisibilityOfElement("(//div[@role='listbox'])[2]");
        perform.retryClick(elements.getAccountButton());
    }

    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        elements.getLogoutButton().click();
    }

}
