package testCases;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

import Factories.DataProviderFactory;
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

	@BeforeClass (alwaysRun = true)
	public void setUp()
	{		
	//	driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURLOB());
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
//	public void waitFor(WebElement element)
//	{
//		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
//		{
//			public Boolean apply(WebDriver d) 
//			{
//				return element.isDisplayed() && element.isEnabled();
//			}
//		});
//	}
//	
//	public void waitFor(WebElement element)
//	{
//		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
//		{
//			public Boolean apply(WebDriver d) 
//			{
//				return element.getAttribute("src").contains("x_image.png");
//			}
//		});
//	}
	
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
	/*
	 * public boolean waitForElementToBeVisible(WebElement element,int time) {
	 * 
	 * 
	 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	 * 
	 * .withTimeout(time, TimeUnit.SECONDS)
	 * 
	 * .pollingEvery(5, TimeUnit.SECONDS)
	 * 
	 * .ignoring(NoSuchElementException.class);
	 * 
	 * Boolean isVisible = wait.until(new Function<WebDriver, Boolean>() { public
	 * Boolean apply(WebDriver driver) { if(element.isDisplayed()) { return true; }
	 * else { return false; } } }); return isVisible; }
	 */
	
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
	//------------------------------------Get csv File to upload--------------------------------
	
			public  void updateUploadFile(String filePath,String poNum) throws IOException 
			{
				
				// open file input stream
				File file=new File(filePath);
				try
				{
					Scanner inputStream=new Scanner(file);
					
					//while(inputStream.hasNext())
					//{
						//read csv file
						String data=inputStream.next();
						System.out.println("data"+data);
						
						//split the datas by delimiters and put in a string
						
						String[] values=data.split(",");
						
						System.out.println(Arrays.toString(values));

						values[0]=poNum;
						FileWriter output = new FileWriter(filePath);
						
						output.write(Arrays.toString(values));
						System.out.println(Arrays.toString(values));
						
						output.flush();
						output.close();
					//}
					
						
				}
				
				catch(FileNotFoundException e)
				{
					
					//TODO
				}
		        
			}
	//-----------------------------CSV Upload file---------------------
			
			public void UploadShipmentFile(String Path,String poNum)
			{
			File file=new File(Path);
			
			BufferedWriter bw = null;
			BufferedReader in;
			String line;

			try
			{
				
				
				in = new BufferedReader(new FileReader(file));
	          
				while((line=in.readLine())!=null)
				{
					//String[] values=data.split(",");
					//System.out.println(data);
					String[] values=line.split(",");
					System.out.println(values[0]);
					values[0]=poNum;
					FileWriter fw = new FileWriter(new File(Path));
				    bw = new BufferedWriter(fw);
				    String data=Arrays.toString(values);
				    data=data.replace("[", "");
				    data=data.replace("]", "");
				    data=data.replaceAll("\\s", "");
					bw.write(data);
					bw.flush();
					bw.close();
				}
					
			}
			
			catch(Exception e)
			{
				
				//todo
			}
			
			}

		
	//----------------------Get Values of Search result webelement (example row=1 is the 1st element in SearchResult)-------------------//
			
			public String getSearchResultText(int value)
			{
				
					String Value=driver.findElement(By.xpath("//td["+value+"]/div/nobr")).getText();
					return Value;
					
			}
	//-------------------------delete  different rows of search results------------------//
			
			public void deleteRow(int row)
			{
				try
				{
				driver.findElement(By.xpath("(//img[contains(@src,'icon_delete.gif')])["+row+"]")).click();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("unable to click ''"+row+"''  row delete icon");
				}
			}
	//------------------Close tabs if multiple tabs opened usingTab Number------------------------------
			
			public void clickPageXIconIfMultiplePageExists(int tabnumber)
			{
				try
				{
				driver.findElement(By.xpath("(//table/tbody/tr/td/table/tbody/tr/td[2]/img)["+tabnumber+"]")).click();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("unable to close ''"+tabnumber+"''tab");
				}
			}
}
