package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = {"src/test/java/features"}
        ,glue = {"stepDef", "pages", "utilities"}
        ,tags = ("@productOrder")
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
//      ,"json:test-output/jsonReport/jsonReport.json"
        //,"junit:test-output/junitReport/xmlReport.xml"
        //,"com.cucumber.listener.ExtentCucumberFormatter:"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends TestBase {
}