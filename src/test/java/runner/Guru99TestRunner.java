package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "./src/test/resources/Guru99Features" }, glue = { "guru99.StepDefinitions",
		"appHooks" }, dryRun = false)
public class Guru99TestRunner extends AbstractTestNGCucumberTests {

}
