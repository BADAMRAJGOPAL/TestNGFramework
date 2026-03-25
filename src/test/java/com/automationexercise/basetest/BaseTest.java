package com.automationexercise.basetest;

import com.automationexercise.configreader.ConfigReader;
import com.automationexercise.drivers.DriverFactory;
import com.automationexercise.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverManager.getDriver().get(ConfigReader.get("baseurl"));
        System.out.println("Before Method Executed");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method Executed");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
