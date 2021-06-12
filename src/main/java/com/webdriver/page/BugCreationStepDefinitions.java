package com.webdriver.page;

import com.webdriver.page.factory.PageName;
import com.webdriver.services.DriverServices;
import com.webdriver.utils.TestSettings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class BugCreationStepDefinitions {
    private WebDriver driver;
    private DriverServices driverServices;
    private TestSettings testSettings;

    public BugCreationStepDefinitions(DriverServices driverServices, TestSettings testSettings){
        this.driverServices=driverServices;
        this.driver= driverServices.getDriver();
        this.testSettings=testSettings;
    }
    @Given("Bugzilla_I am at the Bugzilla home page")
    public void bugzilla_iAmAtTheBugzillaHomePage() {
        driver.get(driverServices.getReader().getApplicationUrl());
        testSettings.homePageClass= new HomePageClass(driver);
        testSettings.data= "From 1st step def";
    }

    @Then("Bugzilla_I click on File a bug link and navigate to login page")
    public void bugzilla_iClickOnFileABugLinkAndNavigateToLoginPage() {
        testSettings.loginPageClass = (LoginPageClass) testSettings.homePageClass.navigateToLoginPage();

        //testSettings.homePageClass.fileABuglink.click();
        //testSettings.loginPageClass= (LoginPageClass) testSettings.homePageClass.navigateTo(PageName.LoginPage, driver, testSettings.loginPageClass.loginButton);
    }

    @Then("Bugzilla_I log into the application and navigate to enter bug page")
    public void bugzilla_iLogIntoTheApplicationAndNavigateToEnterBugPage() {
        testSettings.enterBugClass= (EnterBugClass) testSettings.loginPageClass.login(driverServices.getReader().getUserName(), driverServices.getReader().getPassword());
    }

    @Then("Bugzilla_I navigate to Home page")
    public void bugzilla_iNavigateToHomePage() {
        testSettings.enterBugClass.home.click();
        testSettings.homePageClass= (HomePageClass) testSettings.enterBugClass.navigateTo(PageName.HomePage, driver, testSettings.homePageClass.home);
    }

    @Then("Bugzilla_I navigate to enter bug page")
    public void bugzilla_iNavigateToEnterBugPage() {
        testSettings.homePageClass.newLink.get(0).click();
        testSettings.enterBugClass= (EnterBugClass) testSettings.homePageClass.navigateTo(PageName.EnterBugPage, driver, testSettings.enterBugClass.hardware);
    }

    @And("Bugzilla_I enter details as severity as {string} hardware as {string} operating system as {string} summary as {string} and description as {string}")
    public void bugzilla_iEnterDetailsAsSeverityAsHardwareAsOperatingSystemAsSummaryAsAndDescriptionAs(String sever, String hard, String os, String shortSummary, String des) {
        testSettings.bugSummaryClass= (BugSummaryClass) testSettings.enterBugClass.enterBugDetails(sever, hard, os, shortSummary, des);
    }

    @And("Bugzilla_I am at the summary page and I click the logout button")
    public void bugzilla_iAmAtTheSummaryPageAndIClickTheLogoutButton() {
        testSettings.bugSummaryClass.logoutFromApplication();
    }

    @And("Bugzilla_The title of login page should be {string}")
    public void bugzilla_theTitleOfLoginPageShouldBe(String expectedTitle) {
        driverServices.getScreenshotHelper().takeScreenshot("/snaps/"+System.currentTimeMillis()+".png");
    }

    @Given("user opens google page")
    public void userOpensGooglePage() {
        driver.get("http://www.google.com");
    }

    @And("user prints the title")
    public void userPrintsTheTitle() {
        System.out.println(driver.getTitle());
    }

    @Given("user opens facebook page")
    public void userOpensFacebookPage() {
        driver.get("http://www.facebook.com");
    }
}
