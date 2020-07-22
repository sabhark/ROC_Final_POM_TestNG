package com.roc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roc.qa.base.TestBase;
import com.roc.qa.pages.CollectedFilesPage;
import com.roc.qa.pages.HomePage;
import com.roc.qa.pages.LoginPage;
import com.roc.qa.pages.TaskSearchPage;
import com.roc.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TaskSearchPage tasksearchpage;
	CollectedFilesPage collectedFilesPage;
	TestUtil testutil;
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//tasksearchpage = new TaskSearchPage();
		
	}
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String homepagetitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "ROC - Subex Ltd - Home Dashboard","Home Page title not matched");
	}
	
	
	@Test(priority=2)
	public void LoginUserTest()
	{
		String loginusername = homePage.validateloginUser();
		Assert.assertEquals(loginusername, "Welcome Root", "Login User name not matched");
		
	}
	
	
	@Test(priority=3)
	public void TaskSearchPageTest() throws InterruptedException
	{
		tasksearchpage = homePage.validateTaskSearchPage();
	}
	
	@Test(priority=4)
	public void CollectedFilesTest() throws InterruptedException
	{
		collectedFilesPage = homePage.validateCollectedFilePage();
	}
	
	@Test(priority=5)
	public void ExportButtonUnderTaskSummaryTest() throws InterruptedException
	{
		
		tasksearchpage = homePage.summaryundertasksearchPage();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
