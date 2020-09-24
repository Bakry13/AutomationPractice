package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.TestBase;

public class CreateAccount extends TestBase
{
    //----------------------------------Create Account Page Elements---------------------------------------
	@FindBy(id = "id_gender1")
	public static WebElement mrGender; //Male gender radio button
	
	@FindBy(id = "id_gender2")
	public static WebElement mrsGender; //Female gender radio button
	
	@FindBy(id = "customer_firstname")
	public static WebElement firstName; //first name txt box
	
	@FindBy(id = "customer_lastname")
	public static WebElement lastName; //last name txt box
	
	@FindBy(id = "passwd")
	public static WebElement password; //password text box
	
	@FindBy(id = "address1")
	public static WebElement address1; //address1 text box
	
	@FindBy(id = "city")
	public static WebElement city; //address1 text box
	
	@FindBy(id = "id_state")
	public static WebElement state; //state drop down
	
	@FindBy(id = "postcode")
	public static WebElement postalCode; //postal code text box
	
	@FindBy(id = "phone_mobile")
	public static WebElement mobilePhone; //mobile phone text box
	
	@FindBy(xpath = "//span[contains(text(),'Register')]")
	public static WebElement registerBtn; //Register Button
	//=====================================Actions==========================================
	public static void clickMrgender()
    {
		mrGender.click();
    }
	public static void clickMrsgender()
    {
		mrsGender.click();
    }
	public static void enterFirstName(String firstNameValue)
    {
		firstName.sendKeys(firstNameValue);
    }
	public static void enterLastName(String lastNameValue)
    {
		lastName.sendKeys(lastNameValue);
    }
	public static void enterPassword(String pass)
    {
		password.sendKeys(pass);
    }
	public static void enterFirstAddress(String Address)
    {
		address1.sendKeys(Address);
    }
	public static void enterCity(String cityValue)
    {
		city.sendKeys(cityValue);
    }
	public static void selectState(String stateValue)
    {
		Select stateList = new Select(state);
		stateList.selectByVisibleText(stateValue);
    }
	public static void enterPostalCode(String code)
    {
		postalCode.sendKeys(code);
    }
	public static void enterMobilePhone(String mobile)
    {
		mobilePhone.sendKeys(mobile);
    }
	public static void clickRegister()
    {
		registerBtn.click();
    }
	//======================================================================================
	public CreateAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}