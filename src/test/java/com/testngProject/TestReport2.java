package com.testngProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngUtilityPackage.CaptureScreen;

public class TestReport2 {

	static WebDriver driver;
    WebElement gmail,image;
	static CaptureScreen screens;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeSuite
	public void setupSuite() {
		screens = new CaptureScreen();	
		report = new ExtentReports("./ExtentReports./myTestReport.html");
		test = report.startTest("verifying gamil link");
		
	}
	
	
	@BeforeTest
	public void startbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        test.log(LogStatus.INFO,"Browser started");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO,"maximized browser");

	}
    @Test(priority=0)
	public void gmail_link() {
	   gmail = driver.findElement(By.xpath("//a[contains(text(),\"Gmail\")]"));
	   String exp = gmail.getText();
	   test.log(LogStatus.INFO, exp);
	   String act = "Gmail";
	   Assert.assertEquals(exp, act);
	   if(exp.equals(act)) {
		   test.log(LogStatus.PASS,"step verfied");
	   }else {
		   test.log(LogStatus.FAIL,"step failed");
	   }
		   
	}
/*    
  @Test(priority=1)
  public void image_link() {
	  image = driver.findElement(By.xpath("//a[contains(text(),\"Images\")]"));
	  String exp = image.getText();
	  test.log(LogStatus.INFO, exp);
	  String act = "images";
	  Assert.assertEquals(exp, act);
	  if(exp.equals(act)) {
		   test.log(LogStatus.PASS,"step verfied");
	   }else {
		   test.log(LogStatus.FAIL,"step failed");
	   }
		   
		   
  }
   */
	@AfterMethod
	public void failed_report(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			
			try {
				System.out.println(result);
				test.log(LogStatus.FAIL,"step failed",test.addScreenCapture(screens.CaptureScreenshot(driver,gmail, "gmail link Failed")));
				screens.CaptureScreenshot(driver,gmail, "gmail link Failed");
				Thread.sleep(3000);
				test.log(LogStatus.FAIL,"step failed",test.addScreenCapture(screens.CaptureScreenshot(driver,image, "image link Failed")));
				screens.CaptureScreenshot(driver,image,"image link failed");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@AfterTest
	public void closereport() {
		report.flush();
		driver.close();
	}
	
}
