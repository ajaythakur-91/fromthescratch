package com.qa.opencart.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    //********************findelements*******************************************


    public List<WebElement> dogetElements(By locator){

        return driver.findElements(locator);
    }

    public List<String> doGetElementsText(By locator){
        List<WebElement>elementList = dogetElements(locator);
        List<String>textList= new ArrayList<>() ;

        for (WebElement e : elementList ){

               String txt  =e.getText();
               textList.add(txt);
        }

        return textList;
    }

    public int elementsCount(By locator){
        List<WebElement>elementList =dogetElements(locator);
        int count =elementList.size();
        return count;
    }


    public String getElementText(By locator){
        return doGetElement(locator).getText();
    }


    //*********properties/attributevalue*******************************


    public String getAttributeValue(By locator, String attribute){
        return doGetElement(locator).getDomAttribute(attribute);
    }



}
