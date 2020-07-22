package com.roc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roc.qa.base.TestBase;
import com.roc.qa.pages.ElementPage;
import com.roc.qa.pages.FreshElementPage;
import com.roc.qa.pages.HomePage;
import com.roc.qa.pages.LoginPage;
import com.roc.qa.pages.TaskSearchPage;
import com.roc.qa.util.TestUtil;

public class ElementPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ElementPage elementPage;
	TaskSearchPage tasksearchpage;
	TestUtil testUtil;
	FreshElementPage freshElementPage;
	//ElementPage elementPagecreatenew;
	
	public ElementPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		elementPage = homePage.clickonelementpage();
		
	}
	
	
	
	/*@Test(priority=1)
	public void PageHeaderlabelTest() throws InterruptedException
	{
		
		boolean pageheaderlabelresult = elementPage.validate_filterpanel_header();
		Assert.assertEquals(pageheaderlabelresult, true);
		//Assert.assertTrue(pageheaderresult);
		
	}
	
	
	@Test(priority=2)
	public void PageHeaderTitleTest()
	{
		
		String headerTitle= elementPage.validate_filterpanel_header_title();
		Assert.assertEquals(headerTitle,"Element Search", "title not matched");
		
	}*/
	
	/*This is the another way, which are combined 1 and 2*/
	/*@Test(priority=3)
	public void PageHeaderlabelTest22()
	{
		
		boolean pageheaderlabelresult = elementPage.validate_filterpanel_header();
		if(pageheaderlabelresult=true)
		{
			String headerTitle= elementPage.validate_filterpanel_header_title();
			Assert.assertEquals(headerTitle,"Element Search", "title not matched");
			
			
			
		}

		
	}*/
	
	
	@Test(priority=2)
	public void createnewpageTest() throws InterruptedException
	{
		String createnewelementpageTitle= elementPage.validate_create_new();
		Assert.assertEquals(createnewelementpageTitle,"Element", "title not matched");
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
