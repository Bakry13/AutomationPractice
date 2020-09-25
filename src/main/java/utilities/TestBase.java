package utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static Actions action;
	static String driverPath = System.getProperty("user.dir")+"/resources/drivers/";
	@BeforeTest
	@Parameters("Browser")
	public static void WebInit(@Optional("Chrome") String Browser)
	{
		try {
			if(Browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", driverPath+"ChromeDriver.exe");
				DesiredCapabilities chromeCap = new DesiredCapabilities();
				chromeCap.setCapability("resolution", "1024x768");
				driver = new ChromeDriver(chromeCap);
			}
			else if(Browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				DesiredCapabilities fireFoxCap = new DesiredCapabilities();
				fireFoxCap.setCapability("resolution", "1024x768");
				driver = new FirefoxDriver(fireFoxCap);
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); //wait until loading the initial webpage
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			action = new Actions(driver); // for mouse actions
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	void closedriver()
	{
		driver.quit();
	}
	//@Test
	public static void openWebsite()
	{
		//WebInit("Chrome");
		driver.get("http://automationpractice.com");
	}
}
