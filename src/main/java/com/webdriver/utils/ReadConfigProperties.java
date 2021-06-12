package com.webdriver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties implements IReader {
    private Properties properties;

    private Properties getDataFromPropertiesFile(String fileName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(new File(path));
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public String getApplicationUrl() {
        return getDataFromPropertiesFile("config.properties").getProperty("ApplicationUrl");
    }

    @Override
    public String getUserName() {
        return getDataFromPropertiesFile("config.properties").getProperty("Username");
    }

    @Override
    public String getPassword() {
        return getDataFromPropertiesFile("config.properties").getProperty("Password");
    }

    @Override
    public int getExplicitWait() {
        return Integer.parseInt(getDataFromPropertiesFile("config.properties").getProperty("ExplicitWait"));
    }

    @Override
    public String getBrowserType() {
        return getDataFromPropertiesFile("config.properties").getProperty("BrowserName");
    }

    @Override
    public void setBrowserType() {
        String browserName = System.getProperty("BrowserType");

        if (null == browserName || browserName.isEmpty())
            browserName = "chrome";

        getDataFromPropertiesFile("config.properties").setProperty("BrowserName", browserName);
    }
}
