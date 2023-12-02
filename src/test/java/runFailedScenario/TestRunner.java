package runFailedScenario;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/failedScenario.txt"}, glue = {"stepDefinitions"}, monochrome = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty","rerun:target/failedScenario.txt" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
