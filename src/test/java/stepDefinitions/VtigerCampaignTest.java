package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.POM.pages.VtigerCampaignsPage;
import com.POM.pages.VtigerHomePage;
import com.POM.pages.VtigerLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class VtigerCampaignTest extends SeleniumUtility {
	WebDriver driver;
	VtigerLoginPage vtLogin;
	VtigerHomePage vtHome;
	VtigerCampaignsPage vtCampaign;
	String propertyFilePath = "./src/main/resources/VtigerCredentials.properties";

	@Given("User is on the Vtiger login page")
	public void user_is_on_the_vtiger_login_page() throws IOException {
		System.out.println("Background Started");
		driver = setUp(getPropertiesFileData(propertyFilePath, "browser"),
				getPropertiesFileData(propertyFilePath, "appUrl"));
		vtLogin = new VtigerLoginPage(driver);
		vtHome = new VtigerHomePage(driver);
		vtCampaign = new VtigerCampaignsPage(driver);
	}

	@Given("User login with valid credentials")
	public void user_login_with_valid_credentials() throws IOException {
		vtLogin.enterUsernameAndPassword(getPropertiesFileData(propertyFilePath, "username"),
				getPropertiesFileData(propertyFilePath, "password"));
		vtLogin.clickOnSignInButton();
	}

	@Given("User navigates to campaign page")
	public void user_navigates_to_campaign_page() {
		vtHome.clickOnAppNavigator();
		vtHome.hoverOnMarketingOption();
		vtHome.clickOnCampaignsOption();
	}

	@When("Click on Add campaign button")
	public void click_on_add_campaign_button() {
		System.out.println("Scenario Outline Started");
		vtCampaign.clickOnAddCampaignBtn();
	}

	@When("User enters campaign name {string} and expected close date {string} and click on save button")
	public void user_enters_campaign_name_and_expected_close_date_and_click_on_save_button(String campaignName,
			String expectedCloseDate) {
		vtCampaign.createCampaign(campaignName, expectedCloseDate);
	}

	@When("User click on campaign header link")
	public void user_click_on_campaign_header_link() {
		vtCampaign.clickOnHeaderLink();
	}

	@Then("Verify the created camapign with {string}")
	public void verify_the_created_camapign_with(String campaignName) {
		vtCampaign.verifyCreatedCampaign();
		vtHome.clickOnProfileButton();
		vtHome.clickOnSignOutButton();
	}

	@When("User click on select all campaign checkbox")
	public void user_click_on_select_all_campaign_checkbox() {
		System.out.println("Delete Scenrio Started");
		vtCampaign.selectAllCampaginsCheckbox();
	}

	@When("User click on delete button")
	public void user_click_on_delete_button() {
		vtCampaign.deletedButton();
	}

	@When("User click on confirm button appeared on the pop up")
	public void user_click_on_confirm_button_appeared_on_the_pop_up() {
		vtCampaign.clickOnConfirmYesBtn();
	}

	@Then("Verify that all the created campaigns are deleted")
	public void verify_that_all_the_created_campaigns_are_deleted() {
		Assert.assertTrue(vtCampaign.verifyDeletedCampaign());
//		Assert.assertTrue(false);
		vtHome.clickOnProfileButton();
		vtHome.clickOnSignOutButton();
	}

//	to make this hook scenario specific then use the tag specified with scenario
	@Before(value = "@Rerun")
	public void createCampaign() throws IOException {
		System.out.println("Hook Started");
		user_is_on_the_vtiger_login_page();
		user_login_with_valid_credentials();
		user_navigates_to_campaign_page();

		if (vtCampaign.verifyDeletedCampaign()) {
			click_on_add_campaign_button();
			user_enters_campaign_name_and_expected_close_date_and_click_on_save_button("Java Learning", "11-31-2023");
		}
		vtHome.clickOnProfileButton();
		vtHome.clickOnSignOutButton();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			driver.close();
			Reporter.log("Log : Browser closed");
		}
	}
}
