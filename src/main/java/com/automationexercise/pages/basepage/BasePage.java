package com.automationexercise.pages.basepage;

import com.automationexercise.drivers.DriverManager;
import com.automationexercise.utils.LocatorUtils;
import com.automationexercise.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(String buttonLabel) {
        By buttonLocator = LocatorUtils.getDynamicXpath("//button[text()='%s']", buttonLabel);
        WaitUtils.waitUntilElementIsClickable(buttonLocator).click();
    }
    public void selectDropDown(WebElement selectWebElement, String Label){
        WaitUtils.waitUntilElementIsVisible(selectWebElement);
        Select select = new Select(selectWebElement);
        select.selectByValue(Label);

    }
    public void selectRadioButton(WebElement radioButtonElement){
        WaitUtils.waitUntilElementIsInvisible(radioButtonElement);
        boolean isChecked = radioButtonElement.isSelected();
        if (!isChecked){
            radioButtonElement.click();
        }
    }
    public void setCheckBoxState(WebElement checkBoxElement, boolean checkStatus){
        WaitUtils.waitUntilElementIsVisible(checkBoxElement);
        boolean checkboxStatus=checkBoxElement.isSelected();
        if (checkStatus != checkboxStatus){
            checkBoxElement.click();
        }
    }

}
