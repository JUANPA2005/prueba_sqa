package com.sqa.prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private WebDriver driver;
	private static final String key = "webdriver.chrome.driver";
	private static final String value = "src/test/resources/drivers/chromedriver";
	
	public Driver() 
	{
		System.setProperty(key,value);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public WebDriver getWebDriver() 
	{
		return driver;
	}
}
