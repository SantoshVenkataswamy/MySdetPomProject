package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage extends BasePage
{	
	public HomePage(WebDriver driver) {

		super(driver);

	}
	
	@FindBy(how = How.ID, using = "search_query_top")
	private WebElement searchEditBox;
	
	@FindBy(how = How.NAME, using = "submit_search")
	private WebElement searchIcon;
	
	@FindBy(how = How.ID, using = "selectProductSort")
	private WebElement sortByDropdown;
	
	
	
	@FindBy(how = How.XPATH, using = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']/div/div/div")
	private WebElement selectFirstItem;
	
	
	// -------------------User Edit Box----------------------------
	
	private boolean isSearchEditBoxVisible()
	{
		if (searchEditBox.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSearchEditBoxEnabled()
	{
		if (searchEditBox.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void setSearchEditBox(String editBox)
	{	
		try{
		if (isSearchEditBoxVisible() && isSearchEditBoxEnabled())
		{
			try{
				
			writeInput(searchEditBox, editBox);
			}catch(Exception e){
				System.out.println("Unable to writeInput in userNameEditBox");
				e.printStackTrace();
			}
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to setUserName");
			e.printStackTrace();
		}
	}
	// -------------------Search Icon----------------------------
	
	private boolean isSearchIconVisible()
	{
		if (searchIcon.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSearchIconEnabled()
	{
		if (searchIcon.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSearchIcon()
	{
		try{
		if (isSearchIconVisible() && isSearchIconEnabled())
		{
			searchIcon.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to click searchIcon");
			e.printStackTrace();
		} 
	}
	
	// -------------------Sort By Dropdown----------------------------
	

		
		public void selectValueFromSortByDropdown(String elementId, String visibleText)
		{
			try{
			
				selectDropdownItem(elementId, visibleText);
			
			
			}catch(Exception e){
				System.out.println("Unable to click searchIcon");
				e.printStackTrace();
			} 
		}

		
		// -------------------ClickFirst Item----------------------------
		
		private boolean isselectFirstItemVisible()
		{
			if (selectFirstItem.isDisplayed())
			{
				return true;
			}
			return false;
		}
		
		private boolean isselectFirstItemEnabled()
		{
			if (selectFirstItem.isEnabled())
			{
				return true;
			}
			return false;
		}
		
		public void clickSelectFirstItem()
		{
			try{

				selectFirstItem.click();

			}catch(Exception e){
				System.out.println("Unable to click First Item");
				e.printStackTrace();
			} 
		}
		


}

