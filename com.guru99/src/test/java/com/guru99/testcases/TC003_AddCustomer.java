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

public class TC003_AddCustomer extends base{
	
	String testID = "TC003_NewCust";
	String sheetName = "Customer";
	
	@BeforeClass
	void setup() throws IOException {
		webDriverManager.initBrowser();
	}
	
	@Test(dataProvider = "getData")
	void createCust(Map mp) throws InterruptedException {
		
		String execute  = mp.get("Execute").toString().toUpperCase().trim();
		if(execute.equals("YES")) {
			String userName = propConfig.getProperty("userName");
			String passWord = propConfig.getProperty("passWord");
			
			driver.get(propConfig.getProperty("url_test"));
			Thread.sleep(3000);
			pgLogin.doLogin(userName,passWord);		
			
			//get the test data
			pgcustomer.createCustomer(mp);
			
			//if the message Customer Registered Successfully!! is displayed - tc passed
			
			//final step - validate the data on the success page
			
		}
	}
	
	
	@AfterClass
	void closeBrowser() {
		//driver.quit();
	}
	
	@DataProvider
	Object[][] getData() throws IOException {
		return excel.getTestData(testID, sheetName);
	}
}
