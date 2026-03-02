package com.automationexercise.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private DriverFactory(){

    }
//    public static WebDriver driver;

    public static void initDriver(String browser){
        boolean IsHeadless = true;
        switch (browser){
            case ("Chrome"):
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-notifications");
                if (IsHeadless){
                    chromeOptions.addArguments("--headless=new");
                }
                WebDriver driver =new ChromeDriver(chromeOptions);
                DriverManager.setDriver(driver);
                break;
            default:
                throw new RuntimeException("Invalid Browser Type");
        }
    }
}
