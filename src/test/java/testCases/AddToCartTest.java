package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sdet.reports.ExtentManager;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import pageObjects.AddToCartPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCartPage;

public class AddToCartTest extends BaseTest
{

	public String completeTestCaseName= this.getClass().getSimpleName();
	
	String completeTestName = completeTestCaseName + "001";	
	
	BrowserFactory factory = new BrowserFactory();
	LoginPage loginPage;
	BasePage basePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	
	ExtentTest test;
	ExtentReports reports;
	

	@BeforeTest(groups = {"smoke","regression","Failed"})
	@Parameters({"browserName","IDCS"})
	public void setUp(String browserName, String IDCS) throws MalformedURLException
	{	
		
		
		driver = factory.getBrowser(browserName);
		driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURL());
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		waitForSeconds(10);
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		basePage = PageFactory.initElements(driver, BasePage.class);
		addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);
		shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
		
	}
	
	@Parameters({"IDCS"})
	@Test(groups = {"smoke","regression","Failed"})
	public void createAndDeleteBoxes(String IDCS) throws AWTException, IOException{
		
		try{
		reports = ExtentManager.getReport(System.getProperty("user.dir")+"//Reports//");
		
		test = reports.createTest(completeTestCaseName);
		test.log(Status.INFO, "starting Test cases - "+completeTestCaseName );
		
		loginPage.signIn(IDCS,DataProviderFactory.getTestDataProvider().getUsername(completeTestName,"TestData"),
				DataProviderFactory.getTestDataProvider().getPassword(completeTestName,"TestData"));
		/*
		waitForSeconds(5);
		homePage.setSearchEditBox("Dress");
		waitForSeconds(2);
		homePage.clickSearchIcon();
		waitForSeconds(2);
		homePage.selectValueFromSortByDropdown("selectProductSort","Product Name: Z to A");
		//test.addScreenCaptureFromBase64String("Drop down selected");
		
		waitForSeconds(2);
		homePage.clickSelectFirstItem();
		waitForSeconds(2);

		switchToFrame(0);

		waitForSeconds(2);
		
		addToCartPage.clickPlusButton();
		waitForSeconds(2);
		addToCartPage.clickPlusButton();
		
		waitForSeconds(2);
		addToCartPage.selectValueFromSizeDropdown("group_1","M");
		
		waitForSeconds(2);
		addToCartPage.clickColourBox();
		
		waitForSeconds(2);
		addToCartPage.clickAddToCart();
		
		
		String cartMessage="There are 3 items in your cart.";
		
		
		String confirmMessage=shoppingCartPage.getConfirmMessage();
		System.out.println("Confirm Message is -> "+confirmMessage);
		
		String itemsInTheCartMessage=shoppingCartPage.getItemsInTheCartMessage();
		System.out.println("How Many items in the cart -> "+itemsInTheCartMessage);
	
		Assert.assertTrue(itemsInTheCartMessage.equalsIgnoreCase(cartMessage), "Cart Message not Matching");
		
		test.log(Status.INFO, "Completed Test cases - "+completeTestCaseName );
		
		*/
		test.log(Status.FAIL, "Test cases Failed to logout - "+completeTestCaseName);
		
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test cases Failed at Step - "+ e.toString());
		}
	}

	@AfterTest(groups = {"smoke","regression","Failed"})
	public void quit(){		
		reports.flush();
		waitForSeconds(2);
		if(driver!=null);
		driver.quit();
	}
}	
	