package com.roc.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.roc.qa.base.TestBase;
import com.roc.qa.pages.ElementPage;
import com.roc.qa.pages.FreshElementPage;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = "D:\\Workspaces\\ROC_Web\\Framework\\src\\main\\java\\com\\roc\\qa\\testdata\\ROC_TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	
	
	
	
	/*@FindBy(xpath="//div[contains(text(),'Common Tasks')]")
	WebElement common_Task;
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement create_new;	
	*/
	public void switctoFrame()
	{
		
		driver.switchTo().frame("new");
	}
	
	/*Need to revisit this*/
	/*public FreshElementPage createNew() throws InterruptedException
	{
		common_Task.click();
		create_new.click();
		Thread.sleep(5000);
		return new FreshElementPage();
		
		
	}*/
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir + "//screenshots//" + System.currentTimeMillis() + ".png"));
	
				//FileUtils.copyFile(scrFile, new File(currentDir+ "//screenshots//"));
	}
	
	

}


