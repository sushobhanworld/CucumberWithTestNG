package com.webdriver.helper;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WindowHelper {
    private static WebDriver webDriver;
    private static WindowHelper windowHelper;

    private WindowHelper(WebDriver driver){
        webDriver=driver;
    }

    public static WindowHelper getInstance(WebDriver driver){
        if(windowHelper==null || webDriver.hashCode()!=driver.hashCode())
            windowHelper= new WindowHelper(driver);
        return windowHelper;
    }

    public List<String> getWindowsIds(){
        ArrayList<String> windowIds= new ArrayList<>(webDriver.getWindowHandles());
        return Collections.unmodifiableList(windowIds);
    }
    public void switchToWindow(int index){
        ArrayList<String> windowIds= new ArrayList<>(getWindowsIds());
        if(index<0 || index>windowIds.size())
            throw new IllegalArgumentException("Index is not valid "+index);
        webDriver.switchTo().window(windowIds.get(index));
    }

    public void switchToParent(){
        ArrayList<String> windowIds= new ArrayList<>(getWindowsIds());
        webDriver.switchTo().window(windowIds.get(0));
    }

    public void switchToParentWithClose(){
        ArrayList<String> windowIds= new ArrayList<>(getWindowsIds());
        windowIds.forEach((w)->{
            webDriver.switchTo().window(w);
            webDriver.close();
        });
        switchToParent();
    }
}
