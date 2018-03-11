package com.pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    WebDriver driver;
    WebElement element;

    @FindBy(id="header-logo")
    WebElement headerLogoElement;


    public ResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement headerLogo(){
        return headerLogoElement;
    }
}
