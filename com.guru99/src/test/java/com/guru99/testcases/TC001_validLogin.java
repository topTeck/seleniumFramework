package com.guru99.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.base.base;
import com.guru99.base.webDriverManager;
import com.guru99.pages.home;
import com.guru99.pages.login;

import personalPractice.excelUtil;

public class TC001_validLogin extends base{

	//invoke the URL
	//with correct username and pas will do the login
	//validate that hom page is displayed
	
	
	String testID = "TC001_ValigLogin";
	String sheetName = "login";
	
	@BeforeClass
	void setup() throws IOException {
		webDriverManager.initBrowser();
	}
	
	@Test(dataProvider = "getData")
	void TC001_validLogin(Map mp) throws InterruptedException {
		
		String userName = mp.get("UserName").toString();
		String passWord = mp.get("Password").toString();
		String expectedMessage  = mp.get("Message").toString().toLowerCase().trim();
		
		driver.get(propConfig.getProperty("url_test"));
		Thread.sleep(3000);
		pgLogin.doLogin(userName,passWord);
		
		//validate error popup
		Assert.assertFalse(pgLogin.isErrorDisplayed());
	
		
		////td[contains(text(),'Manger ')]
		Assert.assertTrue(pgHome.isHomePage());
		
		//validate the text
		String loginText = libGeneric.getText("//td[contains(text(),'Manger')]");
		Assert.assertEquals(loginText, expectedMessage);
		Thread.sleep(2000);
		
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
