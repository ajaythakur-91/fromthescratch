package com.qa.opencart.pagetest;

import com.qa.opencart.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ProdInfoTest extends BaseTest {

    @BeforeClass
    public void pagesetUp(){
       accPage=logInPage.loginFunction(prop.getProperty("userName"), prop.getProperty("pass") );
    }


    @Test
    public void productDetails(){
        resultPage = accPage.searchFunctions("macbook");
        prodInfo = resultPage.selectProd("MacBook");
        System.out.println(prodInfo.prodInfofunction());
    }




}
