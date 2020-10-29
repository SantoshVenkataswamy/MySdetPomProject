package pageObjects;

import org.openqa.selenium.By;
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
	
	@FindBy(how = How.XPATH, using = "//img[contains(@src, 'logout_')]")
	private WebElement logOutIcon;
	
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
		

	// ********************************************** Dashboard Menu  ******************************************************//
	/* Begin - Elements on Dashboard */
	@FindBy(how = How.XPATH, using = ".//*/div[text()='OK']")
	private WebElement okButton;
	
	@FindBy(how = How.XPATH, using = "//td[@class='toolStripMenuButtonTitle'][text()= 'Systems']")
	private WebElement systemsButton;
    
	@FindBy(how = How.XPATH, using = "//nobr[text()='About Order Broker...']")
	private WebElement aboutOrderBrokerDropdown;
	
	@FindBy(how = How.XPATH, using = "//td[@class='toolStripMenuButtonTitle'][text()='Locations']")
	private WebElement locationButton;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Fulfillment Zones']")
	private WebElement fulfillmentZoneDropdownButton;
	
	public WebElement getLocationButton()
	{
		return locationButton;
	}
	public WebElement getFulfillemtzoneDropdownButton()
	{
		return fulfillmentZoneDropdownButton;
	}
	//---------------------System button ------------------------------//
	public WebElement getSystemButtonElement()
	{
		return systemsButton;
	}
	public WebElement getokButton()
	{
		return okButton;
	}
	
	//-----------------About Order Broker-----------------------------//
	
	public WebElement getAboutOrderBrokerDropDownElement()
	{
		return aboutOrderBrokerDropdown;
	}
	public WebElement getLogOutIcon() {
		return logOutIcon;
	}
	
	public void clickYesConfirmationBoxLogOut(WebDriver driver)
	{
		try{
		//.//*/div[text()='OK']
		//img[@src='http://bur00cqs.us.oracle.com:7403/LocateUI/locateui/images/logout_16x16.gif']
		driver.findElement(By.xpath(".//*/div[text()='OK']")).click();
		//driver.findElement(By.tagName("OK")).click();
		}catch(Exception e){
			System.out.println("Unable to ");
			e.printStackTrace();
		} 
	}

	public void setLogOutIcon(WebElement logOutIcon) {
		this.logOutIcon = logOutIcon;
	}

	//td[2][text()='Order Inquiry']
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Order Inquiry']")
	private WebElement orderInquiryDashboardLink;
	
	//td[2][text()='Purchase Order Inquiry']
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Purchase Order Inquiry']")
	private WebElement purchaseOrderInquiryDashboardLink;
	
	//td[@class='locate-link'][contains (text(),'Invoice Inquiry')]"
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Invoice Inquiry']")
	private WebElement invoiceInquiryDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Products']")
	private WebElement productsDashboardLink;
	
	//td[2][text()='Probability Rules']
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][ text()='Probability Rules']")
	private WebElement probabilityRulesDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Probability Location']")
	private WebElement probabilityLocationDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Organizations and Preferences']")
	private WebElement organizationsAndPreferencesDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Brands']")
	private WebElement brandsDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Location Types']")
	private WebElement locationTypesDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Locations']")
	private WebElement locationsDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Fulfillment Zones']")
	private WebElement fulfillmentZonesDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Vendors']")
	private WebElement vendorsDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Run Reports']")
	private WebElement runReportsDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Schedule Reports']")
	private WebElement scheduleReportsDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'View Reports']")
	private WebElement viewReportsDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Event Logging']")
	private WebElement eventLoggingDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'User Profiles']")
	private WebElement userProfilesDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Vendor User Profiles']")
	private WebElement vendorUserProfilesDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Store Associate User Profiles']")
	private WebElement storeAssociateUserProfilesDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][ text()='Proximity Uploads']")
	private WebElement proximityUploadsDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Systems']")
	private WebElement systemsDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Carriers']")
	private WebElement carriersDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Operations Guide']")
	private WebElement operationsGuideDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()='Data Dictionary']")
	private WebElement dataDictionaryDashboardLink;
	
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Vendor Portal Help']")
	private WebElement vendorPortalHelpDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Store Connect Help']")
	private WebElement storeConnectHelpDashboardLink;
    
	@FindBy(how = How.XPATH, using = "//td[@class='locate-link'][text()= 'Vendor Integration Guide']")
	private WebElement vendorIntegrationGuideDashboardLink;
    
	// -------------------Order Inquiry Link----------------------------
	
	private boolean isOrderInquiryLinkVisible()
	{
		if (orderInquiryDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOrderInquiryLinkEnabled()
	{
		if (orderInquiryDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	public WebElement getOrderInquiryLink()
	{
		return orderInquiryDashboardLink;
	}
	
	public void clickOrderInquiryLink()
	{
		try{
		if (isOrderInquiryLinkVisible() && isOrderInquiryLinkEnabled())
		{
			clickWhenReady(orderInquiryDashboardLink);
			//orderInquiryDashboardLink.click();
		}
		else
		{
			//log.info("Unable to clickOrderInquiryLink");
		}
		}catch(Exception e){
			System.out.println("Unable to clickOrderInquiryLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Purchase Order Inquiry Link----------------------------
	
	private boolean isPurchaseOrderInquiryLinkVisible()
	{
		if (purchaseOrderInquiryDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isPurchaseOrderInquiryLinkEnabled()
	{
		if (purchaseOrderInquiryDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickPurchaseOrderInquiryLink()
	{
		try{
		if (isPurchaseOrderInquiryLinkVisible() && isPurchaseOrderInquiryLinkEnabled())
		{
			purchaseOrderInquiryDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickPurchaseOrderInquiryLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Invoice Inquiry Link----------------------------
	
	private boolean isInvoiceInquiryLinkVisible()
	{
		if (invoiceInquiryDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isInvoiceInquiryLinkEnabled()
	{
		if (invoiceInquiryDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickInvoiceInquiryLink()
	{
		try{
		if (isInvoiceInquiryLinkVisible() && isInvoiceInquiryLinkEnabled())
		{
			invoiceInquiryDashboardLink.click();
		}
		else
		{
			//log.info("InvoiceInquiryLink not Enabled/Visble");
		}
		}catch(Exception e){
			System.out.println("Unable to clickInvoiceInquiryLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Products Link----------------------------
	
	private boolean isProductsLinkVisible()
	{
		if (productsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProductsLinkEnabled()
	{
		if (productsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProductsLink()
	{
		try{
		if (isProductsLinkVisible() && isProductsLinkEnabled())
		{
			productsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProductsLink");
			e.printStackTrace();
		} 
	}
		
	// -------------------Probability Rules----------------------------
	
	private boolean isProbabilityRulesLinkVisible()
	{
		if (probabilityRulesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbabilityRulesLinkEnabled()
	{
		if (probabilityRulesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbabilityRulesLink()
	{
		try{
		if (isProbabilityRulesLinkVisible() && isProbabilityRulesLinkEnabled())
		{
			probabilityRulesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbabilityRulesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Probability Location----------------------------
	
	private boolean isProbabilityLocationLinkVisible()
	{
		if (probabilityLocationDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbabilityLocationLinkEnabled()
	{
		if (probabilityLocationDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbabilityLocationLink()
	{
		try{
		if (isProbabilityLocationLinkVisible() && isProbabilityLocationLinkEnabled())
		{
			probabilityLocationDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbabilityLocationLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Organizations and Preferences----------------------------
	
	private boolean isOrganizationsAndPreferencesLinkVisible()
	{
		if (organizationsAndPreferencesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOrganizationsAndPreferencesLinkEnabled()
	{
		if (organizationsAndPreferencesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickOrganizationsAndPreferencesLink()
	{
		try{
		if (isOrganizationsAndPreferencesLinkVisible() && isOrganizationsAndPreferencesLinkEnabled())
		{
			organizationsAndPreferencesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickOrganizationsAndPreferencesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Brands----------------------------
	
	private boolean isBrandsLinkVisible()
	{
		if (brandsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isBrandsLinkEnabled()
	{
		if (brandsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickBrandsLink()
	{
		try{
		if (isBrandsLinkVisible() && isBrandsLinkEnabled())
		{
			brandsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickBrandsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Location Types----------------------------
	
	private boolean isLocationTypesLinkVisible()
	{
		if (locationTypesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isLocationTypesLinkEnabled()
	{
		if (locationTypesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickLocationTypesLink()
	{
		try{
			if (isLocationTypesLinkVisible() && isLocationTypesLinkEnabled())
		
		{
			locationTypesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickLocationTypesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Locations----------------------------
	
	private boolean isLocationsLinkVisible()
	{
		if (locationsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isLocationsLinkEnabled()
	{
		if (locationsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickLocationsLink()
	{
		try{
		if (isLocationsLinkVisible() && isLocationsLinkEnabled())
		{
			locationsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickLocationsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Fulfillment Zones----------------------------
	
	private boolean isFulfillmentZonesLinkVisible()
	{
		if (fulfillmentZonesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isFulfillmentZonesLinkEnabled()
	{
		if (fulfillmentZonesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickFulfillmentZonesLink()
	{
		try{
		if (isFulfillmentZonesLinkVisible() && isFulfillmentZonesLinkEnabled())
		{
			fulfillmentZonesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickFulfillmentZonesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Vendors----------------------------
	
	private boolean isVendorsLinkVisible()
	{
		if (vendorsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorsLinkEnabled()
	{
		if (vendorsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorsLink()
	{
		try{
		if (isVendorsLinkVisible() && isVendorsLinkEnabled())
		{
			vendorsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Run Reports----------------------------
	
	private boolean isRunReportsLinkVisible()
	{
		if (runReportsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isRunReportsLinkEnabled()
	{
		if (runReportsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickRunReportsLink()
	{
		try{
		if (isRunReportsLinkVisible() && isRunReportsLinkEnabled())
		{
			runReportsDashboardLink.click();
		}
		else
		{
			// log in error
		}
	}catch(Exception e){
		System.out.println("Unable to clickRunReportsLink");
		e.printStackTrace();
	} 
	}
	
	// -------------------Schedule Reports----------------------------
	
	private boolean isScheduleReportsLinkVisible()
	{
		if (scheduleReportsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isScheduleReportsLinkEnabled()
	{
		if (scheduleReportsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickScheduleReportsLink()
	{
		try{
		if (isScheduleReportsLinkVisible() && isScheduleReportsLinkEnabled())
		{
			scheduleReportsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickScheduleReportsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------View Reports----------------------------
	
	private boolean isViewReportsLinkVisible()
	{
		if (viewReportsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isViewReportsLinkEnabled()
	{
		if (viewReportsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickViewReportsLink()
	{
		
		try{
		if (isViewReportsLinkVisible() && isViewReportsLinkEnabled())
		
		{
			viewReportsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickViewReportsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Event Logging----------------------------
	
	private boolean isEventLoggingLinkVisible()
	{
		if (eventLoggingDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isEventLoggingLinkEnabled()
	{
		if (eventLoggingDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickEventLoggingLink()
	{
		try{
		if (isEventLoggingLinkVisible() && isEventLoggingLinkEnabled())
		{
			eventLoggingDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickEventLoggingLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------User Profiles----------------------------
	
	private boolean isUserProfilesLinkVisible()
	{
		if (userProfilesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isUserProfilesLinkEnabled()
	{
		if (userProfilesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickUserProfilesLink()
	{
		try{
		if (isUserProfilesLinkVisible() && isUserProfilesLinkEnabled())
		{
			userProfilesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickUserProfilesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Vendor User Profiles----------------------------
	
	private boolean isVendorUserProfilesLinkVisible()
	{
		if (vendorUserProfilesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorUserProfilesLinkEnabled()
	{
		if (vendorUserProfilesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorUserProfilesLink()
	{
		try{
		if (isVendorUserProfilesLinkVisible() && isVendorUserProfilesLinkEnabled())
		{
			vendorUserProfilesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorUserProfilesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Store Associate User Profiles----------------------------
	
	private boolean isStoreAssociateUserProfilesLinkVisible()
	{
		if (storeAssociateUserProfilesDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isStoreAssociateUserProfilesLinkEnabled()
	{
		if (storeAssociateUserProfilesDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickStoreAssociateUserProfilesLink()
	{
		try{
		if (isStoreAssociateUserProfilesLinkVisible() && isStoreAssociateUserProfilesLinkEnabled())
		{
			storeAssociateUserProfilesDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickStoreAssociateUserProfilesLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Proximity Uploads----------------------------
	
	private boolean isProximityUploadsLinkVisible()
	{
		if (proximityUploadsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProximityUploadsLinkEnabled()
	{
		if (proximityUploadsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProximityUploadsLink()
	{
		try{
			if (isProximityUploadsLinkVisible() && isProximityUploadsLinkEnabled())
		
		{
			proximityUploadsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProximityUploadsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Systems----------------------------
	
	private boolean isSystemsLinkVisible()
	{
		if (systemsDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSystemsLinkEnabled()
	{
		if (systemsDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSystemsLink()
	{
		try{
		if (isSystemsLinkVisible() && isSystemsLinkEnabled())
		{
			systemsDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickSystemsLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Carriers----------------------------
	
	private boolean isCarriersLinkVisible()
	{
		if (carriersDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isCarriersLinkEnabled()
	{
		if (carriersDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickCarriersLink()
	{
		try{
		if (isCarriersLinkVisible() && isCarriersLinkEnabled())
		{
			carriersDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickCarriersLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Operations Guide----------------------------
	
	private boolean isOperationsGuideLinkVisible()
	{
		if (operationsGuideDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOperationsGuideLinkEnabled()
	{
		if (operationsGuideDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickOperationsGuideLink()
	{
		try{
		if (isOperationsGuideLinkVisible() && isOperationsGuideLinkEnabled())
		{
			operationsGuideDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickOperationsGuideLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Data Dictionary----------------------------
	
	private boolean isDataDictionaryLinkVisible()
	{
		if (dataDictionaryDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isDataDictionaryLinkEnabled()
	{
		if (dataDictionaryDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickDataDictionaryLink()
	{
		try{
		if (isDataDictionaryLinkVisible() && isDataDictionaryLinkEnabled())
		{
			dataDictionaryDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickDataDictionaryLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Vendor Portal Help----------------------------
	
	private boolean isVendorPortalHelpLinkVisible()
	{
		if (vendorPortalHelpDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorPortalHelpLinkEnabled()
	{
		if (vendorPortalHelpDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorPortalHelpLink()
	{
		try{
		if (isVendorPortalHelpLinkVisible() && isVendorPortalHelpLinkEnabled())
		{
			vendorPortalHelpDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorPortalHelpLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Store Connect Help----------------------------
	
	private boolean isStoreConnectHelpLinkVisible()
	{
		if (storeConnectHelpDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isStoreConnectHelpLinkEnabled()
	{
		if (storeConnectHelpDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickStoreConnectHelpLink()
	{
		try{
		if (isStoreConnectHelpLinkVisible() && isStoreConnectHelpLinkEnabled())
		{
			storeConnectHelpDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickStoreConnectHelpLink");
			e.printStackTrace();
		} 
	}
	
	// -------------------Vendor Integration Guide----------------------------
	
	private boolean isVendorIntegrationGuideLinkVisible()
	{
		if (vendorIntegrationGuideDashboardLink.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorIntegrationGuideLinkEnabled()
	{
		if (vendorIntegrationGuideDashboardLink.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorIntegrationGuideLink()
	{
		try{
		if (isVendorIntegrationGuideLinkVisible() && isVendorIntegrationGuideLinkEnabled())
		{
			vendorIntegrationGuideDashboardLink.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorIntegrationGuideLink");
			e.printStackTrace();
		} 
	}
		
	/** End - Elements on Dashboard */
    
	
	// ********************************************** DropDown Menu  ******************************************************//
	
	/** Begin - Dropdown Menus (Orders, Products, Locations, Reports, Systems, Documentation) */
	
	
	// -------------------Orders Dropdown Menu----------------------------
	@FindBy(how = How.XPATH, using = ".//td[@class='toolStripMenuButtonTitle'][text()='Orders']")
	private WebElement ordersDropdownMenu;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Order Inquiry']")
	private WebElement orderInquiryDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Purchase Order Inquiry']")
	private WebElement purchaseOrderInquiryDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Invoice Inquiry']")
	private WebElement invoiceInquiryDropdownMenuItem;
	
	
	// -------------------Products Dropdown Menu----------------------------
	
	//td[contains(text(), 'Products')][@class='toolStripMenuButtonTitle']
	@FindBy(how = How.XPATH, using = ".//td[@class='toolStripMenuButtonTitle'][text()='Products']")
	private WebElement productsDropdownMenu;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Products']")
	private WebElement productsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Probability Rules']")
	private WebElement probabilityRulesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Probability Location']")
	private WebElement probabilityLocationDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Probable Quantity Rules']")
	private WebElement probableQuantityRulesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Probable Quantity Location']")
	private WebElement probableQuantityLocationDropdownMenuItem;
	
	
	// -------------------Locations Dropdown Menu----------------------------
	
	//td[contains(text(), 'Locations')][@class='toolStripMenuButtonTitle']
	@FindBy(how = How.XPATH, using = ".//td[@class='toolStripMenuButtonTitle'][text()='Locations']")
	private WebElement locationsDropdownMenu;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Organizations and Preferences']")
	private WebElement organizationsAndPreferencesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Order Broker Preference Overrides']")
	private WebElement orderBrokerPreferenceOverridesDropdownMenuItem;
	

	@FindBy(how = How.XPATH, using = "//nobr[text()='Brands']")
	private WebElement brandsDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Location Types']")
	private WebElement locationTypesDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Locations']")
	private WebElement locationsDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Location Bulk Updates']")
	private WebElement locationBulkUpdatesDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Fulfillment Zones']")
	private WebElement fulfillmentZonesDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Vendors']")
	private WebElement vendorsDropdownMenuItem;
	

	// -------------------Reports Dropdown Menu----------------------------
	
	//td[contains(text(), 'Reports')][@class='toolStripMenuButtonTitle']
	@FindBy(how = How.XPATH, using = ".//td[@class='toolStripMenuButtonTitle'][text()='Reports']")
	private WebElement reportsDropdownMenu;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Run Reports']")
	private WebElement runReportsDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Schedule Reports']")
	private WebElement scheduleReportsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='View Reports']")
	private WebElement viewReportsDropdownMenuItem;
	
	
	// -------------------Systems Dropdown Menu----------------------------	
	
	//td[contains(text(), 'System')][@class='toolStripMenuButtonTitle']
	//div[@id='isc_4Q']//div[@id='isc_4R']//tr//td[@class='toolStripMenuButtonTitle'][text()='Systems']
	
	@FindBy(how = How.XPATH, using = ".//td[@class='toolStripMenuButtonTitle'][text()='Systems']")
	private WebElement systemsDropdownMenu;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Schedule Imports']")
	private WebElement scheduleImportsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Event Logging']")
	private WebElement eventLoggingDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='Roles']")
	private WebElement rolesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text() ='User Profiles']")
	private WebElement userProfilesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Vendor User Profiles']")
	private WebElement vendorUserProfilesDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Store Associate User Profiles']")
	private WebElement storeAssociateUserProfilesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Proximity Uploads']")
	private WebElement proximityUploadsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Systems']")
	private WebElement systemsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Boxes']")
	private WebElement boxesDropdownMenuItem;

	@FindBy(how = How.XPATH, using = "//nobr[text()='Domains']")
	private WebElement domainsDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Carriers']")
	private WebElement carriersDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Tenant']")
	private WebElement tenantDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Reason Codes']")
	private WebElement reasonCodesDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='Web Service Authorization']")
	private WebElement webServiceAuthorizationDropdownMenuItem;
	
	@FindBy(how = How.XPATH, using = "//nobr[text()='About Order Broker...']")
	private WebElement aboutOrderBrokerDropdownMenuItem;
	
	
	// UserName Menu
	
	@FindBy(how = How.XPATH, using = ".//div[@id='isc_4V']/table/tbody/tr/td/span")
	private WebElement userNameDropDown;
	
	@FindBy(how = How.XPATH, using = ".//table[@class='menuTable']//tbody[2]//tr//td[1]/nobr")
	private WebElement changePasswordDropDownMenuItem;
	
	//#################### UserName Menu Begin ###############################################
	
	// -------------------Order Inquiry Dropdown Menu Item----------------------------
	

private boolean isChangePasswordDropDownMenuItemVisible()
{
	if (changePasswordDropDownMenuItem.isDisplayed())
	{
		return true;
	}
	return false;
}

private boolean isChangePasswordDropDownMenuItemEnabled()
{
	if (changePasswordDropDownMenuItem.isEnabled())
	{
		return true;
	}
	return false;
}

public void clickChangePasswordDropDownMenuItem()
{
	try{
		userNameDropDown.click();
		
	if (isChangePasswordDropDownMenuItemEnabled() && isChangePasswordDropDownMenuItemVisible())
	{
		changePasswordDropDownMenuItem.click();
	}
	else
	{
		// log in error
	}
	}catch(Exception e){
		System.out.println("Unable to clickChangePasswordDropDownMenuItem");
		e.printStackTrace();
	}
}	
	
	//#################### Orders Menu Begin ###############################################
	
	// -------------------Order Inquiry Dropdown Menu Item----------------------------
	
	private boolean isOrderInquiryDropdownMenuItemVisible()
	{
		if (orderInquiryDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOrderInquiryDropdownMenuItemEnabled()
	{
		if (orderInquiryDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickOrderInquiryDropdownMenuItem()
	{
		try{
		ordersDropdownMenu.click();
		
		if (isOrderInquiryDropdownMenuItemVisible() && isOrderInquiryDropdownMenuItemEnabled())
		{
			orderInquiryDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickOrderInquiryDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Purchase Order Inquiry Dropdown Menu Item----------------------------
	
	private boolean isPurchaseOrderInquiryDropdownMenuItemVisible()
	{
		if (purchaseOrderInquiryDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isPurchaseOrderInquiryDropdownMenuItemEnabled()
	{
		if (purchaseOrderInquiryDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickPurchaseOrderInquiryDropdownMenuItem()
	{
		try{
		ordersDropdownMenu.click();
		
		if (isPurchaseOrderInquiryDropdownMenuItemVisible() && isPurchaseOrderInquiryDropdownMenuItemEnabled())
		{
			purchaseOrderInquiryDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		
		}catch(Exception e){
			System.out.println("Unable to clickPurchaseOrderInquiryDropdownMenuItem");
			e.printStackTrace();
		} 
		
	}
	
	// -------------------Invoice Inquiry Dropdown Menu Item----------------------------
	

	private boolean isInvoiceInquiryDropdownMenuItemVisible()
	{
		if (invoiceInquiryDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isInvoiceInquiryDropdownMenuItemEnabled()
	{
		if (invoiceInquiryDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickInvoiceInquiryDropdownMenuItem()
	{
		try{
		
		
		ordersDropdownMenu.click();
		
		if (isInvoiceInquiryDropdownMenuItemVisible() && isInvoiceInquiryDropdownMenuItemEnabled())
		{
			invoiceInquiryDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickInvoiceInquiryDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	//#################### Products Menu Begin ###############################################
	
	// -------------------Products Dropdown Menu Item----------------------------
	
	private boolean isProductsDropdownMenuItemVisible()
	{
		if (productsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProductsDropdownMenuItemEnabled()
	{
		if (productsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProductsDropdownMenuItem()
	{
		try{
		productsDropdownMenu.click();
		//clickWithAction(productsDropdownMenu);
				
		if (isProductsDropdownMenuItemVisible() && isProductsDropdownMenuItemEnabled())
		{
			productsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProductsDropdownMenuItem");
			e.printStackTrace();
		} 
	}

	// -------------------Probability Rules Dropdown Menu Item----------------------------
	
	private boolean isProbabilityRulesDropdownMenuItemVisible()
	{
		if (probabilityRulesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbabilityRulesDropdownMenuItemEnabled()
	{
		if (probabilityRulesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbabilityRulesDropdownMenuItem()
	{	
		try{
			productsDropdownMenu.click();
		
		//clickWithAction(productsDropdownMenu);
		
		if (isProbabilityRulesDropdownMenuItemVisible() && isProbabilityRulesDropdownMenuItemEnabled())
		{
			probabilityRulesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbabilityRulesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Probability Location Dropdown Menu Item----------------------------
	
	private boolean isProbabilityLocationDropdownMenuItemVisible()
	{
		if (probabilityLocationDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbabilityLocationDropdownMenuItemEnabled()
	{
		if (probabilityLocationDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbabilityLocationDropdownMenuItem()
	{
		try{
		productsDropdownMenu.click();
		//clickWithAction(productsDropdownMenu);
		waitForSeconds(2);
		if (isProbabilityLocationDropdownMenuItemVisible() && isProbabilityLocationDropdownMenuItemEnabled())
		{
			probabilityLocationDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbabilityLocationDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Probable Quantity Rules Dropdown Menu Item----------------------------
	
	private boolean isProbableQuantityRulesDropdownMenuItemVisible()
	{
		if (probableQuantityRulesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbableQuantityRulesDropdownMenuItemEnabled()
	{
		if (probableQuantityRulesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbableQuantityRulesDropdownMenuItem()
	{
		try{
		productsDropdownMenu.click();
		//clickWithAction(productsDropdownMenu);
		
		if (isProbableQuantityRulesDropdownMenuItemVisible() && isProbableQuantityRulesDropdownMenuItemEnabled())
		{
			probableQuantityRulesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbableQuantityRulesDropdownMenuItem");
			e.printStackTrace();
		} 
	}	
	
	// -------------------Probable Quantity Location Dropdown Menu Item----------------------------
	
	private boolean isProbableQuantityLocationDropdownMenuItemVisible()
	{
		if (probableQuantityLocationDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProbableQuantityLocationDropdownMenuItemEnabled()
	{
		if (probableQuantityLocationDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProbableQuantityLocationDropdownMenuItem()
	{
		try{
		productsDropdownMenu.click();
		//clickWithAction(productsDropdownMenu);
		
		if (isProbableQuantityLocationDropdownMenuItemVisible() && isProbableQuantityLocationDropdownMenuItemEnabled())
		{
			probableQuantityLocationDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProbableQuantityLocationDropdownMenuItem");
			e.printStackTrace();
		} 
	}	

	
	//#################### Locations Menu Begin ###############################################	
	
	// -------------------Organizations And Preferences Dropdown Menu Item----------------------------
	

	private boolean isOrganizationsAndPreferencesDropdownMenuItemVisible()
	{
		if (organizationsAndPreferencesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOrganizationsAndPreferencesDropdownMenuItemEnabled()
	{
		if (organizationsAndPreferencesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickOrganizationsAndPreferencesDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isOrganizationsAndPreferencesDropdownMenuItemVisible() && isOrganizationsAndPreferencesDropdownMenuItemEnabled())
		{
			organizationsAndPreferencesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickOrganizationsAndPreferencesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Order Broker Preference Overrides Dropdown Menu Item----------------------------
	
	private boolean isOrderBrokerPreferenceOverridesDropdownMenuItemVisible()
	{
		if (orderBrokerPreferenceOverridesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isOrderBrokerPreferenceOverridesDropdownMenuItemEnabled()
	{
		if (orderBrokerPreferenceOverridesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickOrderBrokerPreferenceOverridesDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isOrderBrokerPreferenceOverridesDropdownMenuItemVisible() && isOrderBrokerPreferenceOverridesDropdownMenuItemEnabled())
		{
			orderBrokerPreferenceOverridesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickOrderBrokerPreferenceOverridesDropdownMenuItem");
			e.printStackTrace();
		} 
	}	

	// -------------------Brands Dropdown Menu Item----------------------------

	private boolean isBrandsDropdownMenuItemVisible()
	{
		if (brandsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isBrandsDropdownMenuItemEnabled()
	{
		if (brandsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickBrandsDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isBrandsDropdownMenuItemVisible() && isBrandsDropdownMenuItemEnabled())
		{
			brandsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickBrandsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Location Types Dropdown Menu Item----------------------------
	

	private boolean isLocationTypesDropdownMenuItemVisible()
	{
		if (locationTypesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isLocationTypesDropdownMenuItemEnabled()
	{
		if (locationTypesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickLocationTypesDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isLocationTypesDropdownMenuItemVisible() && isLocationTypesDropdownMenuItemEnabled())
		{
			locationTypesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickLocationTypesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Locations Dropdown Menu Item----------------------------
	
	private boolean isLocationsDropdownMenuItemVisible()
	{
		if (locationsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isLocationsDropdownMenuItemEnabled()
	{
		if (locationsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickLocationsDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isLocationsDropdownMenuItemVisible() && isLocationsDropdownMenuItemEnabled())
		{
			locationsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		
		}catch(Exception e){
			System.out.println("Unable to clickLocationsDropdownMenuItem");
			e.printStackTrace();
		}
	}
	
	// -------------------Locations Bulk Updates Dropdown Menu Item----------------------------
	
	private boolean isLocationBulkUpdatesDropdownMenuItemVisible()
	{
		if (locationBulkUpdatesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isLocationBulkUpdatesDropdownMenuItemEnabled()
	{
		if (locationBulkUpdatesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickLocationBulkUpdatesDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isLocationBulkUpdatesDropdownMenuItemVisible() && isLocationBulkUpdatesDropdownMenuItemEnabled())
		{
			locationBulkUpdatesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickLocationBulkUpdatesDropdownMenuItem");
			e.printStackTrace();
		} 
	}	
	
	// -------------------Fulfillment Zones Dropdown Menu Item----------------------------
	
	private boolean isFulfillmentZonesDropdownMenuItemVisible()
	{
		if (fulfillmentZonesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isFulfillmentZonesDropdownMenuItemEnabled()
	{
		if (fulfillmentZonesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickFulfillmentZonesDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isFulfillmentZonesDropdownMenuItemVisible() && isFulfillmentZonesDropdownMenuItemEnabled())
		{
			fulfillmentZonesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickFulfillmentZonesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Vendors Dropdown Menu Item----------------------------
	
	private boolean isVendorsDropdownMenuItemVisible()
	{
		if (vendorsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorsDropdownMenuItemEnabled()
	{
		if (vendorsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorsDropdownMenuItem()
	{
		try{
		locationsDropdownMenu.click();
		
		if (isVendorsDropdownMenuItemVisible() && isVendorsDropdownMenuItemEnabled())
		{
			vendorsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
		
	//#################### Reports Menu Begin ###############################################
	
	// -------------------Run Reports Dropdown Menu Item----------------------------
	

	private boolean isRunReportsDropdownMenuItemVisible()
	{
		if (runReportsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isRunReportsDropdownMenuItemEnabled()
	{
		if (runReportsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickRunReportsDropdownMenuItem()
	{
		try{
		reportsDropdownMenu.click();
		
		if (isRunReportsDropdownMenuItemVisible() && isRunReportsDropdownMenuItemEnabled())
		{
			runReportsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickRunReportsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Schedule Reports Dropdown Menu Item----------------------------
	
	private boolean isScheduleReportsDropdownMenuItemVisible()
	{
		if (scheduleReportsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isScheduleReportsDropdownMenuItemEnabled()
	{
		if (scheduleReportsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickScheduleReportsDropdownMenuItem()
	{
		try{
		reportsDropdownMenu.click();
		
		if (isScheduleReportsDropdownMenuItemVisible() && isScheduleReportsDropdownMenuItemEnabled())
		{
			scheduleReportsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickScheduleReportsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------View Reports Dropdown Menu Item----------------------------
	

	private boolean isViewReportsDropdownMenuItemVisible()
	{
		if (viewReportsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isViewReportsDropdownMenuItemEnabled()
	{
		if (viewReportsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickViewReportsDropdownMenuItem()
	{
		try{
		reportsDropdownMenu.click();
		
		if (isViewReportsDropdownMenuItemVisible() && isViewReportsDropdownMenuItemEnabled())
		{
			viewReportsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickViewReportsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	//#################### Systems Menu Begin ###############################################
	
	// -------------------Schedule Imports Dropdown Menu Item----------------------------
	
	private boolean isScheduleImportsDropdownMenuItemVisible()
	{
		if (scheduleImportsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isScheduleImportsDropdownMenuItemEnabled()
	{
		if (scheduleImportsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickScheduleImportsDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();	
		
		if (isScheduleImportsDropdownMenuItemVisible() && isScheduleImportsDropdownMenuItemEnabled())
		{
			scheduleImportsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickScheduleImportsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Event Logging Dropdown Menu Item----------------------------

	private boolean isEventLoggingDropdownMenuItemVisible()
	{
		if (eventLoggingDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isEventLoggingDropdownMenuItemEnabled()
	{
		if (eventLoggingDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickEventLoggingDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();	
		
		if (isEventLoggingDropdownMenuItemVisible() && isEventLoggingDropdownMenuItemEnabled())
		{
			eventLoggingDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickEventLoggingDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Roles Dropdown Menu Item----------------------------
	
	private boolean isRolesDropdownMenuItemVisible()
	{
		if (rolesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isRolesDropdownMenuItemEnabled()
	{
		if (rolesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickRolesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();	
		
		if (isRolesDropdownMenuItemVisible() && isRolesDropdownMenuItemEnabled())
		{
			rolesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickRolesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	
	// -------------------User Profiles Dropdown Menu Item----------------------------
	
	private boolean isUserProfilesDropdownMenuItemVisible()
	{
		if (userProfilesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isUserProfilesDropdownMenuItemEnabled()
	{
		if (userProfilesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickUserProfilesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();	
		}catch(Exception e){
			System.out.println("Unable to clickUserProfilesDropdownMenuItem");
			e.printStackTrace();
		} 
		
		try{
		if (isUserProfilesDropdownMenuItemVisible() && isUserProfilesDropdownMenuItemEnabled())
		{
			userProfilesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickUserProfilesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	
	// -------------------Vendor User Profiles Dropdown Menu Item----------------------------
	

	private boolean isVendorUserProfilesDropdownMenuItemVisible()
	{
		if (vendorUserProfilesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isVendorUserProfilesDropdownMenuItemEnabled()
	{
		if (vendorUserProfilesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickVendorUserProfilesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isVendorUserProfilesDropdownMenuItemVisible() && isVendorUserProfilesDropdownMenuItemEnabled())
		{
			vendorUserProfilesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickVendorUserProfilesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Store Associate User Profiles Dropdown Menu Item----------------------------
	
	private boolean isStoreAssociateUserProfilesDropdownMenuItemVisible()
	{
		if (storeAssociateUserProfilesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isStoreAssociateUserProfilesDropdownMenuItemEnabled()
	{
		if (storeAssociateUserProfilesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickStoreAssociateUserProfilesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isStoreAssociateUserProfilesDropdownMenuItemVisible() && isStoreAssociateUserProfilesDropdownMenuItemEnabled())
		{
			storeAssociateUserProfilesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickStoreAssociateUserProfilesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	
	// -------------------Proximity Uploads Profiles Dropdown Menu Item----------------------------
	
	private boolean isProximityUploadsDropdownMenuItemVisible()
	{
		if (proximityUploadsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isProximityUploadsDropdownMenuItemEnabled()
	{
		if (proximityUploadsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickProximityUploadsDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		waitForSeconds(5);
		
		if (isProximityUploadsDropdownMenuItemVisible() && isProximityUploadsDropdownMenuItemEnabled())
		{
			waitForSeconds(5);
			proximityUploadsDropdownMenuItem.click();
			waitForSeconds(5);
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickProximityUploadsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Systems Dropdown Menu Item----------------------------
	

	private boolean isSystemsDropdownMenuItemVisible()
	{
		if (systemsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSystemsDropdownMenuItemEnabled()
	{
		if (systemsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSystemsDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isSystemsDropdownMenuItemVisible() && isSystemsDropdownMenuItemEnabled())
		{
			systemsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickSystemsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Boxes Dropdown Menu Item----------------------------
	
	private boolean isBoxesDropdownMenuItemVisible()
	{
		if (boxesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isBoxesDropdownMenuItemEnabled()
	{
		if (boxesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickBoxesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isBoxesDropdownMenuItemVisible() && isBoxesDropdownMenuItemEnabled())
		{
			boxesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickBoxesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Domains Dropdown Menu Item----------------------------
	
	private boolean isDomainsDropdownMenuItemVisible()
	{
		if (domainsDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isDomainsDropdownMenuItemEnabled()
	{
		if (domainsDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickDomainsDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isDomainsDropdownMenuItemVisible() && isDomainsDropdownMenuItemEnabled())
		{
			domainsDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickDomainsDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Carriers Dropdown Menu Item----------------------------
	
	private boolean isCarriersDropdownMenuItemVisible()
	{
		if (carriersDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isCarriersDropdownMenuItemEnabled()
	{
		if (carriersDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickCarriersDropdownMenuItem()
	{
		
		try{
		systemsDropdownMenu.click();
		
		if (isCarriersDropdownMenuItemVisible() && isCarriersDropdownMenuItemEnabled())
		{
			carriersDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickCarriersDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Tenant Dropdown Menu Item----------------------------
	
	private boolean isTenantDropdownMenuItemVisible()
	{
		if (tenantDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isTenantDropdownMenuItemEnabled()
	{
		if (tenantDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickTenantDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isTenantDropdownMenuItemVisible() && isTenantDropdownMenuItemEnabled())
		{
			tenantDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickTenantDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Reason Codes Dropdown Menu Item----------------------------
	
	private boolean isReasonCodesDropdownMenuItemVisible()
	{
		if (reasonCodesDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isReasonCodesDropdownMenuItemEnabled()
	{
		if (reasonCodesDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickReasonCodesDropdownMenuItem()
	{
		try{
		systemsDropdownMenu.click();
		
		if (isReasonCodesDropdownMenuItemVisible() && isReasonCodesDropdownMenuItemEnabled())
		{
			reasonCodesDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickReasonCodesDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------Web Service Authorization Dropdown Menu Item----------------------------
	
	private boolean isWebServiceAuthorizationDropdownMenuItemVisible()
	{
		if (webServiceAuthorizationDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isWebServiceAuthorizationDropdownMenuItemEnabled()
	{
		if (webServiceAuthorizationDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickWebServiceAuthorizationDropdownMenuItem()
	{
		try{
			systemsDropdownMenu.click();
		
		
		if (isWebServiceAuthorizationDropdownMenuItemVisible() && isWebServiceAuthorizationDropdownMenuItemEnabled())
		{
			webServiceAuthorizationDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickWebServiceAuthorizationDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	// -------------------About Order Broker Dropdown Menu Item----------------------------
	
	private boolean isAboutOrderBrokerDropdownMenuItemVisible()
	{
		if (aboutOrderBrokerDropdownMenuItem.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isAboutOrderBrokerDropdownMenuItemEnabled()
	{
		if (aboutOrderBrokerDropdownMenuItem.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickAboutOrderBrokerDropdownMenuItem()
	{
		waitForSeconds(5);
		try{
		systemsDropdownMenu.click();
		
		if (isAboutOrderBrokerDropdownMenuItemVisible() && isAboutOrderBrokerDropdownMenuItemEnabled())
		{
			aboutOrderBrokerDropdownMenuItem.click();
		}
		else
		{
			// log in error
		}
		}catch(Exception e){
			System.out.println("Unable to clickAboutOrderBrokerDropdownMenuItem");
			e.printStackTrace();
		} 
	}
	
	
	/*
	 * END - Dropdown Menus (Orders, Products, Locations, Reports, Systems, Documentation)
	 */
	
}

