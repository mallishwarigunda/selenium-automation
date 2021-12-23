package testngUtilityPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureScreen {

  static WebDriver driver;
  
  public String CaptureScreenshot(WebDriver driver,WebElement element,String screenname) throws IOException{
	  // this for full screen
	  //File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  //this is for particular element
	  File file = element.getScreenshotAs(OutputType.FILE);
	  String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());;
	  File dest = new File("./Test_ScreenShots/"+screenname+datename+".png");
	  String destpath =dest.getAbsolutePath();
	  FileUtils.copyFile(file, dest);
	  
	  return destpath;
	  
  }
	
	
}
