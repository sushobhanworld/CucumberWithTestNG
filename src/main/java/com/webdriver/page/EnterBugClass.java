package com.webdriver.page;

import com.webdriver.helper.DropdownHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EnterBugClass extends PageBase{
    private WebDriver driver;

    public EnterBugClass(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @FindBy(how = How.ID,using = "bug_severity")
    public WebElement severity;
    @FindBy(how = How.ID,using = "rep_platform")
    public WebElement hardware;

    @FindBy(how = How.ID,using = "op_sys")
    public WebElement os;
    @FindBy(how = How.ID,using = "short_desc")
    public WebElement summary;
    @FindBy(how = How.ID,using = "comment")
    public WebElement description;
    @FindBy(how = How.ID,using = "commit")
    public WebElement submitbug;

    public PageBase enterBugDetails(String bugSeverity, String hardwareType, String osName, String shortSummary,String comment){
        DropdownHelper dropdownHelper= DropdownHelper.getInstance(driver);
        dropdownHelper.selectByValue(severity, bugSeverity);
        dropdownHelper.selectByValue(hardware, hardwareType);
        dropdownHelper.selectByValue(os, osName);
        summary.sendKeys(shortSummary);
        description.sendKeys(comment);
        submitbug.click();
        return new BugSummaryClass(driver);
    }
}
