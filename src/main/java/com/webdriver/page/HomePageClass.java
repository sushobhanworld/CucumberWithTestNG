package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {
	
	private WebDriver driver;
	
	public HomePageClass(WebDriver driver){
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID,using = "enter_bug")
	public WebElement fileABuglink;
	@FindBy(how = How.ID,using = "quicksearch_main")
	public WebElement quickSearchTextBox;
	

	public PageBase navigateToLoginPage(){
		LoginPageClass loginPage = new LoginPageClass(driver);
		fileABuglink.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
		return loginPage;
	}	

}
