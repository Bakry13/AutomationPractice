package utilities;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

public class Verification 
{
	public static boolean failureFlag = false;
	public static int statusCode = 0;
	public static String jsonString = "0";
	public static String code = "0";
	public static String reason = "0";
	public static String message = "0";
	//--------------------------------verify if a certain element exists----------------------------------------
	public static boolean verifyelement(WebElement element, String successText, String failureText) throws IOException
	{
		try
		{
			assert element.isDisplayed(); //find if the element is displayed
			ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
			failureFlag = true;
		} catch (Exception e) 
		{
			ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
			failureFlag = false;
			e.printStackTrace();
		}
		return failureFlag;
	}
	//-------------------------------verify the correctness of text of a certain element------------------------------
	public static boolean verifyelementText(WebElement element, String elementText, String successText, String failureText) throws IOException
	{		
		try {
			if(element.getText().equals(elementText))
			{  
				ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
				failureFlag = true;
			}
			else
			{  
				ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
				failureFlag = false;  
			}
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
			failureFlag = false; 
		}
		return failureFlag;
	}
}
