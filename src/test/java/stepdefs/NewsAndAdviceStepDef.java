package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AccountSettings;
import org.FlightFinder.pages.NewsAndAdvice;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.DriverFactory;
import utilities.Perform;

public class NewsAndAdviceStepDef {

    private NewsAndAdvice elements;
    private AppUtilities apputils;
    public Perform perform;
    private String email;
    WebDriver driver = DriverFactory.getDriver();

    @When("User click on the articles icon")
    public void user_click_on_the_articles_icon() {
        apputils = new AppUtilities(driver);
        perform = new Perform(driver, 3, 1000);
        elements = new NewsAndAdvice(driver);
        elements.getArticlesIcon().click();
    }

    @Then("popular articles section should not be empty")
    public void popular_articles_section_should_not_be_empty() {
        Assert.assertTrue(elements.getPopularArticles().isDisplayed());
    }
    @Then("popular topics section should not be empty")
    public void popular_topics_section_should_not_be_empty() {
        Assert.assertTrue(elements.getPopularTopics().isDisplayed());
    }
    @Then("popular blogs section should not be empty")
    public void popular_blogs_section_should_not_be_empty() {
        Assert.assertTrue(elements.getPopularBlogs().isDisplayed());
    }
}
