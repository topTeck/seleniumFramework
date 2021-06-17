package com.guru99.base;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class genric extends base {

	
	WebElement el;
	public void enterData(By obj, String data) throws InterruptedException {
		el = driver.findElement(obj);
		if(el.isDisplayed() && el.isEnabled()) {
			
			/*
			 * el.click(); if(obj.toString().equals("dateDOB")) { Thread.sleep(3000);
			 * for(int i=0; i<8 ; i++) { el.sendKeys(Keys.BACK_SPACE); }
			 * 
			 * }
			 */
			
			Thread.sleep(1000);
			el.sendKeys(data);
			Log.info("entered data " + data);
		}
	}
	
	
	//click element param - webelement
	public void clickElement(WebElement el) {
		if(el.isDisplayed() && el.isEnabled()) {
			el.click();
			Log.info("clicked element " + el.toString());
		}		
	}
	
	//click element - param - By class object
	public void clickElement(By obj) {
		WebElement el = driver.findElement(obj);
		if(el.isDisplayed() && el.isEnabled()) {
			el.click();
			Log.info("clicked element " + el.toString());
		}
		
	}
	
	
	//create a method, that will return the test based on the xpath that I send
	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText().trim().toLowerCase();
	}
	
	
	

}
