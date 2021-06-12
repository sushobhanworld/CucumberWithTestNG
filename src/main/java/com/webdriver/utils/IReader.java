package com.webdriver.utils;

public interface IReader {
    String getApplicationUrl();
    String getUserName();
    String getPassword();
    int getExplicitWait();
    String getBrowserType();
    void setBrowserType();
}
