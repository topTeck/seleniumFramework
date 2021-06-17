package com.guru99.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverManager extends base{
	
	public static void initBrowser() throws IOException {
		
		String browser = propConfig.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:\\Training Stuff\\SeleniumTraining\\com.guru99\\src\\test\\resources\\com\\browser\\binaries\\chromedriver.exe" );
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver","F:\\Training Stuff\\SeleniumTraining\\selenium\\src\\test\\resources\\com\\browser\\binaries\\geckodriver.exe" );
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
