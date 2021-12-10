package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import utilities.Assertions;
import utilities.Paths;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;

public class Product extends ElementActions {
	JSONObject customerData = (JSONObject) JsonTestDataReader.parseJson(Paths.customerDataPath);
	Assertions assertions = new Assertions();
    //----------------------------------product control Page Elements---------------------------------------
	By addToCart = By.xpath("//span[contains(text(),'Add to cart')]");

	By proceedToChecout = By.xpath("//span[contains(text(),'Proceed to checkout')]");

	By summaryProceed = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");

	By addressProceed = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");

	By TermsAgree = By.id("cgv"); //Checkbox

	By shippingProceed = By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");

	By bankWire = By.xpath("//a[@class='bankwire']");

	By confirmBtn = By.xpath("//span[contains(text(),'I confirm my order')]");

	By BackToOrers = By.linkText("Back to orders");

	By orderDate = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");

	By orderPrice = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]");

	By itemViewPrice = By.id("our_price_display"); //item price from product details

	By itemSize = By.id("group_1");

	By itemWhiteColor = By.name("White");
	//=====================================Actions==========================================
	public void clickAddToCart()
    {
		getElement(addToCart).click();
    }
	
	public void clickProceedToChecout()
    {
		try {Thread.sleep(2000);} catch (InterruptedException ignored) {}
		getElement(proceedToChecout).click();
    }

	public void clickSummaryProceed()
    {
		getElement(summaryProceed).click();
    }

	public void clickAddressProceed()
    {
		getElement(addressProceed).click();
    }

	public void agreeTerms()
    {
		getElement(TermsAgree).click();
    }

	public void clickShippingProceed()
    {
		getElement(shippingProceed).click();
    }
	
	public void clickBankWire()
    {
		getElement(bankWire).click();
    }
	public void clickConfirm()
    {
		getElement(confirmBtn).click();
    }
	public void clickBackToOrders()
    {
		getElement(BackToOrers).click();
    }

	public String getOrderDate()
    {
		return getElement(orderDate).getText();
    }

	public String getPrice()
    {
		return getElement(orderPrice).getText();
    }

	public void selectSize(String size)
    {
		selectFromDDL(itemSize, size);
    }
	public void clickWhiteColor()
    {
		getElement(itemWhiteColor).click();
    }
	//===========================================Assertions===================================================
	public void assertElementInProductHistory(String price)
	{
		String priceValue = customerData.get(price).toString();
		assertions.assertElementExist(orderDate);
		assertions.assertElementText(orderPrice, priceValue);
	}
}