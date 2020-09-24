package pages;

import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import utilities.TestBase;

public class PageObject extends TestBase
{
	//--------------------------------Objects of Page Factory--------------------------------------------------
	@BeforeTest
	public static void PageFactoryObject()
	{
		Authentication authenticationPageObject = new Authentication(driver);
		CreateAccount creatAccountPageObject = new CreateAccount(driver);
		Home homePageObject = new Home(driver);
		Product productPageObject = new Product(driver);
	}
}
