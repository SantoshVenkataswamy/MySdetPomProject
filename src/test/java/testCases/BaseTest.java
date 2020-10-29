package testCases;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;

public class BaseTest 
{
	//WebDriver driver = BrowserFactory.getBrowser();
	public static WebDriver driver;
	
	HomePage homePage;
	public SoftAssert softAssert=new SoftAssert();
	public WebDriver getDriver() {
		return driver;
	}

	/*
	 * @BeforeClass (alwaysRun = true) public void setUp() {
	 * 
	 * }
	 */
	

	
	public void waitFor(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickWhenReady(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}
	
	
	public void waitForElementToLoad(String path)
	{

		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}
	
	
	public void waitForElementToLoadPage()
	{

		WebDriverWait wait = new WebDriverWait(driver, 120);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class='windowBackground' and contains(@eventproxy,'isc_LocateWait')])[last()]")));
	}
	public void waitForElementToLoadPage(int number)
	{

		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class='windowBackground'])["+number+"]")));
	}
	protected void waitForSeconds(double d)
	{
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForPageLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver wdriver) {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
		}
		});
	}

	public void switchToSecondWindow(WebDriver driver) 
	{
		Set<String> handles = driver.getWindowHandles();
		 
		String firstWinHandle = driver.getWindowHandle(); 
		
		String secondWinHandle;
		 
		handles.remove(firstWinHandle);
		 
		String winHandle=(String) handles.iterator().next();
		 
		if (winHandle!=firstWinHandle){
		 
			//To retrieve the handle of second window, extracting the handle which does not match to first window handle
			 
			secondWinHandle=winHandle; //Storing handle of second window handle
			 
			//Switch control to new window
			 
			driver.switchTo().window(secondWinHandle);
		}
	}
	
	public void switchTo(String title)
	{
		Set<String> handles=	driver.getWindowHandles();
		
		for(String window:handles)
		{
			if(driver.getTitle().equalsIgnoreCase(title))
			{
				driver.switchTo().window(window);
			}
		}
	}

	
	public void switchToFrame(int num)
	{
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(num);
	}
	
	public void switchToContentWindow()
	{
		driver.switchTo().defaultContent();
	}
	
	public String dateFormat(String date) throws ParseException
	{
		if(date!=null)
		{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate;
		parsedDate=dateFormat.parse(date);
		return dateFormat.format(parsedDate);
		}
		else
		{
			return "";
		}
		
	}
	public String currentDate() throws ParseException
	{
		
		Date parsedDate=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		return dateFormat.format(parsedDate);
	}
	
	public String addedTime(int min) throws ParseException
	{
		
		Date parsedDate=new Date();
		DateFormat dateFormat = new SimpleDateFormat("mm");
		//dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(parsedDate);
		cal.add(Calendar.MINUTE, min);
		return dateFormat.format(cal.getTime());
	}
	
	public String currentTime() throws ParseException
	{
		
		Date parsedDate=new Date();
		DateFormat dateFormat = new SimpleDateFormat("mm");
		return dateFormat.format(parsedDate);
	}
	
	
	public String generateRandomString(int length)
	{
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return (output);
	}
	
	public boolean validateTwoStrings(String expectedValue,String actualvalue)
	{
		String a=expectedValue.replaceAll("\\s","");
		
		String b=actualvalue.replaceAll("\\s","");
		
		System.out.println(""+a);
		System.out.println(""+b);
		
		if(a.trim().equalsIgnoreCase(b.trim()))
		{
			return true;
		}
		else
		{
			return false; 
		}
			
	}
	
	public String generateDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance(); 
		c.setTime(new Date()); // Now use today date. 
		c.add(Calendar.DATE, 5); // Adding 5 days 
		String output = sdf.format(c.getTime());
		//System.out.println(output);
		return output;
	}
	public void keysDown(WebElement element)
	{
		try{
			element.sendKeys(Keys.ARROW_DOWN);
			}catch(Exception e1){
				System.out.println(e1);
			System.out.println("Unable to click element");
			e1.printStackTrace();
		} 
	}


		
	


}
