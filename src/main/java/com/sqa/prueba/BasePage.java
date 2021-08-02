package com.sqa.prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver pDriver) 
	{
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 15);
		driver = pDriver;
	}
	
	public BasePage(WebDriver pDriver, int initOutInSec) 
	{
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, initOutInSec);
		driver = pDriver;
	}
	
	public WebDriverWait getWait() 
	{
		return wait;
	} 
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	public void dispose() 
	{
		if(driver != null) 
		{
			driver.quit();
		}
	}
}