package com.webdriver.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper {
    private static AlertHelper alertHelper;
    private static WebDriver webDriver;

    private AlertHelper(WebDriver driver){
        webDriver=driver;
    }

    public static AlertHelper getInstance(WebDriver driver){
        if(alertHelper==null || webDriver.hashCode()!=driver.hashCode())
            alertHelper= new AlertHelper(driver);
        return alertHelper;
    }

    private WebDriverWait getWait(){
        return new WebDriverWait(webDriver, 60);
    }

    private Alert waitForAlert(){
        WebDriverWait webDriverWait= getWait();
        return webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        Alert alert= waitForAlert();
        alert.accept();
    }

    public void dismissAlert(){
        Alert alert= waitForAlert();
        alert.dismiss();
    }

    public void setAlertText(String text){
        Alert alert= waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getAlertText(){
        Alert alert= waitForAlert();
        return alert.getText();
    }
}
