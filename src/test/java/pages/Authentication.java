package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class Authentication extends TestBase
{
    //----------------------------------Authentication Page Elements---------------------------------------
	@FindBy(id = "email_create")
	public static WebElement creatEmail; //new email for registeration

	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	public static WebElement createAccountBtn; //creat account button
	
	@FindBy(id = "email")
	public static WebElement email; //email text box
	
	@FindBy(id = "passwd")
	public static WebElement password; //password text box
	
	@FindBy(xpath = "//p[@class='submit']//span[1]")
	public static WebElement signInBtn; //sign in button
	
	@FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
	public static WebElement invalidEmailTxt; //sign in button
	
	@FindBy(xpath = "//li[contains(text(),'An account using this email address has already be')]")
	public static WebElement registeredEmailTxt; //sign in button
	//=====================================Actions==========================================
	public static void enterNewEmail(String newEmail)
    {
		creatEmail.sendKeys(newEmail);
    }
	public static void clickCreateAccount()
    {
		createAccountBtn.click();
    }
	public static void enterEmail(String emailAddress)
    {
		email.sendKeys(emailAddress);
    }
	public static void enterPassword(String pass)
    {
		password.sendKeys(pass);
    }
	public static void clickSignIn()
    {
		signInBtn.click();
    }
	public static void signIn(String email, String pass)
    {
		Home.signIn();
		enterEmail(email);
		enterPassword(pass);
		clickSignIn();
    }
	//======================================================================================
	public Authentication(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}