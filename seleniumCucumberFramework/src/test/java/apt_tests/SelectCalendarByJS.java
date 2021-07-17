package apt_tests;

import java.util.concurrent.TimeUnit;

import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class SelectCalendarByJS {
	BrowserUtils utils = new BrowserUtils();
	
	
	public static void main(String[] args) {
		Driver driver = new Driver();	// this created a new driver
		//	this reads the url property from the PropertyReader File
		driver.getDriver().get(PropertiesReader.getProperty("spiceJetUrl"));
		driver.getDriver().manage().window().maximize();
		driver.getDriver().manage().deleteAllCookies();
		
		driver.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		
		
	}

}
