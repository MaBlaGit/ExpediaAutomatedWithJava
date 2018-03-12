package com.pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsFlightsPage {

    WebDriver driver;
    WebElement element;

    @FindBy(id="header-logo")
    WebElement headerLogoElement;

    @FindBy(className="alert-message")
    WebElement alertMessage;


    public ResultsFlightsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement headerLogo(){
        return headerLogoElement;
    }

    public WebElement alertMessage(){
        return alertMessage;
    }
}
