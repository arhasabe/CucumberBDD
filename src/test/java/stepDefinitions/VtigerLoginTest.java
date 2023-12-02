package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.POM.pages.VtigerLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class VtigerLoginTest extends SeleniumUtility {
	WebDriver driver;
	VtigerLoginPage vtLogin;
	String username = "admin";
	String pwd = "admin";
	String dashboardTitle = "Dashboard";

	@Given("opens the chrome browser and Vtiger application is loaded")
	public void opens_the_chrome_browser_and_vtiger_application_is_loaded() {
		driver = setUp("chrome",
				"https://demo.vtiger.com/vtigercrm/index.php?module=Users&parent=Settings&view=Login&error=login");
		vtLogin = new VtigerLoginPage(driver);
	}

	@When("enters username and password")
	public void enters_username_and_password() {
		vtLogin.enterUsernameAndPassword(username, pwd);
	}

	@When("click on the sign in button")
	public void click_on_the_sign_in_button() {
		vtLogin.clickOnSignInButton();
	}

	@Then("verify login was successful")
	public void verify_login_was_successful() {
		Assert.assertEquals(verifyCurrentPageTitle(dashboardTitle), dashboardTitle);
		tearDown(driver);
	}
}
