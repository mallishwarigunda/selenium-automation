package testngUtilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

public static WebDriver driver;
  
public static void startBrowser(String browsertype,String appurl) {
	
	if(browsertype.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("----start-maximizied");
		driver= new ChromeDriver();
		
	}else if(browsertype.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if(browsertype.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(appurl);

}	


	
}
