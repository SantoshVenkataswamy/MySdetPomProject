package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Factories.ReporterFactory;

public class ShoppingCartPage extends BasePage
{
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(how = How.XPATH, using = "//div[@class='clearfix']/div/h2")
	private WebElement successMessage;

	@FindBy(how = How.XPATH, using = "//span[@class='ajax_cart_product_txt_s  unvisible']")
	private WebElement itemsInTheCart;
	
	//-------------------Get Element Text----------------------------

	public String getConfirmMessage()	
	{
		String text = null;
		try{
		
			text =successMessage.getText();
			
			
		}catch(Exception e){
			System.out.println("Unable to get the element text");
			e.printStackTrace();
		}
		return text;
	}

 
	public String getItemsInTheCartMessage()	
	{
		String text = null;
		try{
		
			text =itemsInTheCart.getText();
			
			
		}catch(Exception e){
			System.out.println("Unable to get the items in the cart text");
			e.printStackTrace();
		}
		return text;
	}
}
