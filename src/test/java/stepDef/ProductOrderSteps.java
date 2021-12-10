package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Authentication;
import pages.Home;
import pages.CreateAccount;
import pages.Product;
import utilities.Assertions;

public class ProductOrderSteps extends Product {
	Authentication authentication = new Authentication();
	Home home = new Home();
	CreateAccount createAccount = new CreateAccount();
	Assertions assertions = new Assertions();
//==========================================================================================================
	@Given("automationPractice website is opened")
	public void automationPractice_website_is_opened() {
		openWebsite();
	}

	@When("I click Sign in")
	public void click_sign_in() {
	    home.signIn();
	}

	@When("I write new {string}")
	public void write_new(String newEmail) {
	    authentication.enterNewEmail(newEmail);
	}

	@When("I press create an account")
	public void press_create_an_account() {
	    authentication.clickCreateAccount();
	}

	@When("I select {string}")
	public void select(String gender) {
			createAccount.chooseGender(gender);
	}

	@When("I write first name with value {string}")
	public void write_first_name_with_vlue(String firstNameValue) {
	    createAccount.enterFirstName(firstNameValue);
	}

	@When("I write last name with value {string}")
	public void write_last_name_with_value(String lastNameValue) {
		createAccount.enterLastName(lastNameValue);
	}

	@When("I write password with value {string}")
	public void write_password_with_value_test(String pass) {
		createAccount.enterPassword(pass);
	}

	@When("I write address with value {string}")
	public void write_address_with_value(String Address) {
		createAccount.enterFirstAddress(Address);
	}

	@When("I write city {string}")
	public void choose_city(String cityValue) {
		createAccount.enterCity(cityValue);
	}

	@When("I choose state {string}")
	public void choose_state(String stateValue) {
		createAccount.selectState(stateValue);
	}

	@When("I write postal code with value {string}")
	public void write_postal_code_with_value(String code) {
		createAccount.enterPostalCode(code);
	}

	@When("I write mobile number with value {string}")
	public void write_mobile_number_with_value(String mobile) {
		createAccount.enterMobilePhone(mobile);
	}
	
	@When("I click Register")
	public void click_register() {
		createAccount.clickRegister();
	}

	@When("I select the {string}")
	public void select_the(String category) {
		home.selectWomenCategory();
	}

	@When("I click on {string}")
	public void click_on(String subcategory) {
	    home.clickBlouses();
	}

	@When("I click on {string} to buy")
	public void click_on_to_buy(String resultItem) {
	    home.clickBlouseItem();
	}

	@When("I click on Add to Cart to enter the process")
	public void click_on_add_to_cart_to_enter_the_process() {
	    clickAddToCart();
	}

	@When("I click on Proceed to checkout to check product summary")
	public void click_on_proceed_to_checkout_to_check_product_summary(){
	    clickProceedToChecout();
	}

	@When("I click on Proceed to checkout for product summary")
	public void click_on_proceed_to_checkout_for_product_summary(){
	    clickSummaryProceed();
	}

	@When("I click on Proceed to checkout for address")
	public void click_on_proceed_to_checkout_for_address(){
	    clickAddressProceed();
	}

	@When("I click on Terms of service checkbox")
	public void click_on_terms_of_servic_checkbox() {
	    agreeTerms();
	}

	@When("I click on Proceed to checkout for shipping")
	public void click_on_proceed_to_checkout_for_shipping(){
	    clickShippingProceed();
	}

	@When("I click on pay by bank wire to choose the payment method")
	public void click_on_pay_by_bank_wire_to_choose_the_payment_method(){
	    clickBankWire();
	}

	@When("I click on I confirm my order to finish process")
	public void click_on_i_confirm_my_order_to_finish_process(){
	    clickConfirm();
	}

	@When("I click on Back to orders to check order history")
	public void click_on_back_to_orders_to_check_order_history(){
	    clickBackToOrders();
	}

	@Then("I validate that the order is placed in order history page with the correct date and {string}")
	public void validate_that_the_order_is_placed_in_order_history_page_with_the_correct_date_and(String price){
		assertElementInProductHistory(price);
	}
}
