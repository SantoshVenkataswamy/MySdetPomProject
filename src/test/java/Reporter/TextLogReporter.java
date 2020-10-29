package Reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/*
 * This reporter logs information in a text file
 */
public class TextLogReporter 
{
	private BufferedWriter buffWriter = null;
	private FileWriter fileWriter = null;
	private File logFile = null;
	
	public TextLogReporter() throws IOException
	{
		String fileName = (new Date()).toString().replace(" ", "").replace("/", "_").replace("-", "_").replace(":", "_") + ".txt";
		logFile = new File(fileName);
		logFile.createNewFile();
		fileWriter = new FileWriter(logFile);
		buffWriter = new BufferedWriter(fileWriter);		
	}
	
	public void Log(String logInfo)
	{
		try {
			buffWriter.write(logInfo+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Debug(String debugInfo)
	{
		try {
			buffWriter.write(debugInfo+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Warn(String warnInfo)
	{
		try {
			buffWriter.write(warnInfo+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Error(String errorInfo)
	{
		try {
			buffWriter.write(errorInfo+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void StartTest(String testCaseName)
	{
		try {
			buffWriter.write("============================================================================" + "\n");
			buffWriter.write("==================== Starting test " + testCaseName + "=====================" + "\n");
			buffWriter.write("============================================================================" + "\n");
		} catch (IOException e) {
			
		}			
	}
	
	public void StopTest(String testCaseName)
	{
		try {
			buffWriter.write("============================================================================" + "\n");
			buffWriter.write("==================== Stopping test " + testCaseName + "=====================" + "\n");
			buffWriter.write("============================================================================" + "\n\n");
		} catch (IOException e) {
			
		}			
	}
	
	public void StartSuite(String testSuiteName)
	{
		try {
			buffWriter.write("##############################################################################" + "\n");
			buffWriter.write("#################### Starting Suite " + testSuiteName + "#####################" + "\n");
			buffWriter.write("##############################################################################" + "\n\n\n\n");
		} catch (IOException e) {
			
		}			
	}
	
	public void StopSuite(String testSuiteName)
	{
		try {
			buffWriter.write("##############################################################################" + "\n");
			buffWriter.write("#################### Stopping Suite " + testSuiteName + "#####################" + "\n");
			buffWriter.write("##############################################################################" + "\n\n\n\n");
		} catch (IOException e) {
			
		}			
	}
	
	
	public void StopLogging()
	{
		try {
			buffWriter.flush();
			buffWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
