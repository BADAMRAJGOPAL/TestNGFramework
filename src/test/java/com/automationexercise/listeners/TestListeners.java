package com.automationexercise.listeners;

import com.automationexercise.drivers.DriverManager;
import com.automationexercise.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("Starting test: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtils.failAndTakeScreenShot(result.getName());

        Throwable throwable = result.getThrowable();
        if(throwable!=null){
            Allure.addAttachment("Failure Reason",throwable.toString());
        }
        Allure.addAttachment("Page Source", "text/html", DriverManager.getDriver().getPageSource(), ".html");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}