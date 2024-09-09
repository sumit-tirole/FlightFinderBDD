package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindows {

    public static void switchWindow(WebDriver driver, String url) {

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals(url)) {
                break;
            }
        }
    }
}
