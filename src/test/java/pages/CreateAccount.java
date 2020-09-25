package pages;

import org.openqa.selenium.Keys;
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
	
	@FindBy(id = "alias")
	public static WebElement alias; //alias for future reference
	
	@FindBy(id = "email")
	public static WebElement email;
	
	@FindBy(id = "days")
	public static WebElement birthDay;
	
	@FindBy(id = "months")
	public static WebElement birthMonth;
	
	@FindBy(id = "years")
	public static WebElement birthYear;
	
	@FindBy(xpath = "//span[contains(text(),'Register')]")
	public static WebElement registerBtn; //Register Button
	
	@FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
	public static WebElement personalInformationTitle; //Register Button
	
	@FindBy(xpath = "//b[contains(text(),'firstname')]")
	public static WebElement requiredFirstNameTxt; //first name error text
	
	@FindBy(xpath = "//b[contains(text(),'lastname')]")
	public static WebElement requiredLastNameTxt; //last name error text
	
	@FindBy(xpath = "//b[contains(text(),'email')]")
	public static WebElement requiredEmailTxt; //email error text
	
	@FindBy(xpath = "//b[contains(text(),'passwd')]")
	public static WebElement requiredPasswordTxt; //password error text
	
	@FindBy(xpath = "//b[contains(text(),'address1')]")
	public static WebElement requiredAddress1Txt; //Address1 error text
	
	@FindBy(xpath = "//b[contains(text(),'city')]")
	public static WebElement requiredCityTxt; //city error text
	
	@FindBy(xpath = "//li[contains(text(),'This country requires you to choose a State.')]")
	public static WebElement requiredStateTxt; //state error text
	
	@FindBy(xpath = "//li[contains(text(),'The Zip')]")
	public static WebElement requiredPostalcodeTxt; //postal code error text
	
	@FindBy(xpath = "//li[contains(text(),'You must register at least one phone number.')]")
	public static WebElement requiredMobileTxt; //mobile error text
	
	@FindBy(xpath = "//b[contains(text(),'alias')]")
	public static WebElement requiredAliasTxt; //alias error text
	
	@FindBy(xpath = "//li[contains(text(),'Invalid date of birth')]")
	public static WebElement invalidBirthDateTxt; //birth date error text
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
	public static void enterFirstAddress(String address)
    {
		address1.sendKeys(address);
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
	public static void selectBirthDay(String day) throws InterruptedException
    {
		birthDay.sendKeys(day);
    }
	public static void selectBirthMonth(String month) throws InterruptedException
    {
		birthMonth.sendKeys(month);
    }
	public static void selectBirthYear(String year)
    {
		birthYear.sendKeys(year);
    }
	public static void selectBirthDate(String day, String month, String year) throws InterruptedException
    {
		selectBirthDay(day);
		selectBirthMonth(month);
		selectBirthYear(year);
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
	public static void clearAlias()
    {
		alias.clear();
    }
	public static void clearEmail()
    {
		email.clear();
    }
	//======================================================================================
	public CreateAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}