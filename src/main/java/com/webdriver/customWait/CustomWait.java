package com.webdriver.customWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public class CustomWait {
    public Function<WebDriver, WebElement> customWaitOnElement(By locator){
        return new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if(driver.findElements(locator).size()>=1){
                    System.out.println("Element located");
                    return driver.findElement(locator);
                }
                System.out.println("Waiting....");
                return null;
            }
        };
    }
}
