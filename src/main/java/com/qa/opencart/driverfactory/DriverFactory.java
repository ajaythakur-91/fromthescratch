package com.qa.opencart.driverfactory;

import com.qa.opencart.appconstent.AppConstent;
import com.qa.opencart.apperr.AppErr;
import com.qa.opencart.exceptionspack.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;
    private Properties prop;


    public WebDriver initDriver(Properties prop){

        String browserName = prop.getProperty("browser");

        System.out.println("Launching Browser : "+browserName);

        switch (browserName.toLowerCase().trim()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser Not Found Please Pass The Right Browser : "+browserName);
                throw  new BrowserException(AppErr.INVALID_BROWSER);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        return driver;

    }



    public Properties initProp() {
        FileInputStream ip;

        String envName = System.getProperty("env");
        if (envName == null) {
            System.out.println("Test Cases Running on Qa ");
            try {
                ip = new FileInputStream(AppConstent.QA_ENV_PATH);
                prop = new Properties();
                prop.load(ip);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {


            System.out.println("Test Cases Running on :" + envName + " mvnenvironment");

            try {
                switch (envName.trim().toLowerCase()) {
                    case "qa":
                        ip = new FileInputStream(AppConstent.QA_ENV_PATH);
                    case "dav":
                        ip = new FileInputStream("src/test/resources/config/DAV_config.properties");
                        break;
                    case "stage":
                        ip = new FileInputStream("src/test/resources/config/Stage_confiq.properties");
                        break;

                    default:
                        throw new RuntimeException("no environment found");


                }


                ip = new FileInputStream(AppConstent.QA_ENV_PATH);
                prop = new Properties();
                prop.load(ip);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

            return prop;


        }




}
