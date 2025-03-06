package com.qa.opencart.pagetest;

import com.qa.opencart.appconstent.AppConstent;
import com.qa.opencart.apperr.AppErr;
import com.qa.opencart.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
        String prod =accPage.searchFunctions("iphone");
        Assert.assertEquals(prod.contains("iphone"),true,"=search failed=");
    }

}
