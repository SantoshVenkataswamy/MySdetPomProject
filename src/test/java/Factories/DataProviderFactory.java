package Factories;

import java.io.IOException;
import java.util.Date;

import dataProvider.ConfigurationDataProvider;
import dataProvider.TestDataProvider;

/*
 * This class does the following:
 * - Create Data Provider Reader
 * - Maintain an instance of the Data Provider Reader so that single reader can be used across tests/framework
 */
public class DataProviderFactory 
{
	private static ConfigurationDataProvider configurationDataProvider = null;
	private static TestDataProvider testDataProvider = null;
	private static String configurationFilePath = "config.properties"; 
	private static String testDataFilePath = "TestData.xlsx";
	private static String dateFormat;
	
	public static ConfigurationDataProvider getConfigurationDataProvider()
	{
		if (configurationDataProvider == null)
		{
			try {
				configurationDataProvider = new ConfigurationDataProvider(configurationFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create Configuration Reader Exception ->" + e.getMessage());
			}
		}
		
		return configurationDataProvider; 
	}
	
	public static TestDataProvider getTestDataProvider()
	{
		if (testDataProvider == null)
		{
			try {
				testDataProvider = new TestDataProvider(testDataFilePath);
			} catch (IOException e) {
				
				System.out.println("Not able to create Test Data Provider Exception ->" + e.getMessage());
			} 
		}
		
		return testDataProvider;
	}
	
	/*public static void dateFormat(){
	String date;
	Date d = new Date();
	date=d.toString().replaceAll(" ", "_");
	date=date.replaceAll(":", "_");
	date=date.replaceAll("\\+", "_");
	

	System.out.println(date);
			


	//date=getDateTime().split(" ")[0];		
	//date=date.replaceAll("/", "_") + "_" + release;		
	Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	cal.add(Calendar.DATE, 0);
	date=dateFormat.format(cal.getTime());
	System.out.println(date);
	
	}*/
	
	public static String getDateFormat(){
		
			
			Date d = new Date();
			dateFormat = d.toString().replace(" ", "_");
			dateFormat=dateFormat.replaceAll(":", "_");
			dateFormat=dateFormat.replaceAll("\\+", "_");
			System.out.println(dateFormat);
		
		return dateFormat;
		
	}
	
}
