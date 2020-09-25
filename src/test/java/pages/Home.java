package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import utilities.TestBase;

public class Home extends TestBase
{
	//----------------------------------Home Page Elements---------------------------------------
	@FindBy(xpath = "//a[@class='login']")
	public static WebElement signIn; //Sign in
	
	@FindBy(linkText = "Sign out")
	public static WebElement signOut; //Sign out
	
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	public static WebElement womenCategory; //women category
	
	@FindBy(linkText = "Blouses")
	public static WebElement blousesSubcategory; //blouses Subcategory
	
	@FindBy(xpath = "//div[@class='right-block']//span[@class='price product-price'][contains(text(),'$27.00')]")
	public static WebElement blousesPrice; //blouses Subcategory price
	
	@FindBy(xpath = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]")
	public static WebElement blouseItem; //blouses Subcategory
	//=====================================Actions==========================================
	public static void signIn()
    {
		signIn.click();
    }
	@After("@SigndIn")
	public static void signOut()
    {
		signOut.click();
    }
	public static void selectWomenCategory()
    {
		action.moveToElement(womenCategory).perform();
    }
	
	public static void clickBlouses()
    {
		blousesSubcategory.click();
    }
	
	public static void clickBlouseItem()
    {
		blouseItem.click();
    }
	//======================================================================================
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}