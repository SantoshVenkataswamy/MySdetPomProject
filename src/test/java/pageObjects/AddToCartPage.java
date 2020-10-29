package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Factories.ReporterFactory;

public class AddToCartPage extends BasePage
{
	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "boxName")
	private WebElement nameEditBox;
	
	@FindBy(how = How.NAME, using = "Blue")
	private WebElement selectColourBox;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-default button-plus product_quantity_up']")
	private WebElement plusButton;
	
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button[@type='submit']")
	private WebElement addToCartButton;
	
	

    
	// -------------------Name Edit Box ----------------------------
	
	public Boolean isNameEditBoxVisible()
	{
		if (nameEditBox.isDisplayed())
		{
			return true;
		}
		return false;
	}
	

	

	
	//-------------------plusButton----------------------------

	
	public void clickPlusButton()
	{
		try{
	
			plusButton.click();
			//newPasswordEditBox.sendKeys(newpassword);
			
		
		}catch(Exception e){
			System.out.println("Unable to click plusButton");
			e.printStackTrace();
		}
	}

	//-------------------Size Drop Down----------------------------

	public void selectValueFromSizeDropdown(String elementId, String visibleText)
	{
		try{
		
			selectDropdownItem(elementId, visibleText);
		
		
		}catch(Exception e){
			System.out.println("Unable to click Size Dropdown");
			e.printStackTrace();
		} 
	}
	
	// -------------------Select Colour Box----------------------------
	
	private boolean isselectColourBoxVisible()
	{
		if (selectColourBox.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isselectColourBoxEnabled()
	{
		if (selectColourBox.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickColourBox()
	{
		try{
		if (isselectColourBoxVisible() && isselectColourBoxEnabled())
		{
			selectColourBox.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to click ColourBox");
			e.printStackTrace();
		} 
	}
	
	// -------------------Add To Cart Button----------------------------
	
	private boolean isaddToCartButtonVisible()
	{
		if (addToCartButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isaddToCartButtonEnabled()
	{
		if (addToCartButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickAddToCart()
	{
		try{
		if (isaddToCartButtonVisible() && isaddToCartButtonEnabled())
		{
			addToCartButton.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to click addToCartButton");
			e.printStackTrace();
		} 
	}
}
