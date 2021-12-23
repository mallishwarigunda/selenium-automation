package com.testngProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectSample.BasicTest;

import testngUtilityPackage.BrowserFactory;
import testngUtilityPackage.Login_pageObjects;

public class LoginTest extends BasicTest{

	
	public Login_pageObjects loginpage;
	// static BrowserFactory  launch_browser ;

	 @BeforeTest
	public void getBrowser() {
		startBrowser("chrome",  "https://www.mycontactform.com/");
	 }
		 
	
  @Parameters({"username","password"})
	@Test (priority =0)
	public void verify_validcredentials(String username,String password) {
		System.out.println("Test 1********************************");
		
		loginpage = PageFactory.initElements(BrowserFactory.driver, Login_pageObjects .class);
        loginpage.getusername(username).getpassword(password).getvalidation().getsignout();

	}
	@Parameters({"uname","password"})
	@Test (priority =1)
	public void verify_invalidcredentials(String uname,String password) {
		System.out.println("Test 2*********************");
		
		loginpage = PageFactory.initElements(BrowserFactory.driver, Login_pageObjects .class);
		loginpage.getusername(uname).getpassword(password).getvalidation();

   }
	
	
}
