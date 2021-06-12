package com.webdriver.page;

import com.webdriver.customrunner.CustomAbstractTestNGCucumberTests;
import com.webdriver.customrunner.CustomAbstractTestNGCucumberTestsWithTag;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/com/webdriver/page"},
        glue = {"com.webdriver.page","com.webdriver.genericHook"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-html-report",
                   "json:target/cucumber-report/cucumber.json"}
)
public class BugCreationRunner extends CustomAbstractTestNGCucumberTestsWithTag {
}
