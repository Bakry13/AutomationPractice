package pages;

import org.openqa.selenium.By;
import io.cucumber.java.After;
import utilities.actions.ElementActions;

public class Home extends ElementActions {
	//----------------------------------Home Page Elements---------------------------------------
	By signIn = By.xpath("//a[@class='login']"); //Sign in

	By signOut = By.linkText("Sign out"); //Sign out

	By womenCategory = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"); //women category

	By blousesSubcategory = By.linkText("Blouses"); //blouses Subcategory

	By blousesPrice = By.xpath("//div[@class='right-block']//span[@class='price product-price'][contains(text(),'$27.00')]"); //blouses Subcategory price

	By blouseItem = By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]"); //blouses Subcategory
	//=====================================Actions==========================================
	public void signIn()
    {
		getElement(signIn).click();
    }

	@After("@SigndIn")
	public void signOut()
    {
		getElement(signOut).click();
    }

	public void selectWomenCategory()
    {
		getElement(womenCategory);
    }
	
	public void clickBlouses()
    {
		getElement(blousesSubcategory).click();
    }
	
	public void clickBlouseItem()
    {
		getElement(blouseItem).click();
    }
}