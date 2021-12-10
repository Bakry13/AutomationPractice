package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import utilities.Assertions;
import utilities.Paths;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;

public class Authentication extends ElementActions {
	JSONObject customerData = (JSONObject) JsonTestDataReader.parseJson(Paths.customerDataPath);
	Home home = new Home();
	Assertions assertions = new Assertions();
    //----------------------------------Authentication Page Elements---------------------------------------
	By createEmail = By.id("email_create");

	By createAccountBtn = By.id("SubmitCreate");

	By email = By.id("email");

	By password = By.id("passwd");

	By signInBtn = By.xpath("//p[@class='submit']//span[1]");

	By invalidEmailTxt = By.cssSelector("div[id='create_account_error'] ol li");
	//=====================================Strings==========================================
	String invalidEmailMsg = "Invalid email address.";
	String registeredEmailMsg = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
	//=====================================Actions==========================================
	public void enterNewEmail(String newEmail)
    {
		String email = customerData.get(newEmail).toString();
		getElement(createEmail).sendKeys(email);
    }

	public void clickCreateAccount()
    {
		getElement(createAccountBtn).click();
		try {Thread.sleep(4000);} catch (InterruptedException ignored) {}
	}

	public void enterEmail(String emailAddress)
    {
		getElement(email).sendKeys(emailAddress);
    }

	public void enterPassword(String pass)
    {
		getElement(password).sendKeys(pass);
    }

	public void clickSignIn()
    {
		getElement(signInBtn).click();
    }

	public void signIn(String email, String pass)
    {
		home.signIn();
		enterEmail(email);
		enterPassword(pass);
		clickSignIn();
    }
	//==========================================Text Assertions===============================
	public void assertInvalidEmailTxt()
	{
		assertions.assertElementText(invalidEmailTxt, invalidEmailMsg);
	}

	public void assertAlreadyRegisteredEmailTxt()
	{
		assertions.assertElementText(invalidEmailTxt, registeredEmailMsg);
	}
}