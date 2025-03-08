package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.WebDriver;

public class ProdInfoPage {
    private WebDriver driver;
    private ElementUtil ele;
    public ProdInfoPage(WebDriver driver) {
        this.driver = driver;
        this.ele= new ElementUtil(driver);
    }
}
