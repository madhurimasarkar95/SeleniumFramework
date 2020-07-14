package Framework.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;

	By email= By.id("login_field");
	By password =By.id("password");
	

	By submit= By.cssSelector("input[value*='Sign in']");
	
	
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		}
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
	
	
	
}