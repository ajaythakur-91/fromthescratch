package com.qa.opencart.basetest;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;
    protected LogInPage logInPage;
    protected DriverFactory df;
    protected AccountPage accPage;
    protected SearchResultPage resultPage;
    protected ProdInfoPage prodInfo;
    protected RegistrationPage regPage;

    @BeforeTest
    public void setUp(){
        df = new DriverFactory();
        prop = df.initProp();
        driver=df.initDriver(prop);
        logInPage =new LogInPage(driver);



    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
