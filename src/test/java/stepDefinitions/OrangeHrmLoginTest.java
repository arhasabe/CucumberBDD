package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.POM.pages.OrangeHrmHomePage;
import com.POM.pages.OrangeHrmLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class OrangeHrmLoginTest extends SeleniumUtility {

	WebDriver driver;
	OrangeHrmLoginPage orgLogin;
	OrangeHrmHomePage orgHome;
	String username, pwd;

	@Given("user opens the chrome browser and OrangeHrm application is loaded")
	public void user_opens_the_chrome_browser_and_orange_hrm_application_is_loaded() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		orgLogin = new OrangeHrmLoginPage(driver);
		orgHome = PageFactory.initElements(driver, OrangeHrmHomePage.class);
	}

	@Given("user has username and password")
	public void user_has_username_and_password() {
		username = "Admin";
		pwd = "admin123";
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		orgLogin.enterUsername(username);
		orgLogin.enterPassword(pwd);
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		orgLogin.clickOnLoginButton();
	}

	@Then("user should be logged in successfully and navigated to home page")
	public void user_should_be_logged_in_successfully_and_navigated_to_home_page() {
		Assert.assertTrue(orgHome.verifyUserIsOnHomePage());
		orgHome.logout();
		tearDown(driver);
	}
}
