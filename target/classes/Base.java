package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\Resources\\Data.properties");
	prop.load(fis);
	String BrowserName=prop.getProperty("Browser");
	System.out.println(BrowserName);
	
	if (BrowserName.equals("Chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumFramework\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	
	else if (BrowserName.equals("Firebox")) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumFramework\\geckodriver.exe");
		driver= new FirefoxDriver();	
	}
	
	else if (BrowserName.equals("IE")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumFramework\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();	
	
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	
public String takescreenshot(String testcaseName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;

}
}
