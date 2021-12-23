package testngUtilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Login_pageObjects {

 static WebDriver driver;
	
	@FindBy(name="user")WebElement username;
	@FindBy(name="pass")WebElement password;
	@FindBy(name="btnSubmit")WebElement button;
	@FindBy(xpath="//*[@id=\"user_bar\"]/ul/li[1]/a")WebElement signout;
	
	public Login_pageObjects getusername(String un) {
		username.sendKeys(un);
	
		return this;
	}
	
	
	public Login_pageObjects getpassword(String pwd) {
		password.sendKeys(pwd);
		
		return this;
	}
	
	public Login_pageObjects getvalidation() {
		if(button.isEnabled())
			button.click();
		return this;
	}
	
	public Login_pageObjects getsignout() {
		signout.click();
		return this;
		
		
	}
	
}
