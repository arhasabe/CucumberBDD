package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.pages.VtigerCampaignsPage;
import com.POM.pages.VtigerHomePage;
import com.POM.pages.VtigerLoginPage;

import utilities.SeleniumUtility;

public class VTigerCompaignTestCases extends SeleniumUtility {
	WebDriver driver;
	VtigerLoginPage vtLogin;
	VtigerHomePage vtHome;
	VtigerCampaignsPage vtCampaign;
	String propertyFileLocation = "./src/main/resources/VtigerCredentials.properties";

	@BeforeMethod
	public void launchBrowserAndApplication() throws IOException {
		driver = setUp(getPropertiesFileData(propertyFileLocation, "browser"),
				getPropertiesFileData(propertyFileLocation, "appUrl"));
		vtLogin = new VtigerLoginPage(driver);
		vtHome = new VtigerHomePage(driver);
		vtCampaign = new VtigerCampaignsPage(driver);
		vtLogin.enterUsernameAndPassword(getPropertiesFileData(propertyFileLocation, "username"),
				getPropertiesFileData(propertyFileLocation, "password"));
		vtLogin.clickOnSignInButton();
	}

	@Test(priority = 1)
	public void createCompaign() {
		vtHome.clickOnAppNavigator();
		vtHome.hoverOnMarketingOption();
		vtHome.clickOnCampaignsOption();
		vtCampaign.createCampaign("Akash", "11-25-2023");
	}

	@Test(priority = 2)
	public void verifyCreatedCampaign() {
		vtHome.clickOnAppNavigator();
		vtHome.hoverOnMarketingOption();
		vtHome.clickOnCampaignsOption();
		Assert.assertTrue(vtCampaign.verifyCreatedCampaign());
	}

	@Test(priority = 3)
	public void deletedCampaignAndVerify() throws InterruptedException {
		vtHome.clickOnAppNavigator();
		vtHome.hoverOnMarketingOption();
		vtHome.clickOnCampaignsOption();
		vtCampaign.deleteCreatedCampaign();
		Thread.sleep(5000);
		Assert.assertTrue(vtCampaign.verifyDeletedCampaign());
	}

	@AfterMethod
	public void logoutAndTearDown() {
//		vtHome.clickOnCompanyLogo();
		vtHome.clickOnProfileButton();
		vtHome.clickOnSignOutButton();
		tearDown(driver);
	}
}
