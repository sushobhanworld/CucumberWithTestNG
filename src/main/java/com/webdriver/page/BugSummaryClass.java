package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BugSummaryClass extends PageBase{
    private WebDriver driver;

    public BugSummaryClass(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @FindBy(how = How.ID,using = "commit")
    public WebElement saveChanges;
    @FindBy(how=How.ID,using= "comment")
    public WebElement additionalcomments;
    @FindBy(how=How.ID,using = "bug_status")
    public WebElement bugstatus;
}
