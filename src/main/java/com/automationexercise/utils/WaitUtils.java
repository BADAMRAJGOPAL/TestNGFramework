package com.automationexercise.utils;

import com.automationexercise.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final int DEFAULT_TIMEOUT = 30;

    public static WebElement waitUntilElementIsVisible(By locator) {
        try {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element was not visible within " + DEFAULT_TIMEOUT + " seconds: " + locator, e);
        }

    }
    public static WebElement waitUntilElementIsVisible(WebElement element) {
        try {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOf((WebElement) element));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element was not visible within " + DEFAULT_TIMEOUT + " seconds");
        }

    }

    public static Boolean waitUntilElementIsInvisible(By locator) {
        try {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element was still visible " + DEFAULT_TIMEOUT + " seconds: " + locator, e);
        }
    }
    public static Boolean waitUntilElementIsInvisible(WebElement element) {
        try {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.invisibilityOf((element)));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element was still visible " + DEFAULT_TIMEOUT + " seconds"+ e);
        }
    }


    public static WebElement waitUntilElementIsClickable(By locator) {
        try {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable((WebElement) locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element Is Not Clickable within " + DEFAULT_TIMEOUT + " seconds: " + locator, e);
        }
    }

    public static boolean elementIsChecked(WebElement element){
        try {
            WaitUtils.waitUntilElementIsVisible(element);
            return element.isSelected();
        }
        catch (TimeoutException e){
            throw new RuntimeException("Timeout: Element not visible within wait time", e);
        }
        catch (Exception e){
            throw new RuntimeException("Unexpected error while checking element state", e);
        }
    }

}
