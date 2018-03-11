package com.pageobjectpattern.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public WebDriver driver;
    private String baseUrl;
    public HomePage homePage;
    public ResultsPage resultsPage;

    @Before
    public void setUp(){
        baseUrl = "https://www.expedia.com";
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
