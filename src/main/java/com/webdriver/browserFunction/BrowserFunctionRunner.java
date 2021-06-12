package com.webdriver.browserFunction;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/com/webdriver/browserFunction/BrowserFunction.feature"},
        glue = {"com.webdriver.browserFunction"},
        dryRun = false,
        monochrome = true
)
public class BrowserFunctionRunner extends AbstractTestNGCucumberTests {
}
