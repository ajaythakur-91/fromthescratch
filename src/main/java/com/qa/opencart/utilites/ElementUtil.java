package com.qa.opencart.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil (WebDriver driver){
        this.driver = driver;
    }



    public String getPageTitle(){
         return driver.getTitle();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement doGetElement(By locator){
        return driver.findElement(locator);
    }

    public void doSendKeys(By locator,String sendKeys){
        doGetElement(locator).clear();
        doGetElement(locator).sendKeys(sendKeys);
    }

    public void doClick(By locator){
        doGetElement(locator).click();
    }

    public boolean isElementDisplayed(By locator){
        try {
            doGetElement(locator).isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }



}
