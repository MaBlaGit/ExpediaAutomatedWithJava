package com.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    WebElement element;

    @FindBy(id="tab-flight-tab-hp")
    WebElement flightButton;

    @FindBy(xpath="//input[@data-city_element='flight-origin-hp-flight-city']")
    WebElement originField;

    @FindBy(xpath="//input[@data-heds_element='flight-destination-hp-flight-heds']")
    WebElement destinationField;

    @FindBy(id="flight-departing-hp-flight")
    WebElement departureDate;

    @FindBy(id="flight-returning-hp-flight")
    WebElement returnDate;

    @FindBy(id="flight-add-hotel-checkbox-hp-flight")
    WebElement addHotelCheckbox;

    @FindBy(id="flight-advanced-options-hp-flight")
    WebElement advancedOptions;

    @FindBy(xpath="//button[@class='btn-primary btn-action gcw-submit'][position()=1]")
    WebElement searchButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void flightButton(){
        flightButton.click();
    }

    public void originTextBoxField(String origin){
        originField.sendKeys(origin);
    }

    public void destinationTextBoxField(String destination){
        destinationField.sendKeys(destination);
    }

    public void departureDate(int departureDateInput){
        departureDate.click();
        element = driver.findElement(By.xpath("//button[contains(text(), " + departureDateInput + ")]"));
        element.click();
    }

    public void returnDate(int returnDateInput){
        returnDate.click();
        element = driver.findElement(By.xpath("(//button[contains(text(), " + returnDateInput + ")])[2]"));
        element.click();
    }

    public void setAdvancedOptions(){
        advancedOptions.click();
    }

    public void addHotel(){
        addHotelCheckbox.click();
    }

    public void searchButton(){
        searchButton.click();
    }
}
