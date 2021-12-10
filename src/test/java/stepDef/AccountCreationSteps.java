package stepDef;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Authentication;
import pages.CreateAccount;

public class AccountCreationSteps extends CreateAccount{
    Authentication authentication = new Authentication();
	//=========================Account Creation scenario===================================
    @Then("I validate on invalid email message")
    public void i_validate_on_invalid_email_message() {
        authentication.assertInvalidEmailTxt();
    }

    @Then("I validate on already registered email message")
    public void i_validate_on_already_registered_email_message() {
        authentication.assertAlreadyRegisteredEmailTxt();
    }
	//========================Mandatory field Scenario===============================
	@When("I clear tested {string}")
	public void i_clear_tested(String field) {
		clearTestedField(field);
	}

	@When("I write {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void write_while_one_of_them_is_empty(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String mobile) {
		fillCreateAccountForm(firstName, lastName, password, address, city, state, postalCode, mobile);
	}

	@Then("I validate on page Error text according to the empty {string}")
	public void i_validate_on_page_error_text_according_to_the_empty(String field) {
		assertEmptyField(field);
	}

	@Then("I validate the invalid password message")
	public void i_validate_the_invalid_password_message() {
		assertInvalidPassword();
	}
	//==============================Create account with invalid password==========================
	@When("I fill birthDate {string}, {string}, {string}")
	public void i_fill_birth_date(String day, String month, String year) {
		selectBirthDate(day, month, year);
	}

	@Then("I validate on invalid birthDate message")
	public void i_validate_on_invalid_birth_date_message() {
		assertInvalidBirthDate();
	}
}