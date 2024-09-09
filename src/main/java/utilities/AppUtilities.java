package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AppUtilities {
    public static WebDriver driver;
    private WebDriverWait wait;
    public AppUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoader() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            if (driver.findElement(By.xpath("//div[@class='full-page-loader-comp text-center']")).isDisplayed()) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='full-page-loader-comp text-center']")));
            }
        } catch (StaleElementReferenceException e) {

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void waitForElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitForVisibilityOfElement(String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForInvisibilityOfElement(String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public boolean checkElementPresence(String xpath){
        wait = new WebDriverWait(driver, Duration.ofMillis(0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return true;
        }
        catch(TimeoutException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return false;
        }
    }
}
