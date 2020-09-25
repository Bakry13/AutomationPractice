package stepDef;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Authentication;
import pages.CreateAccount;
import pages.Home;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

public class AccountCreationSteps {
	//=========================Account Creation scenario===================================
	@Given("^open automation practic website and have email account with status \"(.*)\"$")
	public void open_automation_practic_website_and_have_email_account_with_status(String emailStatus) {
		ExtentReport.startTC("Validate the correct page response when email address is " + emailStatus);
	    TestBase.openWebsite();
	}

	@When("^click sign in$")
	public void click_sign_in() {
	    Home.signIn();
	}

	@When("^write email address with value \"(.*)\"$")
	public void write_email_address_with_value(String email) {
		Authentication.enterNewEmail(email);
	}

	@Then("^validate on page \"(.*)\" according to \"(.*)\"$")
	public void validate_on_page(String result, String emailStatus) throws IOException {
		if (emailStatus.equals("invalid") || emailStatus.equals("empty"))
			Verification.verifyelementText(Authentication.invalidEmailTxt, result, "The massage correctly appeared and equal: "+ result, "The massage did't correctly appear and equal: "+ result);
		else if (emailStatus.equals("registered"))
			Verification.verifyelementText(Authentication.registeredEmailTxt, result, "The massage correctly appeared and equal: "+ result, "The massage did't correctly appear and equal: "+ result);
		else if (emailStatus.equals("new"))
			Verification.verifyelementText(CreateAccount.personalInformationTitle, result, "The massage correctly appeared and equal: "+ result, "The massage did't correctly appear and equal: "+ result);
		Screenshot.saveScreenshot(TestBase.driver, "Validate the correct page response when email address is " + emailStatus); //take screenshot
	}
	//========================Mandatory field Scenario===============================
	@Given("^open automation practic website and have empty mandatory \"(.*)\"$")
	public void open_automation_practic_website_and_have_empty_mandatory(String field) {
		ExtentReport.startTC("Validate that we should fill " + field);
	    TestBase.openWebsite();
	}

	@When("^write \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" while one \"(.*)\" of them is empty")
	public void write_while_one_of_them_is_empty(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String mobile, String field) {
	    CreateAccount.enterFirstName(firstName);
	    CreateAccount.enterLastName(lastName);
	    if (field.equals("email")) CreateAccount.clearEmail();
	    CreateAccount.enterPassword(password);
	    CreateAccount.enterFirstAddress(address);
	    CreateAccount.enterCity(city);
	    if (!(field.equals("state"))) CreateAccount.selectState(state);
	    CreateAccount.enterPostalCode(postalCode);
	    CreateAccount.enterMobilePhone(mobile);
	    if (field.equals("alias")) CreateAccount.clearAlias();
	}

	@Then("^validate on page \"(.*)\" according to the empty \"(.*)\"$")
	public void validate_on_page_according_to_the_empty(String result, String field) throws IOException {
		if (field.equals("email"))
			Verification.verifyelementText(CreateAccount.requiredEmailTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared: "+result);
		else if (field.equals("firstName"))
			Verification.verifyelementText(CreateAccount.requiredFirstNameTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("lastName"))
			Verification.verifyelementText(CreateAccount.requiredLastNameTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("password"))
			Verification.verifyelementText(CreateAccount.requiredPasswordTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("address"))
			Verification.verifyelementText(CreateAccount.requiredAddress1Txt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("city"))
			Verification.verifyelementText(CreateAccount.requiredCityTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("state"))
			Verification.verifyelementText(CreateAccount.requiredStateTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("postalCode"))
			Verification.verifyelementText(CreateAccount.requiredPostalcodeTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("mobile"))
			Verification.verifyelementText(CreateAccount.requiredMobileTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		else if (field.equals("alias"))
			Verification.verifyelementText(CreateAccount.requiredAliasTxt, result, "Correct error text eppeared: "+result,  "Wrong error text eppeared");
		Screenshot.saveScreenshot(TestBase.driver, "Validate that we should fill " + field); //take screenshot
	}
	
	//==============================Create account with invalid password==========================
	@Given("^open automation practic website and we have invalid \"(.*)\"$")
	public void open_automation_practic_website(String field) {
		ExtentReport.startTC("Validate that we cannot register with invalid "+ field);
	    TestBase.openWebsite();
	}

	@When("^write \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" with invalid \"(.*)\"$")
	public void write_invalid(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String mobile, String day, String month, String year, String field) throws InterruptedException {
		CreateAccount.enterFirstName(firstName);
	    CreateAccount.enterLastName(lastName);
	    CreateAccount.enterPassword(password);
	    if (field.equals("birthDate(incomplete)")||field.equals("birthDate(futureDate)")) 
	    	CreateAccount.selectBirthDate(day, month, year);
	    CreateAccount.enterFirstAddress(address);
	    CreateAccount.enterCity(city);
	    CreateAccount.selectState(state);
	    CreateAccount.enterPostalCode(postalCode);
	    CreateAccount.enterMobilePhone(mobile);
	}

	@Then("^validate on page \"(.*)\" according to the invalid \"(.*)\"$")
	public void validate_on_page_according_to_the_invalid(String result, String field) throws IOException {
		if (field.equals("password"))
			Verification.verifyelementText(CreateAccount.requiredPasswordTxt, result, "When password less than 5 characters, correct error text eppeared: "+result,  "When password less than 5 characters, Wrong error text eppeared");
		if (field.equals("birthDate(incomplete)")||field.equals("birthDate(futureDate)"))
			Verification.verifyelementText(CreateAccount.invalidBirthDateTxt, result, "Invalid value of "+field+": "+result,  "When password less than 5 characters, Wrong error text eppeared");
		Screenshot.saveScreenshot(TestBase.driver, "Validate that we cannot register with invalid "+ field); //take screenshot
	}
}