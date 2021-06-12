package com.webdriver.datadriven;

import com.webdriver.services.DriverServices;
import com.webdriver.utils.TestSettings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataDrivenStepDefinitions {
    private WebDriver driver;
    private DriverServices driverServices;
    private ExcelReader excelReader;
    private TestSettings testSettings;

    public DataDrivenStepDefinitions(DriverServices driverServices, ExcelReader excelReader, TestSettings testSettings){
        this.driverServices= driverServices;
        this.driver= driverServices.getDriver();
        this.excelReader=excelReader;
        this.testSettings=testSettings;
    }
    @Given("user navigates to contact us page")
    public void userNavigatesToContactUsPage() {
        driver.get("http://automationpractice.com/index.php?controller=contact");
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void userFillsTheFormFromGivenSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData =
                excelReader.getData("/Users/naveenautomationlabs/Desktop/automation.xlsx", sheetName);
        String heading= testData.get(rowNumber).get("subjectheading");
        String email = testData.get(rowNumber).get("email");
        String orderRef = testData.get(rowNumber).get("orderref");
        String message = testData.get(rowNumber).get("message");

        testSettings.contactUsClass.fillContactUsForm(heading,email,orderRef,message);
    }

    @And("user clicks on send button")
    public void userClicksOnSendButton() {
        testSettings.contactUsClass.sendButton.click();
    }

    @Then("it shows a successful message {string}")
    public void itShowsASuccessfulMessage(String expSuccessMessage) {
        String actualSuccessMessage = driver.getTitle();
        Assert.assertEquals(actualSuccessMessage,expSuccessMessage);
    }
}
