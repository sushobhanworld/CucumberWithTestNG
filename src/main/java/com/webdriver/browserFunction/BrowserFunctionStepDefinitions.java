package com.webdriver.browserFunction;

import com.webdriver.browser.BrowserConfiguration;
import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BrowserFunctionStepDefinitions {
    private WebDriver driver;
    private BrowserHelper browserHelper;
    private BrowserConfiguration browserConfiguration= new CustomChromeDriver();

    @Given("BrowserFunction_I have chrome driver instance")
    public void browserfunction_iHaveChromeDriverInstance() {
        driver= browserConfiguration.getBrowserDriver();
        browserHelper= BrowserHelper.getInstance(driver);
    }

    @When("BrowserFunction_I call the quit method the browser will close")
    public void browserfunction_iCallTheQuitMethodTheBrowserWillClose() {
        if (driver != null)
            driver.quit();
    }

    @And("BrowserFunction_I call the get with url {string} then it should open the page")
    public void browserfunction_iCallTheGetWithUrlThenItShouldOpenThePage(String url) {
        driver.get(url);
    }

    @Then("BrowserFunction_I call the back api this should navigate back in the browser")
    public void browserfunction_iCallTheBackApiThisShouldNavigateBackInTheBrowser() {
        browserHelper.moveBackward();
    }

    @Then("BrowserFunction_I call the forward api this should move forward in the browser")
    public void browserfunction_iCallTheForwardApiThisShouldMoveForwardInTheBrowser() {
        browserHelper.moveForward();
    }

    @Then("BrowserFunction_I call the refresh api this should refresh the webpage")
    public void browserfunction_iCallTheRefreshApiThisShouldRefreshTheWebpage() {
        browserHelper.refresh();
    }

    @When("BrowserFunction_I call the maximize method")
    public void browserfunction_iCallTheMaximizeMethod() {
        browserHelper.maximize();
    }
}
