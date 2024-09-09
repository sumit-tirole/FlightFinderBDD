package org.FlightFinder.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//button[text()='I agree']")
    WebElement acceptCookies;

    public WebElement getAcceptCookies() {
        return acceptCookies;
    }

    @FindBy(xpath="//button[text()='Sign In']")
    WebElement signInLink;

    public WebElement getSignInLink() {
        return signInLink;
    }

    @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    @FindBy(xpath="//div[@class='column']/button[text()='Sign In']")
    WebElement signInButton;

    public WebElement getSignInButton() {
        return signInButton;
    }

    @FindBy(xpath="(//div[@role='listbox'])[2]")
    WebElement accountButton;

    public WebElement getAccountButton() {
        return accountButton;
    }

    @FindBy(xpath="//span[text()='Logout']")
    WebElement logoutButton;

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    @FindBy(xpath="//span[@class='error-msg']")
    WebElement errorMsg;

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    @FindBy(xpath="//button[@class='fb-login-btn metro']")
    WebElement fbSignInButton;

    public WebElement getFbSignInButton() {
        return fbSignInButton;
    }

    @FindBy(xpath="//*[@id=\"email\"]")
    WebElement fbEmailTextField;

    public WebElement getFbEmailTextField() {
        return fbEmailTextField;
    }

    @FindBy(xpath="//*[@id=\"pass\"]")
    WebElement fbPasswordTextField;

    public WebElement getFbPasswordTextField() {
        return fbPasswordTextField;
    }

    @FindBy(xpath="//*[@id=\"loginbutton\"]")
    WebElement fbLoginButton;

    public WebElement getFbLoginButton() {
        return fbLoginButton;
    }

    @FindBy(xpath="//p[@class='cursor-pointer email-handle']")
    WebElement email;

    public WebElement getEmail(){
        return email;
    }

    @FindBy(xpath="//span[text()='Continue as Sumit']")
    WebElement continueAsUser;

    public WebElement getContinueAsUser(){
        return continueAsUser;
    }

    @FindBy(xpath="//button[@class='google-login-btn']")
    WebElement googleSignInButton;

    public WebElement getGoogleSignInButton() {
        return googleSignInButton;
    }

    @FindBy(xpath="//input[@type='email']")
    WebElement googleEmailTextField;

    public WebElement getGoogleEmailTextField() {
        return googleEmailTextField;
    }

    @FindBy(xpath="//*[@id=\"identifierNext\"]")
    WebElement nextButton;

    public WebElement getNextButton() {
        return nextButton;
    }

    @FindBy(xpath="//input[@name='Passwd']")
    WebElement googlePasswordTextField;

    public WebElement getGooglePasswordTextField() {
        return googlePasswordTextField;
    }

    @FindBy(xpath="//*[@id=\"passwordNext\"]")
    WebElement passwordNext;

    public WebElement getPasswordNext() {
        return passwordNext;
    }
}
