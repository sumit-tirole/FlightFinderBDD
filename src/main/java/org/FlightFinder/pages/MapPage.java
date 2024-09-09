package org.FlightFinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage {
    public static WebDriver driver;

    public MapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@data-for='map-page']")
    WebElement worldMapButton;

    public WebElement getWorldMapButton() {
        return worldMapButton;
    }

    @FindBy(xpath="//div[text()='Where from?']")
    WebElement whereFromField;

    public WebElement getWhereFromField() {
        return whereFromField;
    }

    @FindBy(xpath="//input[@id='startDateDep']")
    WebElement dateField;

    public WebElement getDateField() {
        return dateField;
    }

    @FindBy(xpath="//div[@aria-label='Move forward to switch to the next month.']")
    WebElement nextMonth;

    public WebElement getNextMonth() {
        return nextMonth;
    }

    @FindBy(xpath="(//div[text()='15' and @class='CalendarDay__Date'])[2]")
    WebElement startDate;

    public WebElement getStartDate() {
        return startDate;
    }

    @FindBy(xpath="(//div[text()='22' and @class='CalendarDay__Date'])[2]")
    WebElement endDate;

    public WebElement getEndDate() {
        return endDate;
    }

    @FindBy(xpath="//button[text()='Set Dates']")
    WebElement setDatesButton;

    public WebElement getSetDatesButton() {
        return setDatesButton;
    }

    @FindBy(xpath="//button[text()='Search']")
    WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSelectDestination(int destinationNumber) {
        WebElement destination = driver.findElement(By.xpath("(//div[@class='destination-country-wrap'])["+destinationNumber+"]"));
        return destination;
    }

    @FindBy(xpath="//p[@class='cst-popup__text']")
    WebElement upgradeMembershipPopup;

    public WebElement getUpgradeMembershipPopup() {
        return upgradeMembershipPopup;
    }

    @FindBy(xpath="//button[text()='Memberships']")
    WebElement membershipsButton;

    public WebElement getMembershipsButton() {
        return membershipsButton;
    }

    @FindBy(xpath="//*[@class='cst-popup__close']")
    WebElement closeButton;

    public WebElement getCloseButton() {
        return closeButton;
    }

    @FindBy(xpath="(//strong)[3]")
    WebElement calenderHeader;

    public WebElement getCalenderHeader(){
        return calenderHeader;
    }

    public WebElement getDate(String enabledDate){
        WebElement day = driver.findElement(By.xpath("//td[contains(@aria-label,'"+enabledDate+"')]"));
        return day;
    }

    @FindBy(xpath="//button[text()='Cancel']")
    WebElement cancelButton;

    public WebElement getCancelButton(){
        return cancelButton;
    }
}
