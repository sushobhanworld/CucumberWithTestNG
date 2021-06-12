package com.webdriver.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver implements BrowserConfiguration {
    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }

    public WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= getChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    @Override
    public WebDriver getBrowserDriver() {
        return getChromeDriver();
    }
}
