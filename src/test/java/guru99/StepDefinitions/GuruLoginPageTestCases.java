package guru99.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.guru.Pom.Guru99HomePage;
import com.guru.Pom.Guru99LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class GuruLoginPageTestCases extends SeleniumUtility {
//	WebDriver driver = SeleniumUtility.driver;
	Guru99LoginPage guruLogin = new Guru99LoginPage(driver);
//	String propertyFilePath = "./src/main/resources/Guru99.properties";
	Guru99HomePage guruHome = new Guru99HomePage(driver);;

	public static WebDriver driver;
	String propertyFilePath = "./src/main/resources/Guru99.properties";

	@Before
	public void launchBrowserAndLoadApplication() throws IOException {
		driver = setUp(getPropertiesFileData(propertyFilePath, "browser"),
				getPropertiesFileData(propertyFilePath, "appUrl"));
	}

	@Given("User is on the login page of the Guru99 application")
	public void user_is_on_the_login_page_of_the_guru99_application() {
//		Assert.assertEquals(verifyCurrentPageUrl("https://demo.guru99.com/V1/index.php"),
//				"https://demo.guru99.com/V1/index.php");
	}

	@Then("Verify the elements present on the login page")
	public void verify_the_elements_present_on_the_login_page() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(guruLogin.verifyUsernameFieldIsDisplayed());
		softAssert.assertTrue(guruLogin.verifyPasswordFieldIsDisplayed());
		softAssert.assertTrue(guruLogin.verifyLoginBtnIsDisplayed());
		softAssert.assertTrue(guruLogin.verifyResetBtnIsDisplayed());
		softAssert.assertAll();
		tearDown(driver);
	}

	@When("User enters the valid credentials for username and password")
	public void user_enters_the_valid_credentials_for_username_and_password() throws IOException {
		guruLogin.enterUsername(getPropertiesFileData(propertyFilePath, "username"));
		guruLogin.enterPassword(getPropertiesFileData(propertyFilePath, "password"));
	}

	@When("User click on the login button after entering the login credentials")
	public void user_click_on_the_login_button_after_entering_the_login_credentials() {
		guruLogin.clickOnLoginBtn();
	}

	@Then("Verify that user is successfully logged in and redirected to the homepage")
	public void verify_that_user_is_successfully_logged_in_and_redirected_to_the_homepage() {
//		Assert.assertEquals(verifyCurrentPageTitle("GTPL Bank Manager HomePage"), "GTPL Bank Manager HomePage");
//		guruHome.clickOnLogoutBtn();
		tearDown(driver);
	}

	@After
	public void tearDown() {
		tearDown(driver);
	}
}
