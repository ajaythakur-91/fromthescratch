package com.qa.opencart.pagetest;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utilites.ExcelUtil;
import com.qa.opencart.utilites.RandomEmail;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp(){
        regPage = logInPage.navigateToRegistrationPage();
    }

    @DataProvider
    public Object[][] getData(){
       return ExcelUtil.getData("regdata");
    }

    @Test(dataProvider = "getData")
    public void registrationTest(String name,String lastName,String talephone,String pw,String subscribe){
       boolean flag= regPage.registrationFunction(name,lastName,RandomEmail.getRandonId(),talephone,pw,subscribe);
        Assert.assertTrue(flag,"registration failed");
    }


}
