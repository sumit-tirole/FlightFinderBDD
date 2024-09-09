package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.plugin.event.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentScenario;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
    }

    @Before(order = 1)
    public void launchBrowser(Scenario scenario) throws IOException {

        String browserName = configReader.readConfigFromPropertyFile("browser");
        driverFactory = new DriverFactory();
        if (scenario.getName().matches(".*(Login with Facebook|Login with Google).*")) {
            driver = driverFactory.init_driver(browserName, "--headless");
        } else {
            driver = driverFactory.init_driver(browserName, "--headless=new");
        }
    }

    @After(order = 0)
    public void quitBrowser(Scenario scenario) throws IOException {
        //validate if scenario has failed

        if(scenario.isFailed()) {
                      
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure screenshot");
            }
        driver.quit();
    }

}
