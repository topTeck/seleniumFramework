package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guru99.base.base;
import com.guru99.base.webDriverManager;

public class login extends base{
	
	//WebDriver driver;
	
	//public login(WebDriver dr) {
	//	driver = dr;
	//}
	
	//keep all my locators
	By userid   = By.xpath("//input[@name='uid']");
	By passWord = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@name='btnLogin']");
	By resetBtn = By.xpath("//input[@name='btnReset']");
	
	
	//add the methods
	public void enterUserName(String userName) throws InterruptedException {
		libGeneric.enterData(userid,userName);
		//driver.findElement(userid).sendKeys(userName);
	}
	
	public void enterPass(String val) {
		driver.findElement(passWord).sendKeys(val);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickReset() {
		driver.findElement(resetBtn).click();
	}
	
	public void doLogin(String a, String b) {
		driver.findElement(userid).sendKeys(a);
		driver.findElement(passWord).sendKeys(b);
		driver.findElement(loginBtn).click();
	}
	
	public boolean isErrorDisplayed() {
		try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (Exception ex) 
	    { 
	    	System.out.println(ex.getMessage());
	        return false; 
	    }   // catch 
	}
	
	public String getAllertMessage() {
		return driver.switchTo().alert().getText();
		
	}
	

}
