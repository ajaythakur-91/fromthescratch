package com.qa.opencart.pagetest;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utilites.RandomEmail;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp(){
        regPage = logInPage.navigateToRegistrationPage();
    }

    @Test
    public void registrationTest(){
       boolean flag= regPage.registrationFunction("ajay","thakur",RandomEmail.getRandonId(),"9874562310","53@Jay56","no");
        Assert.assertTrue(flag,"registration failed");
    }


}
