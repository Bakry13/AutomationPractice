package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.TestBase;

public class Product extends TestBase
{
    //----------------------------------product control Page Elements---------------------------------------
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	public static WebElement addToCart; 
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	public static WebElement proceedToChecout; 
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	public static WebElement summaryProceed;

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	public static WebElement addressProceed;
	
	@FindBy(id = "cgv")
	public static WebElement TermsAgree; //Checkbox
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	public static WebElement shippingProceed;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	public static WebElement bankWire;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	public static WebElement confirmBtn;
	
	@FindBy(linkText = "Back to orders")
	public static WebElement BackToOrers;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	public static WebElement orderDate;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	public static WebElement orderPrice;
	
	@FindBy(id = "our_price_display")
	public static WebElement itemViewPrice; //item price from product details
	
	@FindBy(id = "group_1")
	public static WebElement itemSize;
	
	@FindBy(name = "White")
	public static WebElement itemWhiteColor;
	//=====================================Actions==========================================
	public static void clickAddToCart()
    {
		action.moveToElement(addToCart).click().perform();
    }
	
	public static void clickProceedToChecout() throws InterruptedException
    {
		Thread.sleep(2000);
		action.moveToElement(proceedToChecout).click().perform();
    }
	public static void clickSummaryProceed() throws InterruptedException
    {
		action.moveToElement(summaryProceed).click().perform();
    }
	public static void clickAddressProceed() throws InterruptedException
    {
		action.moveToElement(addressProceed).click().perform();
    }
	public static void agreeTerms()
    {
		TermsAgree.click();
    }
	public static void clickShippingProceed() throws InterruptedException
    {
		action.moveToElement(shippingProceed).click().perform();
    }
	
	public static void clickBankWire() throws InterruptedException
    {
		action.moveToElement(bankWire).click().perform();
    }
	public static void clickConfirm() throws InterruptedException
    {
		action.moveToElement(confirmBtn).click().perform();
    }
	public static void clickBackToOrders() throws InterruptedException
    {
		action.moveToElement(BackToOrers).click().perform();
    }
	public static String getOrderDate()
    {
		return orderDate.getText();
    }
	public static String getPrice()
    {
		return orderPrice.getText();
    }
	public static void selectSize(String size)
    {
		Select sizeList = new Select(itemSize);
		sizeList.selectByVisibleText(size);
    }
	public static void clickWhiteColor()
    {
		itemWhiteColor.click();
    }
	//======================================================================================
	public Product(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}