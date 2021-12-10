package utilities.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BrowserActions extends TestBase {
    ElementActions elementActions = new ElementActions();
    public void navigateToPage(String url) {
        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println(url);
        getDriver().navigate().to(url);
    }

    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public void relaunchBrowser()
    {
        getDriver().quit();
        launchBrowser();
    }

    public void openNewTab()
    {
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    public void switchToAnotherTab(int index)
    {
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(index));
    }

    public void closeBrowser() {
        getDriver().close();
    }

    public void quitBrowser() {
        quitDriver();
    }

    public String getActualTitle()
    {
        String ActualTitle = getDriver().getTitle();
        return ActualTitle;
    }

    public String getActualURL()
    {
        String ActualURL = getDriver().getCurrentUrl();
        return ActualURL;
    }
 //===========================================================================================
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }

    public void restoreView() {
        getDriver().manage().window().maximize();
        getDriver().navigate().refresh();
    }


    //Scrolling
    public void scrollDownToView(WebElement element) {
        ((JavascriptExecutor) getDriver()).
                executeScript("arguments[0].scrollIntoView({behavior:'smooth',block: 'center'});",
                        element);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public void zoomOutOrIn(double percentageIndex) {
        ((JavascriptExecutor) getDriver()).executeScript("document.body.style.zoom='" + percentageIndex + "'");
    }

    public void scrollVertically(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + pixels + ")", "");

    }

    public void scrollHorizontally(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + pixels + ",0)");
    }

    public void scrollDownToBottomOfPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Alerts
    public void approveAlert() {
        getDriver().switchTo().alert().accept();
    }

    public boolean checkIfAlertIsPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //check if window is scrolled up or not (Used to test the back to top button)
    public boolean isWindowScrolledUp() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        Long value = (Long) executor.executeScript("return window.pageYOffset;");
        if (value == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Get Browser Title
    public String getBrowserTitle() {
        return getDriver().getTitle();
    }

    //Check if window is scrolled down or not
    public boolean isWindowScrolledDown() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        Object currValueInnerHeightObj = executor.executeScript("return window.innerHeight");
        Object currValueYOffsetObj = executor.executeScript("return window.pageYOffset");
        Object docHeightObj = executor.executeScript("return document.body.scrollHeight");
        Long currValue = 0L;
        Long docHeight = 0L;

        System.out.println(currValueInnerHeightObj.getClass().toString());
        if (currValueInnerHeightObj.getClass().toString().toLowerCase().contains("long")) {
            currValue = (Long) currValueInnerHeightObj;
        } else {
            currValue = Math.round((Double) currValueInnerHeightObj);
        }

        if (currValueYOffsetObj.getClass().toString().toLowerCase().contains("long")) {
            currValue += (Long) currValueYOffsetObj;
        } else {
            currValue += Math.round((Double) currValueYOffsetObj);
        }

        if (docHeightObj.getClass().toString().toLowerCase().contains("long")) {
            docHeight = (Long) docHeightObj;
        } else {
            docHeight = Math.round((Double) docHeightObj);
        }
        currValue++;
        System.out.println();
        System.out.println("currValue: " + currValue);
        System.out.println("docHeight: " + docHeight);
        return currValue >= docHeight;
    }

    public String getNetworkTabDetails() {
        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        String netData = ((JavascriptExecutor) getDriver()).executeScript(scriptToExecute).toString();
        System.out.println(netData);
        return  netData;
    }
}
