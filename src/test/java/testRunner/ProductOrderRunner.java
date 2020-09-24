package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features="src/test/java/features"
, glue= {"stepDef","pages","utilities"}
, plugin= {"pretty","html:resources/reports/productOrder.html"})
public class ProductOrderRunner extends TestBase
{
}
