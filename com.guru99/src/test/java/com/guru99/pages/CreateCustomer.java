package com.guru99.pages;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;

import com.guru99.base.base;

public class CreateCustomer extends base{
	By linkCreateCust      = By.xpath("//a[text()='New Customer']");
	By inputCustName       = By.xpath("//input[@name='name']");
	By radioGenderMale     =By.xpath("//input[@name='rad1' and @value='m']");
	By radioGenderFemale   =By.xpath("//input[@name='rad1' and @value='f']");
	By dateDOB             =By.xpath("//input[@name='dob']");
	By inputAddress        =By.xpath("//textarea[@name='addr']");
	By inputCity           =By.xpath("//input[@name='city']");
	By inputState          =By.xpath("//input[@name='state']");
	By inputPin            =By.xpath("//input[@name='pinno']");
	By inputMobile         =By.xpath("//input[@name='telephoneno']");
	By inputEmail          =By.xpath("//input[@name='emailid']");
	By inputPassword       =By.xpath("//input[@name='password']");
	By btnSubmmit          =By.xpath("//input[@name='sub']");
	
	
	public void createCustomer(Map mp) throws InterruptedException {
		
		//read all the testdata from the Map object
		String custName,gender,DOB,address,city,state,pin,mobile,email,custPassword;
		custName     = mp.get("CustName").toString();
		gender       = mp.get("Gender").toString();
		DOB          = mp.get("DOB").toString();
		address      = mp.get("Address").toString();
		city         = mp.get("City").toString();
		state        = mp.get("State").toString();
		pin          = mp.get("PIN").toString();
		mobile       = mp.get("MobileNum").toString();
		email        = mp.get("Email").toString();
		custPassword = mp.get("Password").toString();
		
		
		
		Random rm = new Random();
		email = "toptech" +  rm.nextInt() + "@gmail.com";
		
		//perform the action on application
		libGeneric.clickElement(linkCreateCust);
		Thread.sleep(2000);
		libGeneric.enterData(inputCustName, custName);
		libGeneric.clickElement(radioGenderMale);
		libGeneric.enterData(dateDOB, DOB);
		
		libGeneric.clickElement(inputAddress);
		libGeneric.enterData(inputAddress, address);
		
		libGeneric.enterData(inputCity, city);
		libGeneric.enterData(inputState, state);
		libGeneric.enterData(inputPin, pin);
		libGeneric.enterData(inputMobile, mobile);
		libGeneric.enterData(inputEmail, email);
		libGeneric.enterData(inputPassword, custPassword);
		
		Thread.sleep(2000);
		libGeneric.clickElement(btnSubmmit);
		Thread.sleep(4000);
		
				
	}
}
