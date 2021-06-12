package com.webdriver.services;

import com.webdriver.browser.BrowserConfiguration;
import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.browser.CustomFireFoxDriver;
import com.webdriver.helper.*;
import com.webdriver.utils.IReader;
import com.webdriver.utils.ReadConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class DriverServices {
    private WebDriver driver;
    private BrowserConfiguration browserConfiguration;
    private BrowserHelper browserHelper;
    private ButtonHelper buttonHelper;
    private WindowHelper windowHelper;
    private AlertHelper alertHelper;
    private TextBoxHelper textBoxHelper;
    private DropdownHelper dropDownHelper;
    private ScreenshotHelper screenshotHelper;
    private IReader reader;

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserConfiguration getBrowserConfiguration() {
        return browserConfiguration;
    }

    public BrowserHelper getBrowserHelper() {
        return browserHelper;
    }

    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }

    public WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public AlertHelper getAlertHelper() {
        return alertHelper;
    }

    public TextBoxHelper getTextBoxHelper() {
        return textBoxHelper;
    }

    public DropdownHelper getDropDownHelper() {
        return dropDownHelper;
    }

    public ScreenshotHelper getScreenshotHelper() {
        return screenshotHelper;
    }

    public IReader getReader() {
        return reader;
    }

    public WebDriver getBrowserDriver(){
        switch (reader.getBrowserType()){
            case BrowserType.CHROME:
                browserConfiguration= new CustomChromeDriver();
                return browserConfiguration.getBrowserDriver();
            case BrowserType.FIREFOX:
                browserConfiguration= new CustomFireFoxDriver();
                return browserConfiguration.getBrowserDriver();
            default:
                throw new RuntimeException("Invalid Browser Type : " + reader.getBrowserType());
        }
    }
    public void launchBrowser(){
        reader= new ReadConfigProperties();
        reader.setBrowserType();
        driver= getBrowserDriver();
        browserHelper = BrowserHelper.getInstance(driver);
        buttonHelper = ButtonHelper.getInstance(driver);
        windowHelper = WindowHelper.getInstance(driver);
        alertHelper = AlertHelper.getInstance(driver);
        textBoxHelper = TextBoxHelper.getInstance(driver);
        dropDownHelper = DropdownHelper.getInstance(driver);
        screenshotHelper = ScreenshotHelper.getInstance(driver);
        driver.manage().timeouts().implicitlyWait(reader.getExplicitWait(), TimeUnit.SECONDS);
        browserHelper.maximize();
    }
    public DriverServices(){
        launchBrowser();
    }
}
