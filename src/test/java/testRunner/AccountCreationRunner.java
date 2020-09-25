package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features="src/test/java/features/accountCreation.feature"
, glue= {"stepDef","pages","utilities"}
, plugin= {"pretty","html:resources/reports/accountCreation.html"})
public class AccountCreationRunner extends TestBase {

}
