package com.roc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roc.qa.base.TestBase;
import com.roc.qa.pages.HomePage;
import com.roc.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "ROC");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
