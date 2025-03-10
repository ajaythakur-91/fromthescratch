package com.qa.opencart.pages;

import com.qa.opencart.utilites.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdInfoPage {
    private WebDriver driver;
    private ElementUtil ele;
    private Map<String,String>prodData=new HashMap<String,String>(); ;

    public ProdInfoPage(WebDriver driver) {
        this.driver = driver;
        this.ele= new ElementUtil(driver);
    }

    private By prodHeader = By.tagName("h1");
    private By prodMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
    private By priceList= By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");


    private String getProdHeader(){
        return ele.getElementText(prodHeader);
    }

    private Map<String,String> prodMetaDatafunc(){
        List<String> metaData =ele.doGetElementsText(prodMetaData);

        for (String e : metaData){
            String keyvalue[] =e.split(":");
            prodData.put(keyvalue[0],keyvalue[1]);
        }
        return prodData;

    }

    private Map<String, String> priceData(){
         List<String>price = ele.doGetElementsText(priceList);
         for (int i=0;i<=1;i++){
             String actualprice = price.get(0);
             prodData.put("price",actualprice);
             String extaxprice[]=price.get(1).split(":");
             prodData.put(extaxprice[0],extaxprice[1]);

         }
         return prodData;

    }

    public Map<String, String> prodInfofunction(){
        prodData.put("Product Header",getProdHeader());
        prodData =prodMetaDatafunc();
        prodData = priceData();

        return prodData;

    }






}
