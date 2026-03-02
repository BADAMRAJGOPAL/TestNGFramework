package com.automationexercise;

import com.automationexercise.drivers.DriverFactory;
import com.automationexercise.drivers.DriverManager;
import org.testng.annotations.Test;


public class AppTest
{
    @Test
    public void Trial() throws InterruptedException {
        DriverFactory.initDriver("Chrome");
        DriverManager.getDriver().get("https://www.qaplayground.com/");
        Thread.sleep(5000);
    }
}
