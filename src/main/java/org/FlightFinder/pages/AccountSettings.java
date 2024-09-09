package org.FlightFinder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettings {

    public static WebDriver driver;

    public AccountSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//div[@role='listbox'])[2]")
    WebElement accountButton;

    public WebElement getAccountButton() {
        return accountButton;
    }

    @FindBy(xpath="//span[text()='My Account']")
    WebElement myAccountButton;

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    @FindBy(xpath="//div[@class='content card-content']//div[text()='Update Email/Phone']")
    WebElement updateEmailButton;

    public WebElement getUpdateEmailButton() {
        return updateEmailButton;
    }

    @FindBy(xpath="//div[@class='ui grid w-100 text-left edit-grid']//button[@class='ui button ui icon button email_delete_btn']")
    WebElement deleteEmailButton;

    public WebElement getDeleteEmailButton() {
        return deleteEmailButton;
    }

    @FindBy(xpath="//input[@name='addEmail']")
    WebElement addEmailField;

    public WebElement getAddEmailField() {
        return addEmailField;
    }

    @FindBy(xpath="(//button[text()='ADD'])")
    WebElement addButton;

    public WebElement getAddButton() {
        return addButton;
    }

    @FindBy(xpath="//td[text()='Reward Flight Finder']")
    WebElement openVerificationEmail;

    public WebElement getOpenVerificationEmail(){
        return openVerificationEmail;
    }

    @FindBy(xpath="//iframe[contains(@src,'email_iframe')]")
    WebElement iframeEmailOnDeck;

    public WebElement getIframeEmailOnDeck(){
        return iframeEmailOnDeck;
    }

    @FindBy(xpath="//a[text()='Verify email']")
    WebElement verifyEmailButton;

    public WebElement getVerifyEmailButton(){
        return verifyEmailButton;
    }

    @FindBy(xpath="//div[@class='other-tags-notification']//span[text()='Unverified']")
    WebElement unverifiedTag;

    public WebElement getUnverifiedTag(){
        return unverifiedTag;
    }

    @FindBy(xpath="//div[@class='content card-content']//div[text()='Change Password']")
    WebElement changePasswordButton;

    public WebElement getChangePasswordButton(){
        return changePasswordButton;
    }

    @FindBy(xpath="//input[@name='oldPassword']")
    WebElement oldPassword;

    public WebElement getOldPassword(){
        return oldPassword;
    }

    @FindBy(xpath="//input[@name='newPassword']")
    WebElement newPassword;

    public WebElement getNewPassword(){
        return newPassword;
    }

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPassword;

    public WebElement getConfirmPassword(){
        return confirmPassword;
    }

    @FindBy(xpath="//div[@class='Toastify__toast-body']")
    WebElement toastMessage;

    public WebElement getToastMessage(){
        return toastMessage;
    }

    @FindBy(xpath="//button[text()='Save Changes']")
    WebElement saveButton;

    public WebElement getSaveButton(){
        return saveButton;
    }

    @FindBy(xpath="//div[@class='content card-content']//div[text()='Airline Membership Tier']")
    WebElement airlineMembershipTierButton;

    public WebElement getAirlineMembershipTierButton(){
        return airlineMembershipTierButton;
    }

    @FindBy(xpath="//div[@class='content card-content']//div[text()='Notification Settings']")
    WebElement notificationSettingsButton;

    public WebElement getNotificationSettingsButton(){
        return notificationSettingsButton;
    }

    @FindBy(xpath="//div[@class='content card-content']//div[text()='Personal Info']")
    WebElement personalInfoButton;

    public WebElement getPersonalInfoButton(){
        return personalInfoButton;
    }

    @FindBy(xpath="//span[text()='SMS Alert Notifications']/..//input[@type='checkbox']")
    WebElement toggleSMSNotifications;

    public WebElement getToggleSMSNotifications(){
        return toggleSMSNotifications;
   }

    @FindBy(xpath="//span[text()='Email Alert Notifications']/..//input[@type='checkbox']")
    WebElement toggleEmailNotifications;

    public WebElement getToggleEmailNotifications(){
        return toggleEmailNotifications;
    }

    @FindBy(xpath="//div[@class='text']/span")
    WebElement currentAMT;

    public WebElement getCurrentAMT(){
        return currentAMT;
    }

    @FindBy(xpath="//div[@selectedairline='BA']/span[text()='Silver']")
    WebElement silverAMT;

    public WebElement getSilverAMT(){
        return silverAMT;
    }

    @FindBy(xpath="//div[@selectedairline='BA']/span[text()='Gold']")
    WebElement goldAMT;

    public WebElement getGoldAMT(){
        return goldAMT;
    }

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstName;

    public WebElement getFirstName(){
        return  firstName;
    }

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastName;

    public WebElement getLastName(){
        return lastName;
    }

    @FindBy(xpath="//label[text()='My Closest Airport']/..//div[@class=' css-1hwfws3']")
    WebElement closestAirport;

    public WebElement getClosestAirport(){
        return closestAirport;
    }

    @FindBy(xpath="//label[text()='Age Band']/..//div[@class=' css-1hwfws3']")
    WebElement ageBand;

    public WebElement getAgeBand() {
        return ageBand;
    }

    @FindBy(xpath="//label[text()='Gender']/..//div[@class=' css-1hwfws3']")
    WebElement gender;

    public WebElement getGender(){
        return gender;
    }

    @FindBy(xpath="//label[text()='Average number of return flights taken a year']/..//div[@class=' css-1hwfws3']")
    WebElement averageFlights;

    public WebElement getAverageFlights(){
        return averageFlights;
    }

    @FindBy(xpath="//label[text()='Do you plan to travel abroad in the next 12 months?']/..//div[@class=' css-1hwfws3']")
    WebElement travelPlan;

    public WebElement getTravelPlan(){
        return travelPlan;
    }
    
}
