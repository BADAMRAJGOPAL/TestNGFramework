package com.automationexercise.tests;

import com.automationexercise.basetest.BaseTest;
import com.automationexercise.pages.DashBoardPage;
import com.automationexercise.pages.LoginPage;
import org.testng.annotations.Test;

import static com.automationexercise.drivers.DriverManager.getDriver;

public class AddAccountTest extends BaseTest {

    @Test
    public void addNewAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
        loginPage.enterLoginCreds(loginPage.getDemoCred());
        loginPage.clickLoginButton();
        dashBoardPage.navigateToMenu("Dashboard");
        dashBoardPage.selectQuickAction("Add Account");
        dashBoardPage.enterAddNewAccountDetails(dashBoardPage.getCreateAccountDetails());
    }
}

