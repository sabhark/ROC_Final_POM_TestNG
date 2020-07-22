package com.roc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.roc.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR:
			@FindBy(id="id-welcome-name")
			WebElement login_username;
			
			@FindBy(id="navigationLabel")
			WebElement navigationLabel;
			
			@FindBy(id="id-Task Search")
			WebElement TaskSearchLink;
			
			@FindBy(id="id-Collected Files")
			WebElement CollectedFilesLink;
			
			@FindBy(id="tasksummary")
			WebElement SummaryunderTaskpage;
			
			@FindBy(id="id-Elements")
			WebElement ElementsLink;
			
			//Initializing the Page Objects:
			
			public HomePage() throws InterruptedException{
				PageFactory.initElements(driver, this);
				Thread.sleep(5000);
			}
			
			
			//Actions:
			public String validateHomePageTitle(){
				return driver.getTitle();
			}
			
			
			public String validateloginUser(){
				return login_username.getText();
			
				
			}
			
			public TaskSearchPage validateTaskSearchPage() throws InterruptedException{
				navigationLabel.click();
				TaskSearchLink.click();
				return new TaskSearchPage();
				
				
			}
	
	
	
			public CollectedFilesPage validateCollectedFilePage() throws InterruptedException{
				navigationLabel.click();
				CollectedFilesLink.click();
				return new CollectedFilesPage();
				
				
			}
	
	
			public TaskSearchPage summaryundertasksearchPage() throws InterruptedException{
				navigationLabel.click();
				TaskSearchLink.click();
				SummaryunderTaskpage.click();
				return new TaskSearchPage();
				
				
			}
	
	
	public ElementPage clickonelementpage() throws InterruptedException
	{
		
		navigationLabel.click();
		ElementsLink.click();
		return new ElementPage();
	}
	
	
	

}
