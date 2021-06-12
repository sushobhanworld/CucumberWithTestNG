package com.webdriver.genericHook;

import com.webdriver.services.DriverServices;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class GenericHook {
    private DriverServices services;
    private WebDriver driver;

    public GenericHook(DriverServices driverServices){
        this.services= driverServices;
        driver= driverServices.getDriver();
    }

    @Before(value = "regression", order = 2)
    public void setUpForRegression(){
        System.out.println("This is regression suite");
    }

    @Before(value = "smoke", order = 2)
    public void setUpForSmoke(){
        System.out.println("This is smoke suite");
    }

    @Before(order = 1)
    public void setUp(){
        System.out.println("This is normal hook");
    }

    @After
    public void afterScenario(Scenario scenario){
        String screenShotFileName= System.getProperty("user.dir")+"/snaps"+scenario.getName()+".jpeg";
        if(scenario.isFailed()){
            services.getScreenshotHelper().takeScreenshot(screenShotFileName);
            scenario.attach(services.getScreenshotHelper().takeScreenshot(), "image/png",screenShotFileName);
        }
    }
}
