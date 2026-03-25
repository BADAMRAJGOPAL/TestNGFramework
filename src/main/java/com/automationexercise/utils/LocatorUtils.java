package com.automationexercise.utils;


import org.openqa.selenium.By;

public class LocatorUtils {
    private LocatorUtils(){}

    public static By getDynamicXpath(String xpath, String values){
        return By.xpath(String.format(xpath,values));
    }
}