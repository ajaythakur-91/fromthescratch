package com.qa.opencart.pages;

import com.qa.opencart.appconstent.AppConstent;
import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private  WebDriver driver;
    private ElementUtil ele;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.ele = new ElementUtil(driver);

    }

    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By cnfmPassword = By.id("input-confirm");
    private By subscribeloc = By.xpath("//label[normalize-space()='Yes']");
    private By ppCheakBox = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By registrationSuccessfully = By.tagName("h1");
    private By logoutLink = By.linkText("Logout");
    private By registrationLink = By.linkText("Register");



    public boolean registrationFunction(String firstName,String lastName,String email,String telephone,String password,String subscribe){

        ele.doSendKeys(firstNameField,firstName);
        ele.doSendKeys(lastNameField,lastName);
        ele.doSendKeys(emailField,email);
        ele.doSendKeys(telephoneField,telephone);
        ele.doSendKeys(passwordField,password);
        ele.doSendKeys(cnfmPassword,password);

        if(subscribe.equalsIgnoreCase("yes")){
            ele.doClick(subscribeloc);
        }
        else {
            ele.doClick(By.xpath("//label[normalize-space()='Yes']"));
        }

        ele.doClick(ppCheakBox);
        ele.doClick(continueButton);

        String successMsg = ele.getElementText(registrationSuccessfully);
        if (successMsg.equals(AppConstent.ACCOUNT_CREATED_SUCCESSFULLY)){
            ele.doClick(logoutLink);
            ele.doClick(registrationLink);
            return true;

        }
        else {
            return false;
        }




    }


}
