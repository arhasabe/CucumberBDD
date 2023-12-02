package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.POM.pages.SwagLabsCartPage;
import com.POM.pages.SwagLabsCheckoutPage;
import com.POM.pages.SwagLabsHomepage;
import com.POM.pages.SwagLabsLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtility;
import utilities.SeleniumUtility;

public class SwagLabsProductBuy extends SeleniumUtility {
	WebDriver driver;
	SwagLabsLogin swLogin;
	SwagLabsHomepage swHome;
	SwagLabsCartPage swCart;
	SwagLabsCheckoutPage swCheckout;
	String xlPath = "./src/main/resources/SwagLabsCredentials.xlsx";
	String productName;

	@Given("User opens browser and SwagLabs application using data provided on {string} sheet")
	public void user_opens_browser_and_swag_labs_application_using_data_provided_on_sheet(String sheet)
			throws IOException {
		driver = setUp(ExcelUtility.getCellStringData(xlPath, sheet, 1, 0),
				ExcelUtility.getCellStringData(xlPath, sheet, 1, 1));
		swLogin = new SwagLabsLogin(driver);
		swHome = new SwagLabsHomepage(driver);
		swCart = new SwagLabsCartPage(driver);
		swCheckout = new SwagLabsCheckoutPage(driver);
	}

	@When("User enter username and password from {string} sheet")
	public void user_enter_username_and_password_from_sheet(String sheet) throws IOException {
		swLogin.enterUsernameAndPssword(ExcelUtility.getCellStringData(xlPath, sheet, 1, 2),
				ExcelUtility.getCellStringData(xlPath, sheet, 1, 3));
	}

	@When("User click on the login button after enter the data from sheet")
	public void user_click_on_the_login_button_after_enter_the_data_from_sheet() {
		swLogin.clickOnLoginButton();
	}

	@When("user sort the products in ascending order of price")
	public void user_sort_the_products_in_ascending_order_of_price() {
		swHome.sortProductPriceAscending();
	}

	@When("User add the lowest price product to the cart")
	public void user_add_the_lowest_price_product_to_the_cart() {
		productName = swHome.getProductName();
		swHome.addProductToCart();
	}

	@When("User navigate to the cart page")
	public void user_navigate_to_the_cart_page() {
		swHome.moveToCartPage();
	}

	@Then("Lowest price product should be added in the cart")
	public void lowest_price_product_should_be_added_in_the_cart() {
		Assert.assertTrue(swHome.verifyProductInCart(productName));
	}

	@When("User click on checkout button")
	public void user_click_on_checkout_button() {
		swCart.clickOnCheckoutButton();
	}

	@When("User enters firstname, lastname and zip code provided on {string} sheet")
	public void user_enters_firstname_lastname_and_zip_code_provided_on_sheet(String sheet) throws IOException {
		swCheckout.enterFirstName(ExcelUtility.getCellStringData(xlPath, sheet, 1, 4));
		swCheckout.enterLastName(ExcelUtility.getCellStringData(xlPath, sheet, 1, 5));
		swCheckout.enterPostalCode(ExcelUtility.getCellStringData(xlPath, sheet, 1, 6));
		swCheckout.clickOnContinueButton();
	}

	@Then("Verify the total amount is addition of item cost and tax amount")
	public void verify_the_total_amount_is_addition_of_item_cost_and_tax_amount() {
		double[] amountArr = swCheckout.getSubTotalTaxAndTotalAmountValue();
		Assert.assertEquals(amountArr[2], (amountArr[0] + amountArr[1]));
	}

	@When("User click on the finish button")
	public void user_click_on_the_finish_button() {
		swCheckout.clickOnFinishButton();
	}

	@Then("Order confirmation message should be displayed")
	public void order_confirmation_message_should_be_displayed() {
		Assert.assertTrue(swCheckout.verifyPonyImageIsDisplayed());
		tearDown(driver);
	}

	@When("user sort the products in descending order of price")
	public void user_sort_the_products_in_descending_order_of_price() {
		swHome.sortProductPriceDescending();
	}

	@When("User add the highest price product to the cart")
	public void user_add_the_highest_price_product_to_the_cart() {
		productName = swHome.getProductName();
		swHome.addProductToCart();
	}

	@Then("Highest price product should be added in the cart")
	public void highest_price_product_should_be_added_in_the_cart() {
		Assert.assertTrue(swHome.verifyProductInCart(productName));
	}
}