package Framework.SeleniumFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import Resources.Base;

public class Homepage extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@Test
	public void BasePageNavigation() throws IOException {
		Properties prop = new Properties();
		FileInputStream load= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\Resources\\Data.properties");
		prop.load(load);
		
		
		driver=initializeDriver();
		driver.get("https://github.com/");
		LandingPage lp= new LandingPage(driver);
		lp.getlogin().click();
		loginPage login=new loginPage(driver);
		login.getemail().sendKeys(prop.getProperty("email"));
		login.getpassword().sendKeys(prop.getProperty("password"));		
		login.Submit().click();
			
		driver.close();
		log.info("Successful");
		
	}
	
}
