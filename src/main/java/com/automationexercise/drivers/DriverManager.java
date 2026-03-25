package com.automationexercise.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        driver.set(driverInstance);
    }

    public static void unload() {
        driver.remove();
    }
}
