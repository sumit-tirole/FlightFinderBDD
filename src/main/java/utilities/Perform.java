package utilities;

import org.openqa.selenium.*;

import java.util.function.Supplier;

public class Perform {

    private WebDriver driver;
    private int maxRetries;
    private int waitTimeInMillis;

    public Perform(WebDriver driver, int maxRetries, int waitTimeInMillis) {
        this.driver = driver;
        this.maxRetries = maxRetries;
        this.waitTimeInMillis = waitTimeInMillis;
    }

    // Retry method for actions that return a value
    private <T> T retry(Supplier<T> supplier) {
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                return supplier.get();
            } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException | ElementClickInterceptedException e) {
                retryCount++;
                System.out.println("Retry " + retryCount + "/" + maxRetries + " due to exception: " + e.getMessage());
                try {
                    Thread.sleep(waitTimeInMillis);
                } catch (InterruptedException ie) {
                    System.out.println("Thread was interrupted: " + ie.getMessage());
                    Thread.currentThread().interrupt(); // Reset interrupt status
                }
            }
        }
        throw new RuntimeException("Failed after " + maxRetries + " retries");
    }

    // Retry method for actions that do not return a value
    private void retry(Runnable runnable) {
        retry(() -> {
            runnable.run();
            return null;
        });
    }

    // Wrapper for click actions
    public void retryClick(WebElement element) {
        retry(() -> {
            element.click();
            return null;
        });
    }

    // Wrapper for sendKeys actions
    public void retrySendKeys(WebElement element, CharSequence keysToSend) {
        retry(() -> {
            element.sendKeys(keysToSend);
            return null;
        });
    }
}
