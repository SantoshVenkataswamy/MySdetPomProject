package pageObjects;
 

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage
{
	public boolean display;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}


	@FindBy(how = How.ID, using = "email")
	private WebElement userNameEditBox;
	
	
	@FindBy(how = How.ID, using = "passwd")
	private WebElement passwordEditBox;

	@FindBy(how = How.XPATH, using = "//div/a[@class='login']")
	private WebElement loginButton;
	

	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = "//form[@id='signonForm']/span[@class='error']")
	private WebElement invalidLoginMessage;


	
	// -------------------User Edit Box----------------------------
	
	private boolean isUserEditBoxVisible()
	{
		if (userNameEditBox.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isUserEditBoxEnabled()
	{
		if (userNameEditBox.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void setUserName(String userName)
	{	
		try{
		if (isUserEditBoxVisible() && isUserEditBoxEnabled())
		{
			try{
				
			writeInput(userNameEditBox, userName);
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
	
	// -----------------Password Edit Box------------------------------
	
	private boolean isPasswordEditBoxVisible()
	{
		if (passwordEditBox.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isPasswordEditBoxEnabled()
	{
		if (passwordEditBox.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void setPassword(String password)
	{
		try{
		if (isPasswordEditBoxVisible() && isPasswordEditBoxEnabled())
		{
			try{
			writeInput(passwordEditBox, password);
			}catch(Exception e){
				System.out.println("Unable to writeInput in passwordEditBox");
				e.printStackTrace();
			}
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to setPassword");
			e.printStackTrace();
		}
	}
	
	// -------------------signIn Button----------------------------
	
	private boolean isSignInButtonVisible()
	{
		if (signInButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSignInButtonEnabled()
	{
		if (signInButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSignIn()
	{
		try{
		if (isSignInButtonVisible() && isSignInButtonEnabled())
		{
			signInButton.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickSignIn");
			e.printStackTrace();
		}
	}
	
	// -------------------Invalid Login Message----------------------------	
	
	public Boolean isInvalidLoginMessageVisible()
	{
		if (invalidLoginMessage.getText().contains("Invalid user/password"))
		{			
			return true;
		}
		return false;
	}
	
	// -------------------Sign In----------------------------	
	
	
	public void signIn(String IDCS, String userName, String password) 
	{
		if(IDCS.equalsIgnoreCase("ON")) {
					try{
					//driver.manage().deleteAllCookies();
					//Thread.sleep(2000);
						loginButton.click();
						 setUserName(userName); setPassword(password);
						Thread.sleep(1000); 
						signInButton.click();
					
					
					}catch(Exception e){
						System.out.println("Unable to signIn");
						e.printStackTrace();
					}
					
		
		}

		
		
		
		
	}
	//-----------------Validate Error message  in the login page---------------------//
	
		public boolean validateLoginErrorMesssage()
		{
			waitForSeconds(2);
			WebElement errorMessage=driver.findElement(By.xpath("//span[@class='error']"));
			if(errorMessage.isDisplayed())
			{
				return true;
			}
			else
				return false;
		}

}
