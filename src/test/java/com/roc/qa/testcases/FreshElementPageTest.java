package com.roc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.roc.qa.base.TestBase;
import com.roc.qa.pages.ElementPage;
import com.roc.qa.pages.FreshElementPage;
import com.roc.qa.pages.HomePage;
import com.roc.qa.pages.LoginPage;
import com.roc.qa.util.TestUtil;

public class FreshElementPageTest extends TestBase{
	
	
	ElementPage elementPage;
	FreshElementPage freshElementPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	String sheetname = "New_Element";
	
	public FreshElementPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		elementPage = homePage.clickonelementpage();
		freshElementPage = elementPage.Newelementpage();
		
	}
	
	@DataProvider
	public Object[][] getROCTestData()
	{
		Object data [][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=1, dataProvider = "getROCTestData")
	public void newelementnametest(String elementname, String matchvalue) throws InterruptedException
	{
		
		//freshElementPage.createnewelementset("test123","234");
		freshElementPage.createnewelementset(elementname, matchvalue);
		
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
