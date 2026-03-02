package com.automationexercise.basetest;

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
        driver.get("https://www.qaplayground.com/");
        System.out.println("Before Method Executed");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method Executed");
        if (driver != null) {
            driver.quit();
            DriverManager.unload();
        }
    }
}
