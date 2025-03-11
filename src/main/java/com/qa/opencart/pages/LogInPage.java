package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;
    private ElementUtil ele;


    public LogInPage(WebDriver driver){
        this.driver =driver;
        this.ele = new ElementUtil(driver);
    }


    private By loginfield = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By forgotLink = By.linkText("Forgotten Password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By righpanelLinks = By.xpath("//aside[@id='column-right']//a");
    private By registrationPageLink = By.linkText("Register");



    public String titleTest(){
         return ele.getPageTitle();
    }

    public String pageUrlTest(){
        return ele.getPageUrl();
    }

    public boolean fogotlinkTest(){
       return ele.isElementDisplayed(forgotLink);
    }

    public AccountPage loginFunction(String userName,String password){
        ele.doSendKeys(loginfield,userName);
        ele.doSendKeys(passwordField,password);
        ele.doClick(loginButton);
        return new AccountPage(driver);
    }

    public int  righPanelLinksCount(){
        int count = ele.elementsCount(righpanelLinks);
        return count;
    }


    public RegistrationPage navigateToRegistrationPage(){
        ele.doClick(registrationPageLink);
        return new RegistrationPage(driver);
    }





}
