package guru99.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.guru.Pom.Guru99HomePage;
import com.guru.Pom.Guru99NewCustomerPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class Guru99AddNewCustomer extends SeleniumUtility {
//	WebDriver driver = SeleniumUtility.driver;
	Guru99HomePage guruHome = new Guru99HomePage(driver);;
	Guru99NewCustomerPage guruCust = new Guru99NewCustomerPage(driver);

	public static WebDriver driver;
	String propertyFilePath = "./src/main/resources/Guru99.properties";

	@Before
	public void launchBrowserAndLoadApplication() throws IOException {
		driver = setUp(getPropertiesFileData(propertyFilePath, "browser"),
				getPropertiesFileData(propertyFilePath, "appUrl"));
	}
	
	@Given("User is on the homepage and clicks on new customer menu button")
	public void user_is_on_the_homepage_and_clicks_on_new_customer_menu_button() {
		guruHome.clickOnNewCustomerBtn();
	}

	@When("User enters the new customer details")
	public void user_enters_the_new_customer_details() {
		guruCust.enterCustomerName("Abc");
		guruCust.clickOnFemaleRadioBtn();
		guruCust.enterDateOfBirth("26091983");
		guruCust.enterAddress("Abc Street");
		guruCust.enterCityName("Bulwayo");
		guruCust.enterStateName("Harare");
		guruCust.enterPinCode("195748");
		guruCust.enterTelephoneNumber("1478524036");
		guruCust.enterEmailId("xyz@gmail.com");
	}

	@When("User submit the details")
	public void user_submit_the_details() {
		guruCust.clickOnSubmitBtn();
	}

	@Then("Verify that the new customer is added")
	public void verify_that_the_new_customer_is_added() {
		Assert.assertEquals(verifyCurrentPageUrl("https://demo.guru99.com/V1/html/insrtCustomer.php"),
				"https://demo.guru99.com/V1/html/insrtCustomer.php");
	}
}
