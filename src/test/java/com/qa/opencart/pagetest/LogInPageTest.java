package com.qa.opencart.pagetest;

import com.qa.opencart.appconstent.AppConstent;
import com.qa.opencart.apperr.AppErr;
import com.qa.opencart.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInPageTest extends BaseTest {

    @Test(description = "Title Test",priority = 0)
    public void titleTest(){
        String title = logInPage.titleTest();
        Assert.assertEquals(title, AppConstent.LOGIN_PAGE_TITLE, AppErr.TITLE_NOT_MATCHED);
    }
    @Test(priority = 1)
    public void urlTest(){
        String url=logInPage.pageUrlTest();
        Assert.assertTrue(url.contains(AppConstent.LOGIN_PAGE_URL_FRACTION),AppErr.LINK_NOT_MATCHED);
    }
    @Test(priority = 2)
    public void logInFuncTest(){
        accPage =logInPage.loginFunction(prop.getProperty("userName"), prop.getProperty("pass") );
        String title =accPage.titleTest();
        Assert.assertEquals(title,AppConstent.ACCOUNT_PAGE_TITLE,AppErr.TITLE_NOT_MATCHED);
    }
}
