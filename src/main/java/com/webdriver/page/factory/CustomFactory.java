package com.webdriver.page.factory;

import com.webdriver.page.EnterBugClass;
import com.webdriver.page.HomePageClass;
import com.webdriver.page.LoginPageClass;
import com.webdriver.page.PageBase;
import org.openqa.selenium.WebDriver;

public class CustomFactory {
    /*
     * Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class instance
     * Super Class - PageBase -> HomePageClass, LoginPageClass, EnterBugClass so on
     * Navigation --> Based on input we need to have instance of corresponding page class
     * */

    public static PageBase getInstance(PageName pageName, WebDriver driver){
        switch (pageName){
            case HomePage:
                return new HomePageClass(driver);
            case LoginPage:
                return new LoginPageClass(driver);
            case EnterBugPage :
                return new EnterBugClass(driver);
            default:
                throw new RuntimeException("Invalid Page Name");
        }
    }
}
