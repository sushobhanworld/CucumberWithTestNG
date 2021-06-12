package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {
    private static TextBoxHelper textBoxHelper;
    private static WebDriver webDriver;
    private WebElement element;

    private TextBoxHelper(WebDriver driver) {
        webDriver = driver;
    }

    public static TextBoxHelper getInstance(WebDriver driver) {
        if (textBoxHelper == null || webDriver.hashCode() != driver.hashCode())
            textBoxHelper = new TextBoxHelper(driver);
        return textBoxHelper;
    }

    public void setText(By locator, String value) {
        element = webDriver.findElement(locator);
        element.sendKeys(value);
    }

    public String getText(By locator) {
        element = webDriver.findElement(locator);
        String value = element.getText();
        return value;
    }

    public void clear(By locator) {
        element = webDriver.findElement(locator);
        element.clear();
    }
}
