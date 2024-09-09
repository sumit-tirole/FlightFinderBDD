package org.FlightFinder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPageElements {

    public static WebDriver driver;

    public CalenderPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[local-name()='svg' and @class='cst-popup__close ']")
    WebElement closeButton;

    public WebElement getCloseButton(){
        return closeButton;
    }

    @FindBy(xpath="//div[@class='seven wide computer sixteen wide mobile eight wide tablet column schedule-flight-wrap text-left']")
    WebElement scheduledFlightsTab;

    public WebElement getScheduledFlightsTab(){
        return scheduledFlightsTab;
    }
}
