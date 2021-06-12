package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass extends PageBase {
	
	private WebDriver driver;
	
	public LoginPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	

	@FindBy(how = How.ID,using = "Bugzilla_login")
	public WebElement username;
	@FindBy(how = How.ID,using = "Bugzilla_password")
	public WebElement password;
	@FindBy(how = How.ID,using = "log_in")
	public WebElement loginButton;

	public PageBase login(String user,String pass){
		EnterBugClass enterBug = new EnterBugClass(driver);
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(enterBug.severity));
		return enterBug;
	}

}
