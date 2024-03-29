package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.actions.ElementActions;

import java.util.List;

import static org.testng.Assert.*;

public class Assertions extends ElementActions {
    public SoftAssert feSoftAssert = new SoftAssert();
    //================================Assertions By locator============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(By locator) {
        assert getElement(locator).isDisplayed();
    }

    public void assertElementNotExist(By locator) {
        try {
            assert getElement(locator).isDisplayed();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(By locator) {
        assertTrue(getElement(locator).isEnabled());
    }

    public void assertElementDisabled(By locator) {
        assertFalse(getElement(locator).isEnabled());
    }
    public void assertButtonEnabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(By locator, String text) {
        String elementText = "";
        elementText = getElement(locator).getText();
        assertEquals(elementText, text);
    }
    public void assertTextContainsElementText(By locator, String text) {
        String elementText = "";
        elementText = getElement(locator).getText();
        assertTrue(text.contains(elementText));
    }

    public void assertURLText(String expectedURL) {
        String actualURL = "";
        actualURL = getDriver().getCurrentUrl();
        assertTrue(actualURL.contains(expectedURL));
    }

    public void assertTitleText(String expectedTitle) {
        String actualTitle = "";
        actualTitle = getDriver().getTitle();
        assertTrue(actualTitle.contains(expectedTitle));
    }
    //===================================Assert list size=====================================
    public void assertListSize(By locator, String size) {
        String listSize = "";
        int listSizeInt = getDriver().findElements(locator).size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
    }
    //================================Assertions By Element============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(WebElement element) {
        assert element.isDisplayed();
    }

    public void assertElementNotExist(WebElement element) {
        try {
            assert element.isDisplayed();
            System.out.println("Assertions failed - Element exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element does not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    public void assertElementDisabled(WebElement element) {
        assertFalse(element.isEnabled());
    }

    public void assertButtonEnabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertEquals(elementText, text);
    }
    public void assertTextContainsElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertTrue(text.contains(elementText));
    }
    //===================================Assert list size=====================================
    public void assertListSize(List<WebElement> element, String size) {
        String listSize = "";
        int listSizeInt = element.size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
    }
    //==============================================================================================
}
