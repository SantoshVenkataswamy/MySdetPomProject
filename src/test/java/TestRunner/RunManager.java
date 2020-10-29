package TestRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import testCases.BaseTest;

public class RunManager extends BaseTest
{
	
	public static void main(String[] args) 
	{
		//Calling testng.xml in RunManager
		
		List<String> testngXMlList = new ArrayList<String>();
		testngXMlList.add("Smoke_Tests.xml");
		TestNG runner = new TestNG();
		
		
		runner.setTestSuites(testngXMlList);
		runner.run();
		
		// Calling email Method from Email Package
		try{
		//CompanyEmail.main(args);
		System.out.println("email sent");
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	}

