package pageObjects;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Factories.ReporterFactory;

public class BasePage 
{	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public Logger printLog(Class className){
		
		Logger log = Logger.getLogger(className);
		if(log == null){
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\log4j.properties");
		
	}
		return log;
	}
	Logger log = printLog(BasePage.class);
	
	
		
	// ---------------Wait Until------------------------
	
	
	public boolean waitUntil(WebElement object) { 
		boolean result = false;
		try{ 
			WebElement element = (new WebDriverWait(driver, 60)) 
					.until(ExpectedConditions.visibilityOf(object)); 
			if(element != null) {
				result = true;
			}
			else 
			{
			}
		}catch(Exception e) { 
			e.printStackTrace();
			Assert.fail("object is not displayed");
		}
		return result; 
	}
	
	// ---------------write inputs into edit boxes------------------------
	
	public void writeInput(WebElement object, String data)
	{
		
		try
		{
			if(object.isDisplayed() && object.isEnabled())
			{
				object.clear();
				object.click();
				object.sendKeys(Keys.BACK_SPACE);
				
				try
				{
					Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
					String browserName = cap.getBrowserName().toLowerCase();
					if(browserName.equals("internet explorer"))
					{
						((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", object, data);
					}
					else
					{
						log.info("Writing in InputBox");
						object.sendKeys(data);
						log.info(object+"***InputBox updated with***"+data );
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					Assert.fail("Inputbox is not enabled.");
				}
			}
			else{
				Assert.fail("Inputbox doesn't exist.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to write.");
		}
	}
	
	// -----------------Wait-----------------------
	
	protected void waitForSeconds(int t)
	{
		try {
			Thread.sleep(t*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//-------------Select Dropdown-------------------
	

		public  void selectDropdownItem(String elementId, String text){
			try{
				Thread.sleep(1000);
				Select select = new Select(driver.findElement(By.id(elementId)));
				Thread.sleep(1000);
				driver.findElement(By.id(elementId)).click();
				select.selectByVisibleText(text);
				//select.selectByValue(text);
			}catch(Exception e){
				e.printStackTrace();
				Assert.fail("unable to select dropdown item");
			}
		}

	
	
	// ----------------Click with Action----------------
	
	protected void clickWithAction(WebElement element)
	{	
		Actions builder = new Actions(driver);
		builder.click(element).build().perform();
	}
	
	
	protected WebElement getWhenVisible(By locator, int timeout) {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    return element;
	}
	
	protected void clickWhenReady(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}

	
	// ----------------Verify Text----------------
	/** 
	 * @object - the label 
	 * @data - text displayed
	 * */	
	public void verifyText(WebElement object, String data){
		
		String expected = data.trim();
		try{
			if(object.isDisplayed()){
				String actual = object.getText();
				System.out.println("In Verify Text Function");
				System.out.println("actual text displayed:"+ actual);
				if(actual.toLowerCase().equals(expected.toLowerCase()) || actual.toLowerCase().contains(expected.toLowerCase())){
					System.out.println("Expected text from Data Excel: "+ expected);
					System.out.println("Verified the Text ");
				}else{
					Assert.fail("'" + data + ": text is not verified");
					System.out.println("In Verify Text Function Failed");
				}
			}
		}catch(NoSuchElementException e){
			e.printStackTrace();			
			Assert.fail("'" + data + ": unable to verify text");
		}	
		System.out.println("Out of Verify Text Function");
	}

	// ----------------Verify Page Title----------------
	/** data - page title 	 **/
	public void verifyTitle(String data){
		try{
		System.out.println("In Verify Title Function");
		ReporterFactory.getReporter().Log("Verifying Page Title"+ data);
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, data.trim(), "Page title is not matched.");	
		ReporterFactory.getReporter().Log("Verified Page Title"+ data);
		}catch(Exception e){
			e.printStackTrace();			
			Assert.fail("'" + data + ": unable to verify Title");
		}		
		System.out.println("Verified the Function");
	}

	// ----------------Get Element Text ----------------
	public String getElementText(String elementId) {
		String actualText;
		actualText= driver.findElement(By.xpath(elementId)).getText();
		return actualText;
		
	}
	// ----------------Verify Link Text ----------------
	/** 
	 * object - LinkText object 
	 * data - text of LinkText
	 * */
	public void verifyLinkText(WebElement element, String data){
	
		String expected = data;
		try{
			System.out.println("In Verify Link Text Function");
			if(element.isDisplayed()){
				String actual = element.getText();
				if(actual.contains(expected)){

				}else{

					Assert.fail("'" + data + " : element is not displayed");
				}
			}
		}catch(NoSuchElementException e){
			e.printStackTrace();

			Assert.fail("'" + data + " : element is not displayed");
		}
		System.out.println("Out of Link Text Function");
	}

	// ----------------Select Radio Button ----------------

	public  void selectRadio(WebElement object){
		try{
			if(waitUntil(object)) {
				object.click();
			}
			else{
				Assert.fail("Radio button does not exist");
			}		
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("unable to select radio button");
		}
	}

	// -------------------Click Yes on Confirmation Box------------------
	
	public void clickYesConfirmationBox(WebDriver driver)
	{
	
		try{
		log.info("Clicking clickYesConfirmationBox");	
		driver.findElement(By.xpath("//div/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr/td/div/div[text()='Yes']")).click();
		//driver.findElement(By.tagName("Yes")).click();
		log.info("YesConfirmationBoxmessage Clicked");
		}catch(Exception e){
			System.out.println("Unable to clickYesConfirmationBox");
			e.printStackTrace();
		}
	}
	

			
			
			public void WaitUntilluploadLoadingIsComplete() {
				try
				{
					WebDriverWait wait = new WebDriverWait(driver, 1);
				WebElement loader=driver.findElement(By.xpath("//img[contains(@src,'icon_running.png')]"));
			 
				System.out.println("loader visible:"+loader.isDisplayed());
				//wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
			    wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
					
			    Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println("Loading Eleemnt is not visible");
					waitForSeconds(2);
					e.printStackTrace();
				}
			    
			}
			//---------------------function for adding the particular element------------------//
			
			public void enterData(WebElement element,String txt)
			{
				try
				{
					element.clear();
					element.sendKeys(txt);
				}
				catch(Exception e)
				{
					System.out.println(e);
					
				}
			}
			public void enterButton(WebElement element)
			{
				try
				{
				element.sendKeys(Keys.ENTER);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			//******************************************* drag and drop Location ************************************************************//	
			public void dragAndDrop(WebElement source,WebElement destination)
			{
				try
				{
					
					 
					if (source.isDisplayed() && destination.isDisplayed()) {
					 Actions a=new Actions(driver);
					a.dragAndDrop(source, destination).build().perform();
					waitForSeconds(2);

					
					}
					else {
						System.out.println("Element was not displayed to drag");
					}
			}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			
}
