package com.projectSample;

import org.testng.annotations.AfterTest;
import testngUtilityPackage.BrowserFactory;


public  class BasicTest {
	
  //  public static WebDriver driver;
    //static BrowserFactory  launch_browser ;

	
	public void startBrowser(String browser,String url) {
		BrowserFactory.startBrowser("chrome", "https://www.mycontactform.com/");
		
	 }
	
	 @AfterTest
	 public void closeTest() {
		 BrowserFactory.driver.close();
		 
	 }
}
