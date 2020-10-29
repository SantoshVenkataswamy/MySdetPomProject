package Factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import testCases.BaseTest;

/*
 * This class can do the following"
 * - To create required Webdriver
 * - To maintain an instance of a Webdriver
 */
public class BrowserFactory extends BaseTest
{
	
	
	public WebDriver getBrowser(String browserName) throws MalformedURLException
	{
		DesiredCapabilities cap = null;
		
		if (browserName.equals("Firefox"))
		{
		  //if (driver == null)
		  //{
			  	cap = DesiredCapabilities.firefox();
			  	cap.setPlatform(Platform.WINDOWS);
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//java//exe//geckodriver.exe");
				//driver = new FirefoxDriver();
		
			
		//}
		  //else
		 // {
			 // return driver;
		  //}
		}
//			else if (browserName.equals("InternetExplorer"))
//			{
//				System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfigurationDataProvider().getIEServerPath());
//				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//				dc.setCapability("requireWindowFocus", true);
//				dc.setCapability("nativeEvents", false);
//				dc.setCapability("enable_persistent_hovering", true);
//				driver = new InternetExplorerDriver();
//			}
			else if (browserName.equals("Chrome"))
			{
				//if (driver == null)
				//{
					cap = DesiredCapabilities.chrome();
				  	cap.setPlatform(Platform.WINDOWS);	
				  	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//exe//chromedriver.exe");

				  	//driver = new ChromeDriver();
				
			    //}
				//else
				//{
					//return driver;
				//}
			}
			long pageLoadTimeOut = DataProviderFactory.getConfigurationDataProvider().getPageLoadTimeOut();
			long implicitWait = DataProviderFactory.getConfigurationDataProvider().getImplicitWait();
		    
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);   
		    driver.manage().window().maximize();
		    return driver;
		  }
			
	   
	
public WebDriver getBrowser()
	{
		return driver;
	}
	
	public static void closeWebDriver()		
		{		
		//driver.quit();
		driver.quit();
		//return driver;
		}

}
