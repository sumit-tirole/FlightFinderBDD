package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.awt.*;
import java.io.File;
import java.time.Duration;


public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public WebDriver init_driver(String browser,String customOption) {

        System.out.println("browser value is: " + browser);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        String windowSize = screenWidth + "," + screenHeight;

        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(customOption);
            options.addExtensions (new File("src/test/resources/Config/EmailOnDeckCRX.crx"));
            tlDriver.set(new ChromeDriver(options));
        }

        else if (browser.equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addExtensions (new File("src/test/resources/Config/EmailOnDeckCRX.crx"));
            options.addArguments(customOption);
            tlDriver.set(new EdgeDriver(options));
        }

        else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            tlDriver.set(new FirefoxDriver());
        }

        else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        }

        else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(screenWidth,screenHeight));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
