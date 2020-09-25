package stepDef;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Authentication;
import pages.Home;
import pages.CreateAccount;
import pages.Product;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

public class ProductOrderSteps 
{
	@Given("^automationpractice website is opened$")
	public void automationpractice_website_is_opened() {
		ExtentReport.startTC("Validate that the order is placed in order history page after authenticating as new user");
	    TestBase.openWebsite();
	}

	@When("^press Sign in$")
	public void press_sign_in() {
	    Home.signIn();
	}

	@When("^write new \"(.*)\"$")
	public void write_new(String newEmail) {
	    Authentication.enterNewEmail(newEmail);
	}

	@When("^press create an account$")
	public void press_create_an_account() {
	    Authentication.clickCreateAccount();
	}

	@When("^select \"(.*)\"$")
	public void select(String gender) {
		if (gender.equals("Mr"))
			CreateAccount.clickMrgender();
		else if (gender.equals("Mrs"))
			CreateAccount.clickMrsgender();
	}

	@When("^write first name with value \"(.*)\"$")
	public void write_first_name_with_vlue(String firstNameValue) {
	    CreateAccount.enterFirstName(firstNameValue);
	}

	@When("^write last name with value \"(.*)\"$")
	public void write_last_name_with_value(String lastNameValue) {
		CreateAccount.enterLastName(lastNameValue);
	}

	@When("^write password with value \"(.*)\"$")
	public void write_password_with_value_test(String pass) {
		CreateAccount.enterPassword(pass);
	}

	@When("^write address with value \"(.*)\"$")
	public void write_address_with_value(String Address) {
		CreateAccount.enterFirstAddress(Address);
	}

	@When("^write city \"(.*)\"$")
	public void choose_city(String cityValue) {
		CreateAccount.enterCity(cityValue);
	}

	@When("^choose state \"(.*)\"$")
	public void choose_state(String stateValue) {
		CreateAccount.selectState(stateValue);
	}

	@When("^write postal code with value \"(.*)\"$")
	public void write_postal_code_with_value(String code) {
		CreateAccount.enterPostalCode(code);
	}

	@When("^write mobile number with value \"(.*)\"$")
	public void write_mobile_number_with_value(String mobile) {
		CreateAccount.enterMobilePhone(mobile);
	}
	
	@When("^click Register$")
	public void click_register() {
		CreateAccount.clickRegister();
	}

	@When("^select the \"(.*)\"$")
	public void select_the(String category) {
		Home.selectWomenCategory();
	}

	@When("^click on \"(.*)\"$")
	public void click_on(String subcategory) {
	    Home.clickBlouses();
	}

	@When("^click on \"(.*)\" to buy$")
	public void click_on_to_buy(String resultItem) {
	    Home.clickBlouseItem();
	}

	@When("^click on Add to Cart to enter the process$")
	public void click_on_add_to_cart_to_enter_the_process() {
	    Product.clickAddToCart();
	}

	@When("^click on Proceed to checkout to check product summary$")
	public void click_on_proceed_to_checkout_to_check_product_summary() throws InterruptedException {
	    Product.clickProceedToChecout();
	}

	@When("^click on Proceed to checkout for product summary$")
	public void click_on_proceed_to_checkout_for_product_summary() throws InterruptedException {
	    Product.clickSummaryProceed();
	}

	@When("^click on Proceed to checkout for address$")
	public void click_on_proceed_to_checkout_for_address() throws InterruptedException {
	    Product.clickAddressProceed();
	}

	@When("^click on Terms of service checkbox$")
	public void click_on_terms_of_servic_checkbox() {
	    Product.agreeTerms();
	}

	@When("^click on Proceed to checkout for shipping$")
	public void click_on_proceed_to_checkout_for_shipping() throws InterruptedException {
	    Product.clickShippingProceed();
	}

	@When("^click on pay by bank wire to choose the payment method$")
	public void click_on_pay_by_bank_wire_to_choose_the_payment_method() throws InterruptedException {
	    Product.clickBankWire();
	}

	@When("^click on I confirm my order to finish process$")
	public void click_on_i_confirm_my_order_to_finish_process() throws InterruptedException {
	    Product.clickConfirm();
	}

	@When("^click on Back to orders to check order history$")
	public void click_on_back_to_orders_to_check_order_history() throws InterruptedException {
	    Product.clickBackToOrders();
	}

	@Then("^validate that the order is placed in order history page with the correct date and \"(.*)\"$")
	public void validate_that_the_order_is_placed_in_order_history_page_with_the_correct_date_and(String price) throws IOException {
		Verification.verifyelement(Product.orderDate, "Order date is found and its value is: "+Product.getOrderDate(), "Order date is not found");
		Verification.verifyelementText(Product.orderPrice, price, "Product price equals the expected price", "Price found is: "+price);
		Screenshot.saveScreenshot(TestBase.driver, "Validate that the order is placed in order history page after authenticating as new user"); //take screenshot
	}
}
