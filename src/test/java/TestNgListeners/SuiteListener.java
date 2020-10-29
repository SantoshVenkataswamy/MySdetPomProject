package TestNgListeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import Factories.ReporterFactory;

public class SuiteListener implements ISuiteListener{

	public void onFinish(ISuite arg0) {

		ReporterFactory.getReporter().StopSuite(arg0.getName());
		
	}

	public void onStart(ISuite arg0) {
		
		ReporterFactory.getReporter().StartSuite(arg0.getName());
		
	}

}
