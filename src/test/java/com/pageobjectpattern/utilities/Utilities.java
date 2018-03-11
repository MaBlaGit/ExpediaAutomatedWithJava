package com.pageobjectpattern.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    WebDriver driver;

    public Utilities(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){
        type = type.toLowerCase();
        if(type.equals("id")) {
            System.out.println("Element found with id: " + type);
            return this.driver.findElement(By.id(locator));
        }else if (type.equals("xpath")){
            System.out.println("Element found with xpath: " + type);
            return this.driver.findElement(By.xpath(locator));
        }else if (type.equals("name")){
            System.out.println("Element found with name: " + type);
            return this.driver.findElement(By.name(locator));
        } else if (type.equals("link")){
            System.out.println("Element found with link: " + type);
            return this.driver.findElement(By.linkText(locator));
        }else if (type.equals("css")){
            System.out.println("Element found with css: " + type);
            return this.driver.findElement(By.cssSelector(locator));
        }else if (type.equals("partial")) {
            System.out.println("Element found with partiallinktext: " + type);
            return this.driver.findElement(By.partialLinkText(locator));
        }else if (type.equals("tag")) {
            System.out.println("Element found with tag: " + type);
            return this.driver.findElement(By.tagName(locator));
        }else{
            System.out.println("Locator type not supported " + locator);
            return null;
        }
    }

    public List<WebElement> getElements(String locator, String type){
        List<WebElement> elementsList = new ArrayList<WebElement>();
        type = type.toLowerCase();
        if(type.equals("id")) {
            elementsList = this.driver.findElements(By.id(locator));
        }else if (type.equals("xpath")){
            elementsList = this.driver.findElements(By.xpath(locator));
        }else if (type.equals("name")){
            elementsList = this.driver.findElements(By.name(locator));
        } else if (type.equals("link")){
            elementsList = this.driver.findElements(By.linkText(locator));
        }else if (type.equals("css")){
            elementsList = this.driver.findElements(By.cssSelector(locator));
        }else if (type.equals("partial")) {
            elementsList = this.driver.findElements(By.partialLinkText(locator));
        }else if (type.equals("tag")) {
            elementsList = this.driver.findElements(By.tagName(locator));
        }else{
            System.out.println("Locator type not supported " + locator);
        }
        if(elementsList.isEmpty()){
            System.out.println("Element not found with " + type + ": " +locator);
        }else{
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementsList;
    }

    public void clickOnElement(String locator, String type){
        WebElement elementToClick = getElement(locator, type);
        elementToClick.click();
    }

    public void sendKeysTo(String locator, String data, String type){
        WebElement sendKeysTo = getElement(locator, type);
        sendKeysTo.sendKeys(data);
    }

    public boolean isElementPresent(String locator, String type){
        int sizeOfTheList = getElements(locator, type).size();
        if(sizeOfTheList > 0){
            System.out.println("Element presented: " + locator);
            return true;
        }else{
            System.out.println("Element not presented: " + locator);
            return false;
        }
    }

    public WebElement waitForElement(WebElement element, int timeOut){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            System.out.println("Element not visible, " + e.getMessage());
        }
        return element;
    }
}
