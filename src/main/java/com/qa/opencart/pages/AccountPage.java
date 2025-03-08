package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AccountPage {
    private WebDriver driver;
    private ElementUtil ele;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.ele = new ElementUtil(driver);
    }

    private By leftHeaders = By.tagName("h2");
    private By searchBox = By.name("search");
    private By serchIcon = By.xpath("//div[@id='search']//button[@type='button']");




    public String titleTest(){
        return ele.getPageTitle();
    }

    public String urlTest(){
        String url =ele.getPageUrl();
        return url;
    }

    public List<String> listOfLeftHeaders(){
        List<String>headers  =ele.doGetElementsText(leftHeaders);
        return headers;
    }

    public SearchResultPage searchFunctions(String prodName){
        ele.doSendKeys(searchBox,prodName);
        ele.doClick(serchIcon);
        return new SearchResultPage(driver);
    }
}
