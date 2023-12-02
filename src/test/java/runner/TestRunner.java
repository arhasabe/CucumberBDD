package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/resources/Features", glue = "stepDefinitions", monochrome = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@Sanity or @Smoke or @Regression")
public class TestRunner extends AbstractTestNGCucumberTests {

}
