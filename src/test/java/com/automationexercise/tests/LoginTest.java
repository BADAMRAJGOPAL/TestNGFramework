package com.automationexercise.tests;

import com.automationexercise.basetest.BaseTest;
import com.automationexercise.pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationexercise.drivers.DriverManager.getDriver;


public class LoginTest extends BaseTest {
    @Test
    @Description("Login Test")
    public void test(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginCreds(loginPage.getDemoCred());
        loginPage.checkRememberMe();
        loginPage.clickLoginButton();
    }
}
