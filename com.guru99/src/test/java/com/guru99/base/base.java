package com.guru99.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import com.guru99.pages.CreateCustomer;
import com.guru99.pages.home;
import com.guru99.pages.login;

import personalPractice.excelUtil;

public class base {

	public static WebDriver driver;
	public static Properties propConfig;
	public static genric libGeneric;
	public static excelUtil excel;
	
	//create page objects
	public static CreateCustomer pgcustomer;
	public static home pgHome;
	public static login pgLogin;
	
	//create a log4j object
	public static Logger Log;//
	
	static {
		
		Log = Logger.getLogger(Log.class.getName());
		
		//update home page objects
		pgcustomer = new CreateCustomer();
		pgHome     = new home();
		pgLogin    = new login();
		
		excel = new excelUtil();
		libGeneric = new genric();
		
		propConfig = new Properties();
		FileInputStream fl = null;
		try {
			fl = new FileInputStream("F:\\Training Stuff\\SeleniumTraining\\selenium\\src\\test\\resources\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			propConfig.load(fl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
