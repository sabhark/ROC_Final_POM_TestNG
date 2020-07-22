package com.roc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.roc.qa.base.TestBase;
import com.roc.qa.util.TestUtil;

public class ElementPage extends TestBase{
	
	TestUtil testUtil;
	//Page Factory - OR:
	
	@FindBy(id="eltName")
	WebElement ElementName;
	
	@FindBy(id="formTitle")
	WebElement formTitle;
	
	@FindBy(id="filterpanel-header-label")
	WebElement filterpanel_header;
	
	@FindBy(xpath="//div[contains(text(),'Common Tasks')]")
	WebElement common_Task;
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement create_new;
	
	
	//Initializing the Page Objects:
	
	public ElementPage() throws InterruptedException{
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	
	
	//Actions:
	
	public Boolean validate_filterpanel_header(){
		return filterpanel_header.isDisplayed();
	
		
	}
	
	
	public String validate_filterpanel_header_title(){
		return filterpanel_header.getText();
	
		
	}
	
	public String validate_create_new() throws InterruptedException{
		common_Task.click();
		create_new.click();
		Thread.sleep(5000);
		return formTitle.getText();
	
		
		
	}
	
	
	public FreshElementPage Newelementpage() throws InterruptedException
	{
		common_Task.click();
		create_new.click();
		Thread.sleep(5000);
		return new FreshElementPage();
	}
	
	

}
