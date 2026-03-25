package com.automationexercise.pages;

import com.automationexercise.pages.basepage.BasePage;
import com.automationexercise.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "username") private WebElement usernameInput;
    @FindBy(id = "password") private WebElement passwordInput;
    @FindBy(name = "rememberMe") private WebElement rememberMeCheckBox;
    @FindBy(id = "login-btn") private WebElement loginbtn;
    @FindBy(id = "clear-btn") private WebElement clearbtn;
    @FindBy(id = "demo-username-text") private WebElement demoUsernameText;
    @FindBy(id = "demo-password-text") private WebElement demoPasswordText;

    @Step("Get Demo Credentails")
    public Map<String, String> getDemoCred(){
        Map<String, String> demoCreds= new HashMap<>();
        String userName=demoUsernameText.getText();
        demoCreds.put("username",userName);
        String password=demoPasswordText.getText();
        demoCreds.put("password",password);
        return demoCreds;
    }

    @Step("Enter Login Cred")
    public void enterLoginCreds(Map creds){
        usernameInput.sendKeys(creds.get("username").toString());
        passwordInput.sendKeys(creds.get("password").toString());
    }

    @Step("Click on Login Button")
    public void clickLoginButton(){
        loginbtn.click();
    }

    @Step("Check Remember Me")
    public void checkRememberMe(){
        rememberMeCheckBox.click();
    }

}
