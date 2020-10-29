package Factories;

import java.io.IOException;


import Reporter.TextLogReporter;

public class ReporterFactory {

	private static TextLogReporter reporter = null;
	
	public static TextLogReporter getReporter()
	{
		if(reporter == null)
		{
			try {
				reporter = new TextLogReporter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return reporter;
		
	}

}
