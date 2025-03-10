package com.qa.opencart.pagetest;

import com.qa.opencart.appconstent.AppConstent;
import com.qa.opencart.apperr.AppErr;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AccountPageTest extends BaseTest {

    @BeforeClass
    public void pageSetup(){
         accPage = logInPage.loginFunction(prop.getProperty("userName"), prop.getProperty("pass") );
    }

    @Test(priority = 0)
    public void titleTest(){
       String title  =accPage.titleTest();
        Assert.assertEquals(title, AppConstent.ACCOUNT_PAGE_TITLE, AppErr.TITLE_NOT_MATCHED);
    }
    @Test
            (priority = 1)
    public void urlTest(){
      String url = accPage.urlTest();
      Assert.assertTrue(url.contains(AppConstent.ACCOUNT_PAGE_URL_FRACTION));
    }

    @Test
            (priority = 2)
    public void headerTest(){
       List<String>list =accPage.listOfLeftHeaders();
       Assert.assertEquals(list,AppConstent.ACCOUNT_PAGE_HEADER,AppErr.LIST_NOT_MATCHED);
    }

    @Test
            (priority = 3)
    public void searchFuncTest(){
        resultPage =accPage.searchFunctions("iphone");
        String prod = resultPage.pageTitle();
        Assert.assertEquals(prod.contains("iphone"),true,"=search failed=");
    }
    @Test(priority =4 )
    public void searchBoxValueTest(){
          resultPage = accPage.searchFunctions("iphone");
          String value =resultPage.serachBoxValue();
          Assert.assertEquals(value,"iphone","value not matched");
    }
    @DataProvider
    public Object[][]getData(){
        return new Object[][]{{"macbook",3},
                {"iphone",1},
                {"canon",1},
                {"samsung",2}
        };

    }

    @Test(dataProvider = "getData",priority = 5)
    public void searchCountTest(String prodName,int expectedCount){
        resultPage = accPage.searchFunctions(prodName);
        int count=resultPage.searchResultCount();
        Assert.assertEquals(count,expectedCount,"=count not matched=");

    }



}
