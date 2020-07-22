package com.roc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.roc.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(name="userName")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(id="btn")
		WebElement loginBtn;
	
		//Initializing the Page Objects:

		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd) throws InterruptedException{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();

}
}

