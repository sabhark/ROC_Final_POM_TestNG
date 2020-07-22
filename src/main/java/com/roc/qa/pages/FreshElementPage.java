package com.roc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.roc.qa.base.TestBase;

public class FreshElementPage extends TestBase
{
	
	@FindBy(id="eltName")
	@CacheLookup
	WebElement eltName;
	
	@FindBy(id="eltDigits")
	@CacheLookup
	WebElement eltDigits;
	
	@FindBy(id="elementDetail.save")
	@CacheLookup
	WebElement elementDetailsave;
	
	@FindBy(xpath="//div[@id='elementPanel']/table/tbody/tr[2]/td[3]/table\"\r\n" + 
			"				+ \"/tbody/tr[2]/td/div[1]/a/span")
	WebElement selectclass;
	
	public FreshElementPage() throws InterruptedException{
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	
	
	public void createnewelementset(String elementname, String matchvalue) throws InterruptedException
	{
		Thread.sleep(5000);
		
		eltName.sendKeys(elementname);
		
		eltDigits.sendKeys(matchvalue);
		
		Thread.sleep(15000);
		
		//Select selcountry = new Select(selectclass);
		
		//selcountry.selectByVisibleText(country);
		
		elementDetailsave.click();
		Thread.sleep(5000);
	}
	
	
	

}
