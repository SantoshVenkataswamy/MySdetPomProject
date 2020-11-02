package TestNgListeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Factories.BrowserFactory;
import Factories.ReporterFactory;
import pageObjects.BasePage;
import testCases.BaseTest;




public class TestListener extends BaseTest implements ITestListener 
{
	WebDriver driver;
	
	
	BasePage base = new BasePage(driver);
	BrowserFactory factory = new BrowserFactory();
	//BasePage bp = new BasePage(driver);
	//Logger log = base.printLog(TestListener.class);
	
	BasePage bp = new BasePage(driver);
	Logger log = bp.printLog(TestListener.class);
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void onTestFailure(ITestResult arg0) {
		Object currentClass = arg0.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();
		//ReporterFactory.getReporter().Error("******* Error: test case " + arg0.getName() + " has failed *******" );
		//String methodName=arg0.getName().toString().trim();		
		//takeScreenShot(driver, browserName);			
		//ReporterFactory.getReporter().StopTest(arg0.getName());
		
		log.info("TestListener - onTestFailure method...");
		String name = arg0.getTestClass().getRealClass().getSimpleName() + "_" + arg0.getMethod().getMethodName();	
		log.info("Test Method name is: "+name);
		try {
			takeScreenShot(driver, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
/*	public void takeScreenShot(WebDriver driver, String browserName) {
		
		driver = factory.getBrowser(browserName);
		//WebDriver driver = BrowserFactory.getBrowser();
		//String date = DataProviderFactory.getDateFormat();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String filePath = DataProviderFactory.getConfigurationDataProvider().getScreenShotFolder();
		//String filePath = System.getProperty("user.dir")+"\\ScreenShots\\"+;
		String filePath = System.getProperty("user.dir")+"\\ScreenShots\\";
        
		//filePath = new File(System.getProperty("user.dir")+ScreenShots+date).mkdirs();
		
		//The below method will save the screen shots in D:\Screenshots with test method name 
        try {
        	FileUtils.copyFile(scrFile, new File(filePath+methodName+".jpg"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
		}
	}*/
	
	/** 
	 * This method is to capture Screen shot  
	 * @param1: driver - driver instance 
	 * @param2: filename - method name which has failed
	 * @throws IOException
	 * */
	public void takeScreenShot(WebDriver driver, String filename) throws IOException{
		log.info("take screenshot");
		String date=getDateTime().split(" ")[0];		
		date=date.replaceAll("/", "_");

		filename = filename+"_"+ date;		
		String currentDir = System.getProperty("user.dir");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dstFile = new File(currentDir+"\\ScreenShots\\"+filename+".jpg"); 
		if(dstFile.exists()){
			dstFile.delete();
		}
		FileUtils.copyFile(srcFile, dstFile);
	}


	public void onTestSkipped(ITestResult arg0) {
		log.info("*****Test method Skipped******* : "+ arg0.getName());
		
	}


	public void onTestStart(ITestResult arg0) {
		log.info("*****Test method Stated******* : "+ arg0.getMethod().getMethodName());
		
		
		ReporterFactory.getReporter().StartTest(arg0.getName());
		
	}

	
	public void onTestSuccess(ITestResult arg0) {
		
		log.info("*****Test method Passed******* : "+ arg0.getName());

		ReporterFactory.getReporter().Log(" This Test Passed: " + arg0.getName());
		
		ReporterFactory.getReporter().StopTest(arg0.getName());
		
	}

}
