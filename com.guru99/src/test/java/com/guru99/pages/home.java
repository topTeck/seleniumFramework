package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.guru99.base.base;
import com.guru99.base.webDriverManager;

public class home extends base{
	//WebDriver driver;
	
	//public home(WebDriver dr) {
	//	driver = dr;
	//}
	
	By loginConfirmation = By.xpath("//td[text()='Manger Id : mgr123']");
	By newCust           = By.xpath("//a[text()='New Customer']");
	
	public void validateLogin() {
		if(driver.findElement(loginConfirmation).isDisplayed()){
			System.out.println("Login successfull");
		}else {
			System.out.println("Login failed - plz try again");
		}
	}
	
	public void clickNewCust() {
		driver.findElement(newCust).click();
	}
	
	public boolean isHomePage() {
		if(driver.findElement(By.xpath("//td[contains(text(),'Manger')]")).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
}
