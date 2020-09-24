package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class Screenshot extends TestBase 
{
	public static String capture(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/resources/screenshots/"+screenshotName + ".png"; //Write screenshot name with the running language
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}
	
	public static void saveScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		String screenshotDest = Screenshot.capture(driver, screenshotName); //renaming the screenshot image
		String screenshotPath = "../screenshots/"+screenshotName + ".png"; //Saving images to be relative to extent report
		ExtentReport.test.log(LogStatus.PASS, "Screenshot Below: " + ExtentReport.test.addScreenCapture(screenshotPath)); //saving screeshot in extent report
	}
}
