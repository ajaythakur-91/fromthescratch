package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private WebDriver driver;
    private ElementUtil ele;


    private By searchBox = By.xpath("//div[@id='search']/input[@name='search']");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        this.ele = new ElementUtil(driver);
    }


    public String pageTitle(){
        return ele.getPageTitle();
    }

    public String serachBoxValue(){
        return ele.getAttributeValue(searchBox,"value");
    }


    public ProdInfoPage selectProd(String prodname){
        By prod = By.xpath("//div[@class='product-thumb']//a[text()='"+prodname+"']");
        ele.doClick(prod);
        return new ProdInfoPage(driver);

    }



}
