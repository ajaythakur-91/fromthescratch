package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private ElementUtil ele;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.ele = new ElementUtil(driver);
    }

    public String titleTest(){
        return ele.getPageTitle();
    }
}
