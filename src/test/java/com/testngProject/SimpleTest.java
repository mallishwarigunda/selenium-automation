package com.testngProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testngUtilityPackage.BrowserFactory;

public class SimpleTest {
	
	static WebDriver driver;

    //testng attributes invocationCount = 3,timeOut=3,groups="a")
	
	@BeforeTest
	public void startbrowser(String type, String url_value) {
		
		BrowserFactory.startBrowser( type, url_value);
	
	}

	@Test
	public void testcase() {
		
	driver.findElement(By.name("user")).sendKeys("tester");
	driver.findElement(By.name("pass")).sendKeys("admin");
	driver.findElement(By.name("btnSubmit")).click();
	driver.close();

	}
}

