package getFailedScenarioRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/resources/Features/VtigerCampaign.feature", glue = "stepDefinitions", monochrome = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty","rerun:target/failedScenario.txt" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
