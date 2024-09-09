package org.FlightFinder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsAndAdvice {
    public static WebDriver driver;

    public NewsAndAdvice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//*[local-name()='svg'])[3]")
    WebElement articlesIcon;

    public WebElement getArticlesIcon() {
        return articlesIcon;
    }

    @FindBy(xpath="//div[@class='popular_article_inner cursor-pointer parentNode']")
    WebElement popularArticles;

    public WebElement getPopularArticles() {
        return popularArticles;
    }

    @FindBy(xpath="//div[@class='popular_topics-tags']//p")
    WebElement popularTopics;

    public WebElement getPopularTopics() {
         return popularTopics;
    }

    @FindBy(xpath="(//*[@class='blogCard context-menu'])[1]")
    WebElement popularBlogs;

    public WebElement getPopularBlogs() {
         return popularBlogs;
    }
}
