package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.POM.pages.SwagLabsHomepage;
import com.POM.pages.SwagLabsLogin;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class SwagLabsLoginTest extends SeleniumUtility {
	WebDriver driver;
	SwagLabsLogin swLogin;
	SwagLabsHomepage swHome;
	String username, pwd;

	@Given("user launches the chrome browser and opens the Swaglabs application")
	public void user_launches_the_chrome_browser_and_opens_the_swaglabs_application() {
		driver = setUp("chrome", "https://www.saucedemo.com/");
		swLogin = new SwagLabsLogin(driver);
		swHome = new SwagLabsHomepage(driver);
	}

	@When("user enters the username and password as")
	public void user_enters_the_username_and_password_as(DataTable dataTable) {
//		 here we are importing the data as list
		List<List<String>> userData = dataTable.asLists(String.class);
		List<String> firstUserData = userData.get(0);
		username = firstUserData.get(0);
		pwd = firstUserData.get(1);
		System.out.println(firstUserData.get(0) + "\t" + firstUserData.get(1));

		List<String> secondUserData = userData.get(1);
		System.out.println(secondUserData.get(0) + "\t" + secondUserData.get(1));
		swLogin.enterUsernameAndPssword(username, pwd);
	}

	@When("user click on the sign in button")
	public void user_click_on_the_sign_in_button() {
		swLogin.clickOnLoginButton();
	}

	@Then("verify the user is logged in")
	public void verify_the_user_is_logged_in() {
		swHome.clickOnBurgertMenuButton();
		swHome.logout();
		tearDown(driver);
	}
}
