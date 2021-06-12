package com.webdriver.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static ScreenshotHelper screenshotHelper;
    private static WebDriver webDriver;

    private ScreenshotHelper(WebDriver driver) {
        webDriver = driver;
    }

    public static ScreenshotHelper getInstance(WebDriver driver) {
        if (screenshotHelper == null || webDriver.hashCode() != driver.hashCode())
            screenshotHelper = new ScreenshotHelper(driver);
        return screenshotHelper;
    }

    public String takeScreenshot(String path){
        File screenshot= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"/"+path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public byte[] takeScreenshot(){
        return ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
