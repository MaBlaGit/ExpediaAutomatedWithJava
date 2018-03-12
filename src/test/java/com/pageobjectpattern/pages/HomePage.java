package com.pageobjectpattern.pages;

import com.pageobjectpattern.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    WebElement element;
    Utilities utilities = new Utilities(driver);

    @FindBy(id="tab-flight-tab-hp")
    WebElement flightButton;

    @FindBy(id="tab-hotel-tab-hp")
    WebElement hotelsButton;

    @FindBy(xpath="//input[@data-city_element='flight-origin-hp-flight-city']")
    WebElement originField;

    @FindBy(xpath="//div//label//input[@data-search_name_element='hotel-destination-hp-hotel-search_name']")
    WebElement selectDestinationPlaceName;

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

    @FindBy(xpath="//select[@class='gcw-storeable gcw-show-with-value gcw-airline-select']")
    WebElement predefinedAirline;

    @FindBy(id="hotel-checkin-hp-hotel")
    WebElement hotelCheckIn;

    @FindBy(id="hotel-checkout-hp-hotel")
    WebElement hotelCheckOut;

    @FindBy(xpath="(//button[@class='btn-primary btn-action  gcw-submit'])[1]")
    WebElement searchButtonHotel;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void flightButton(){
        flightButton.click();
    }

    public void hotelsButton(){
        hotelsButton.click();
    }

    public void originTextBoxField(String origin){
        originField.sendKeys(origin);
    }

    public void destinationTextBoxField(String destination){
        destinationField.sendKeys(destination);
    }

    public void destinationPlaceName(String selectDestination){
        selectDestinationPlaceName.click();
        selectDestinationPlaceName.sendKeys(selectDestination);
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

    public void hotelCheckInDate(int checkInDate){
        hotelCheckIn.click();
        element = driver.findElement(By.xpath("//button[contains(text(), " + checkInDate + ")]"));
        element.click();
    }

    public void hotelCheckOutDate(int checkOutDate){
        hotelCheckOut.click();
        element = driver.findElement(By.xpath("(//button[text()=" + checkOutDate + "])[2]"));
        element.click();

    }

    public void setAdvancedOptions(){
        advancedOptions.click();
    }

    public void setPredefinedAirline(String selectAirline){
        utilities.selectFromTheList(predefinedAirline, selectAirline);
    }

    public void addHotel(){
        addHotelCheckbox.click();
    }

    public void searchButtonFlight(){
        searchButton.click();
    }

    public void searchButtonHotel(){
        searchButtonHotel.click();
    }
}
