package com.automationexercise.drivers;

import com.automationexercise.configreader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    private DriverFactory() {
    }

    public static void initDriver() {
        WebDriver driver;
        String browser= ConfigReader.getBrowser();
        Boolean IsHeadless=ConfigReader.getIsHeadLess();
        switch (browser.toLowerCase()) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-notifications");
                if (IsHeadless) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
        DriverManager.setDriver(driver);
    }
}
