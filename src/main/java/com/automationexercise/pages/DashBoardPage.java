package com.automationexercise.pages;

import com.automationexercise.pages.basepage.BasePage;
import com.automationexercise.utils.WaitUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static com.automationexercise.utils.LocatorUtils.getDynamicXpath;

public class DashBoardPage  extends BasePage {

    public DashBoardPage(WebDriver driver){
        super(driver);
    }

    @FindBy (id = "account-name") private WebElement accountName;
    @FindBy(id = "initial-balance") private WebElement initialBalance;
    @FindBy(xpath = "//button[@id='account-type']/following::select") private WebElement accountTypeDropDown;
    @FindBy (id = "account-type") private WebElement accountType;
    @FindBy (id = "save-account-btn") private WebElement saveAccount;


    public void selectQuickAction(String actions) throws InterruptedException {
        By quickActionElement = getDynamicXpath("//a[normalize-space()='%s']", actions);
        WaitUtils.waitUntilElementIsVisible(quickActionElement).click();
    }
    public void navigateToMenu(String menu) throws InterruptedException {
        By navMenu = getDynamicXpath("//a[contains(text(),'%s')]", menu);
        WaitUtils.waitUntilElementIsVisible(navMenu).click();
    }

    public void selectAccountType(String dropdownOption){
        WaitUtils.waitUntilElementIsVisible(accountType).click();
        By option = getDynamicXpath("//span[text()='%s']/parent::div[@role='option']",dropdownOption);
        WaitUtils.waitUntilElementIsVisible(option).click();
    }

    public void enterAddNewAccountDetails(Map accountDetails) throws InterruptedException {
        WaitUtils.waitUntilElementIsVisible(accountName);
        accountName.sendKeys(accountDetails.get("Account Name").toString());
        selectAccountType(accountDetails.get("Account Type").toString());
        initialBalance.sendKeys(accountDetails.get("Initial Balance").toString());
        By status=getDynamicXpath("//label[text()='%s']/preceding-sibling::button",accountDetails.get("Status").toString());
        WebElement statusElement = driver.findElement(status);
        setCheckBoxState(statusElement, true);
        WaitUtils.waitUntilElementIsVisible(saveAccount).click();
    }
    public Map<String, Object> getCreateAccountDetails(){
        Faker faker = new Faker();
        String accountName = faker.name().firstName();
        String accountType= faker.options().option("Credit Card","Savings Account","Checking Account");
        String initialBalance= String.valueOf(faker.number().randomDouble(2,100,1000));
        String status= faker.options().option("Active", "Inactive");
        boolean overDraftProctection=faker.bool().bool();
        Map<String, Object> accountDetails = Map.of(
                "Account Name", accountName,
                "Account Type", accountType,
                "Initial Balance", initialBalance,
                "Status", status,
                "Overdraft Protection", overDraftProctection
        );
        return accountDetails;
    }
}
