package Factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;




public class DataBaseFactory {
	
	private static Connection dataBaseConnection;
	private static DataBaseFactory databaseFactory;
	private static Statement stmt;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd = null;

	private DataBaseFactory()
	{}
	
	public static DataBaseFactory getInstance()
	{
		 if (databaseFactory == null){  
		      synchronized(DataBaseFactory.class){  
		        if (databaseFactory == null){  
		        	databaseFactory = new DataBaseFactory();//instance will be created at request time  
		        }  
		    }              
		    }  
		  return databaseFactory;  
		 }  
   
	
	
	public static Connection getConnection()
	{
		if (dataBaseConnection == null)
		{
			try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				Class.forName("oracle.jdbc.OracleDriver");
				String host=DataProviderFactory.getConfigurationDataProvider().getDataBaseHost();
				String username=DataProviderFactory.getConfigurationDataProvider().getDataBaseUsername();
				String password=DataProviderFactory.getConfigurationDataProvider().getDataBasePassword();
				dataBaseConnection=DriverManager.getConnection(host, username, password);
				stmt=dataBaseConnection.createStatement();
				
			} catch (Exception e) {
				System.out.println("Not able to create Connection Exception ->" + e.getMessage());
			}
		}
		
		return dataBaseConnection; 
	}

	public static HashMap<String,String> getDataBaseData(String query) throws Exception
	{
		HashMap<String,String> result=new HashMap<String,String>();
		rs = stmt.executeQuery(query);
		rsmd = rs.getMetaData();
		int count=rsmd.getColumnCount();
		while(rs.next())
		{
		for(int i=1;i<=count;i++)
		{
		
	    result.put(rsmd.getColumnLabel(i),rs.getString(i));
	  
		}
	}
		return result;
		
	}
}
