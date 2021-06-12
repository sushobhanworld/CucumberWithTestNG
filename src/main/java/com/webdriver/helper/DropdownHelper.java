package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHelper {
    private static DropdownHelper dropdownHelper;
    private static WebDriver webDriver;

    private DropdownHelper(WebDriver driver) {
        webDriver = driver;
    }

    public static DropdownHelper getInstance(WebDriver driver) {
        if (dropdownHelper == null || webDriver.hashCode() != driver.hashCode())
            dropdownHelper = new DropdownHelper(driver);
        return dropdownHelper;
    }

    public void selectByVisibleText(By locator, String visibleText){
        Select select= new Select(webDriver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }

    public void selectByValue(By locator, String valueAttribute){
        Select select= new Select(webDriver.findElement(locator));
        select.selectByValue(valueAttribute);
    }

    public void selectByValue(WebElement element, String valueAttribute){
        Select select= new Select(element);
        select.selectByValue(valueAttribute);
    }

    public List<WebElement> getAllValues(By locator){
        Select select= new Select(webDriver.findElement(locator));
        return select.getOptions();
    }
}
