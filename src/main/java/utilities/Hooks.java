package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.actions.BrowserActions;

public class Hooks extends TestBase {
    BrowserActions browserActions = new BrowserActions();
    //=========================To write test environment in the report===================
    @Before(order = 0)
    public void testCaseEnvironment(Scenario scenario) {
        scenario.log("Browser type is: "+getBrowserType());
    }
//===========================To attach screenshots in the extent report======================
    @After(order = 10)
    public void takeScreenshot(Scenario scenario) {
        byte[] src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }
}