package com.automationexercise.utils;

import com.automationexercise.drivers.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {

    public ScreenshotUtils() {
    }

    public static void failAndTakeScreenShot(String name) {


        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                name,
                new ByteArrayInputStream(screenshot));

    }
}
