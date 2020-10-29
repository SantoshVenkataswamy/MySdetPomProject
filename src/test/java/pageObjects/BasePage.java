package pageObjects;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
	
	
	//***---------- Icons ------------- ****//	
	@FindBy(how = How.XPATH, using = "//img[contains(@src, 'icon_delete.gif')]")
	private WebElement deleteIcon;
	
	
	//***---------- Buttons ------------- ****//	
	@FindBy(how = How.XPATH, using = ".//*/div[text()='New']")
	private WebElement newButton;
	
	@FindBy(how = How.XPATH, using = ".//td[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = ".//*/div[text()='Search']")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = ".//td[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Next']")
	private WebElement ruleNextButton;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Save']")
	private WebElement ruleSaveButton;
	
	
	@FindBy(how = How.XPATH, using = ".//div[text()='Add']")
	private WebElement addButton;
	
	//***---------- Drop Downs ------------- ****//
	
	@FindBy(how = How.XPATH, using = "//div/div/div/div/div/div/div/div[3]/div/form/table/tbody[2]/tr[2]/td[4]/table/tbody/tr/td[1]/div")
	private WebElement activeDropDown;
	
	//***---------- Drop Down Items ------------- ****//
	

	@FindBy(how = How.XPATH, using = "//div[@role='presentation'][nobr='Yes']")
	private WebElement activeDropDownItem;
	
	//***---------- Verify Text  ------------- ****//
	
	//nobr[text()='If Available Quantity Equal To [=] Available Quantity * Plus [+] 500']
	//div/div/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[@class='TextError'][text()='There are no records that match the search criteria.']
	@FindBy(how = How.XPATH, using = "//td[@class='TextError'][text()='There are no records that match the search criteria.']")
	private WebElement NoRecordsMatchSearchCriteriaText;
	
	@FindBy(how = How.XPATH, using = "//td[@class='TextError'][contains(text(),'The Report Schedule was deleted successfully.')]")
	private WebElement ReportScheduleWasDeletedSuccessfullyText;
	
	@FindBy(how = How.XPATH, using = ".//span[text()='Invalid user/password']")
	private WebElement InvalidUserPasswordText;
	
	//***---------- XIcon  ------------- ****//
	
	@FindBy(how = How.XPATH, using = ".//*/table/tbody/tr/td/table/tbody/tr/td[2]/img")
	private WebElement pageXIconImage;
	
	
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
	
	// -------------------Delete Icon---------------------------
	
	public boolean isDeleteIconVisible()
	{
		if (deleteIcon.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isDeleteIconEnabled()
	{
		if (deleteIcon.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickDeleteIcon()
	{
		
		try{
		if (isDeleteIconVisible() && isDeleteIconEnabled())
		{
			deleteIcon.click();
			log.info("deleteIcon Clicked");
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickDeleteIcon");
			e.printStackTrace();
		}
	}
	
	// -------------------New Button----------------------------
	
	private boolean isNewButtonVisible()
	{
		if (newButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isNewButtonEnabled()
	{
		if (newButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickNewButton()
	{
		
		try{
		if (isNewButtonVisible() && isNewButtonEnabled())
		{
			newButton.click();
			log.info("newButton Clicked");
		}

		}catch(Exception e){
			System.out.println("Unable to clickNewButton");
			e.printStackTrace();
		}
	}
	
	// -------------------Save Button----------------------------

	private boolean isSaveButtonVisible()
	{
		if (saveButton.isDisplayed())
		{
			return true;
		}
		return false;
	}

	private boolean isSaveButtonEnabled()
	{
		if (saveButton.isEnabled())
		{
			return true;
		}
		return false;
	}

	public void clickSaveButton()
	{
		
		try{
		if (isSaveButtonVisible() && isSaveButtonEnabled())
		{
			saveButton.click();
			log.info("saveButton Clicked");
			
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickSaveButton");
			e.printStackTrace();
		}
	}

	// -------------------Search Button----------------------------
	
	private boolean isSearchButtonVisible()
	{
		if (searchButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSearchButtonEnabled()
	{
		if (searchButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSearchButton()
	{
		
		try{
		if (isSearchButtonVisible() && isSearchButtonEnabled())
		{
			searchButton.click();
			log.info("searachButton Clicked");
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickSearchButton");
			e.printStackTrace();
		}
	}	
	
	
	// -------------------Rule Next Button----------------------------

	private boolean isRuleNextButtonVisible()
	{
		if (ruleNextButton.isDisplayed())
		{
			return true;
		}
		return false;
	}

	private boolean isRuleNextButtonEnabled()
	{
		if (ruleNextButton.isEnabled())
		{
			return true;
		}
		return false;
	}

	public void clickRuleNextButton()
	{
		
		try{
		if (isRuleNextButtonVisible() && isRuleNextButtonEnabled())
		{
			ruleNextButton.click();
			
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickRuleNextButton");
			e.printStackTrace();
		}
	}
	
	
	// -------------------Rule Save Button----------------------------

	private boolean isRuleSaveButtonVisible()
	{
		if (ruleSaveButton.isDisplayed())
		{
			return true;
		}
		return false;
	}

	private boolean isRuleSaveButtonEnabled()
	{
		if (ruleSaveButton.isEnabled())
		{
			return true;
		}
		return false;
	}

	public void clickRuleSaveButton()
	{
		
		try{
		if (isRuleSaveButtonVisible() && isRuleSaveButtonEnabled())
		{
			ruleSaveButton.click();
			
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickRuleSaveButton");
			e.printStackTrace();
		}
	}
	
	// -------------------Add Button----------------------------
	
	private boolean isAddButtonVisible()
	{
		if (addButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isAddButtonEnabled()
	{
		if (addButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickAddButton()
	{
		
		try{
		if (isAddButtonVisible() && isAddButtonEnabled())
		{
			addButton.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickAddButton");
			e.printStackTrace();
		}
	}
	
	
	
	// ---------------Page X Icon Image ---------	
	
	private boolean isPageXIconImageVisible()
	{
		if (pageXIconImage.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isPageXIconImageEnabled()
	{
		if (pageXIconImage.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickPageXIconImage()
	{
		
		try{
		if (isPageXIconImageVisible() && isPageXIconImageEnabled())
		{
			pageXIconImage.click();
			log.info("pageXIconImage Clicked");
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickPageXIconImage");
			e.printStackTrace();
		}
	}
	
	// -------------------Active Drop Down Item ----------------------------
	
	private boolean isActiveDropDownItemVisible()
	{
		if (activeDropDownItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isActiveDropDownItemEnabled()
	{
		if (activeDropDownItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickActiveDropDownItem()
	{
		
		try{
			activeDropDown.click();
		}catch(Exception e){
			System.out.println("Unable to click clickActiveDropDown");
			e.printStackTrace();
		}
		
		waitForSeconds(1);
		
		try{
		if (isActiveDropDownItemVisible() && isActiveDropDownItemEnabled())
		{
			activeDropDownItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickActiveDropDownItem");
			e.printStackTrace();
		}
	}
	

	//---------------------function for clicking the particular element------------------//
	
			public void clickElement(WebElement element)
			{
				try
				{
					
					element.click();
				}
				catch(Exception e)
				{
					System.out.println(element+" not clicked");
				}
				
					
				 
			}
	//--------------------get Order Boker Version-------------------------------//
			
			public String getOBVersion()
			{
				try
				{
					WebElement e=driver.findElement(By.xpath("(//td[@class='TextItem']/following::td[@class='TextItem'])[1]"));
					String version=e.getText();
					return version;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			//---------------Return cancel element----------------------------------//
			
			public WebElement getCancelButtonElement()
			{
				return cancelButton;

			}
			public void closepageTabs(int pageNum)
			{
				WebElement pagexIcon=driver.findElement(By.xpath("(.//*/table/tbody/tr/td/table/tbody/tr/td[2]/img)["+pageNum+"]"));
				pagexIcon.click();
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
