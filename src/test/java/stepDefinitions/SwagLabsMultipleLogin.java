package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.POM.pages.SwagLabsHomepage;
import com.POM.pages.SwagLabsLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class SwagLabsMultipleLogin extends SeleniumUtility {
	WebDriver driver;
	SwagLabsLogin swLogin;
	SwagLabsHomepage swHome;

	@Given("User open the {string} browser and launch the swagLabs login page {string}")
	public void user_open_the_browser_and_launch_the_swag_labs_login_page(String browser, String appUrl) {
		driver = setUp(browser, appUrl);
		Reporter.log("Log : Browser open and application is Launched");
		swLogin = new SwagLabsLogin(driver);
		swHome = new SwagLabsHomepage(driver);
	}

	@When("User enters username {string} and password {string} on the login page")
	public void user_enters_username_and_password_on_the_login_page(String username, String password) {
		swLogin.enterUsernameAndPssword(username, password);
		Reporter.log("Log : Entered username and password");

	}

	@When("User click on the login button after entering username and password")
	public void user_click_on_the_login_button_after_entering_username_and_password() {
		swLogin.clickOnLoginButton();
		Reporter.log("Log : Clicked on login button");

	}

	@Then("Verify that login is successful or not with  {string} scenario")
	public void verify_that_login_is_successful_or_not_with_scenario(String scenario) {
		if (scenario.equalsIgnoreCase("positive")) {
			Assert.assertEquals(verifyCurrentPageUrl("https://www.saucedemo.com/inventory.html"),
					"https://www.saucedemo.com/inventory.html");
			swHome.clickOnBurgertMenuButton();
			swHome.logout();
			tearDown(driver);
			Reporter.log("Log : Browser closed");
		}
		if (scenario.equalsIgnoreCase("negative")) {
//			Assert.assertEquals(verifyCurrentPageUrl("https://www.saucedemo.com/inventory.html"),
//					"https://www.saucedemo.com/inventory.html");

			Assert.assertTrue(swLogin.isWarningMsgDisplayed());
			tearDown(driver);
			Reporter.log("Log : Browser closed");
		}

	}


}
