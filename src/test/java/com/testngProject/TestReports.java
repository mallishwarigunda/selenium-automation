package com.testngProject;




import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngUtilityPackage.CaptureScreen;

public class TestReports {

	static WebDriver driver;
    WebElement user,pwd,button;
	static CaptureScreen screens = new CaptureScreen();
	@BeforeTest
	public void startbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();

	}

     @Test(priority=0)
     public void  reports() throws IOException {
    	// File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      user = driver.findElement(By.name("user"));
      user.sendKeys("tester");
      //if you want capture fullScreen use this
     // FileUtils.copyFile(file, new File("./Test_ScreenShots/username.png"));
     // screens.CaptureScreenshot(driver,"username");
      
     //if you want capture particular element then use element 
      screens.CaptureScreenshot(driver,user,"username");
      pwd =  driver.findElement(By.name("pass"));
      pwd.sendKeys("admin");
      screens.CaptureScreenshot(driver,pwd, "password");
      button =  driver.findElement(By.name("btnSubmit"));
      button.click();
     
   }
	@Ignore
	@AfterMethod
	public void failed_report(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			
			try {
				System.out.println(result);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@AfterTest
	public void closereport() {
		driver.close();
	}

}
