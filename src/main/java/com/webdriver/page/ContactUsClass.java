package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ContactUsClass extends PageBase{
    private WebDriver driver;
    public ContactUsClass(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
    }

    @FindBy(how = How.ID, using = "id_contact")
    public WebElement subjectHeading;
    @FindBy(how = How.ID, using = "email")
    public WebElement email;
    @FindBy(how = How.ID, using = "id_order")
    public WebElement orderRef;
    @FindBy(how = How.ID, using = "message")
    public WebElement messageText;
    @FindBy(how = How.ID, using = "submitMessage")
    public WebElement sendButton;
    @FindBy(how = How.CSS, using = "div#center_column p")
    public WebElement successMsg;

    public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
        Select select = new Select(subjectHeading);
        select.selectByVisibleText(heading);
        email.sendKeys(emailId);
        orderRef.sendKeys(orderReference);
        messageText.sendKeys(message);
    }
}
