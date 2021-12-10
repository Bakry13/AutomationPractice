package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import utilities.Assertions;
import utilities.Paths;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;

public class CreateAccount extends ElementActions {
	JSONObject customerData = (JSONObject) JsonTestDataReader.parseJson(Paths.customerDataPath);
	Assertions assertions = new Assertions();
    //----------------------------------Create Account Page Elements---------------------------------------
	By mrGender = By.id("id_gender1");

	By mrsGender = By.id("id_gender2");

	By firstName = By.id("customer_firstname");

	By lastName = By.id("customer_lastname");

	By password = By.id("passwd");

	By address1 = By.id("address1");

	By city = By.id("city");

	By state = By.id("id_state"); //state drop down

	By postalCode = By.id("postcode"); //postal code text box

	By mobilePhone = By.id("phone_mobile"); //mobile phone text box

	By alias = By.id("alias"); //alias for future reference

	By email = By.id("email");

	By birthDay = By.id("days");

	By birthMonth = By.id("months");

	By birthYear = By.id("years");

	By registerBtn = By.xpath("//span[contains(text(),'Register')]"); //Register Button

	By personalInformationTitle = By.xpath("//h3[contains(text(),'Your personal information')]"); //Register Button

	By requiredFirstNameTxt = By.xpath("//b[contains(text(),'firstname')]"); //first name error text

	By requiredLastNameTxt = By.xpath("//b[contains(text(),'lastname')]"); //last name error text

	By requiredEmailTxt = By.xpath("//b[contains(text(),'email')]"); //email error text

	By requiredPasswordTxt = By.xpath("//b[contains(text(),'passwd')]"); //password error text

	By requiredAddress1Txt = By.xpath("//b[contains(text(),'address1')]"); //Address1 error text

	By requiredCityTxt = By.xpath("//b[contains(text(),'city')]"); //city error text

	By requiredStateTxt = By.xpath("//li[contains(text(),'This country requires you to choose a State.')]"); //state error text

	By requiredPostalCodeTxt = By.xpath("//li[contains(text(),'The Zip')]"); //postal code error text

	By requiredMobileTxt = By.xpath("//li[contains(text(),'You must register at least one phone number.')]"); //mobile error text

	By requiredAliasTxt = By.xpath("//b[contains(text(),'alias')]"); //alias error text

	By invalidBirthDateTxt = By.xpath("//li[contains(text(),'Invalid date of birth')]"); //birth date error text
	//=====================================Actions==========================================
	public void fillCreateAccountForm(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String mobile)
	{
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPassword(password);
		enterFirstAddress(address);
		enterCity(city);
		if (!(state.equalsIgnoreCase("empty"))) selectState(state);
		enterPostalCode(postalCode);
		enterMobilePhone(mobile);
	}

	public void clearTestedField(String field)
	{
		if (field.equals("email")) clearEmail();
		if (field.equals("alias")) clearAlias();
	}

	public void clickMrgender()
    {
		getElement(mrGender).click();
    }

	public void clickMrsgender()
    {
		getElement(mrsGender).click();
    }

	public void chooseGender(String gender)
	{
		String genderValue = customerData.get(gender).toString();
		if (genderValue.equalsIgnoreCase("Mr"))
			clickMrgender();
		else if (genderValue.equalsIgnoreCase("Mrs"))
			clickMrsgender();
	}

	public void enterFirstName(String firstNameValue)
    {
		String nameValue = customerData.get(firstNameValue).toString();
		getElement(firstName).sendKeys(nameValue);
    }

	public void enterLastName(String lastNameValue)
    {
		String nameValue = customerData.get(lastNameValue).toString();
		getElement(lastName).sendKeys(nameValue);
    }

	public void enterPassword(String pass)
    {
		String passwordValue = customerData.get(pass).toString();
		getElement(password).sendKeys(passwordValue);
    }

	public void enterFirstAddress(String address)
    {
		String addressValue = customerData.get(address).toString();
		getElement(address1).sendKeys(addressValue);
    }

	public void enterCity(String cityValue)
    {
		String cityValue1 = customerData.get(cityValue).toString();
		getElement(city).sendKeys(cityValue1);
    }

	public void selectState(String stateValue)
    {
		String stateValue1 = customerData.get(stateValue).toString();
		selectFromDDL(state,stateValue1);
    }

	public void selectBirthDay(String day)
    {
		String dayValue = customerData.get(day).toString();
		getElement(birthDay).sendKeys(dayValue);
    }

	public void selectBirthMonth(String month)
    {
		String monthValue = customerData.get(month).toString();
		getElement(birthMonth).sendKeys(monthValue);
    }
	public void selectBirthYear(String year)
    {
		String yearValue = customerData.get(year).toString();
		getElement(birthYear).sendKeys(yearValue);
    }

	public void selectBirthDate(String day, String month, String year)
    {
		selectBirthDay(day);
		selectBirthMonth(month);
		selectBirthYear(year);
    }

	public void enterPostalCode(String code)
    {
		String codeValue = customerData.get(code).toString();
		getElement(postalCode).sendKeys(codeValue);
    }

	public void enterMobilePhone(String mobile)
    {
		String mobileValue = customerData.get(mobile).toString();
		getElement(mobilePhone).sendKeys(mobileValue);
    }

	public void clickRegister()
    {
		getElement(registerBtn).click();
    }

	public void clearAlias()
    {
		getElement(alias).clear();
    }

	public void clearEmail()
    {
		getElement(email).clear();
    }
	//============================================Assertions===================================================
	public void assertInvalidPassword()
	{
		assertions.assertElementExist(requiredPasswordTxt);
	}

	public void assertInvalidBirthDate()
	{
		assertions.assertElementExist(invalidBirthDateTxt);
	}

	public void assertEmptyField(String field)
	{
		if (field.equalsIgnoreCase("email"))
		{
			assertions.assertElementExist(requiredEmailTxt);
		}
		else if (field.equalsIgnoreCase("firstName"))
		{
			assertions.assertElementExist(requiredFirstNameTxt);
		}
		else if (field.equalsIgnoreCase("lastName"))
		{
			assertions.assertElementExist(requiredLastNameTxt);
		}
		else if (field.equalsIgnoreCase("password"))
		{
			assertions.assertElementExist(requiredPasswordTxt);
		}
		else if (field.equalsIgnoreCase("address"))
		{
			assertions.assertElementExist(requiredAddress1Txt);
		}
		else if (field.equalsIgnoreCase("city"))
		{
			assertions.assertElementExist(requiredCityTxt);
		}
		else if (field.equalsIgnoreCase("state"))
		{
			assertions.assertElementExist(requiredStateTxt);
		}
		else if (field.equalsIgnoreCase("postalCode"))
		{
			assertions.assertElementExist(requiredPostalCodeTxt);
		}
		else if (field.equalsIgnoreCase("mobile"))
		{
			assertions.assertElementExist(requiredMobileTxt);
		}
		else if (field.equalsIgnoreCase("alias"))
		{
			assertions.assertElementExist(requiredAliasTxt);
		}
	}
}