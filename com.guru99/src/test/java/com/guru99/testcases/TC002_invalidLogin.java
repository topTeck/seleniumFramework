package com.guru99.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.guru99.base.base;
import com.guru99.base.webDriverManager;

public class TC002_invalidLogin extends base{
	
	String testID = "TC002_InvalidLogin";
	String sheetName = "login";
	
	@BeforeClass
	void setup() throws IOException {
		webDriverManager.initBrowser();
	}
	
	@Test(dataProvider = "getData")
	void TC002_InvalidLogin(Map mp) throws InterruptedException {
		
		
		String execute  = mp.get("Execute").toString().toUpperCase().trim();
		
		if(execute.equals("YES")) {
			String userName = mp.get("UserName").toString();
			String passWord = mp.get("Password").toString();
			String expectedMessage  = mp.get("Message").toString().toLowerCase().trim();
			
			driver.get(propConfig.getProperty("url_test"));
			Thread.sleep(3000);
			pgLogin.doLogin(userName,passWord);
			
			//validate error popup
			Assert.assertTrue(pgLogin.isErrorDisplayed());
		
			//get the errro message from app
			String actualMessage = pgLogin.getAllertMessage().toLowerCase().trim();
			
			//validate error message
			Assert.assertEquals(actualMessage,expectedMessage);  //compares the values
			
			
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		
	}
	
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider
	Object[][] getData() throws IOException {
		return excel.getTestData(testID, sheetName);
	}
}
