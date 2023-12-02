package com.POM.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class SwagLabsCheckoutPage extends SeleniumUtility {

	WebDriver driver;

	public SwagLabsCheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	@FindBy(id = "back-to-products")
	private WebElement homeBtn;

	@FindBy(css = ".summary_subtotal_label")
	private WebElement subTotalLabel;

	@FindBy(css = ".summary_tax_label")
	private WebElement taxAmountLabel;

	@FindBy(css = ".summary_total_label")
	private WebElement totalLabel;

	@FindBy(xpath = "//img[@alt='Pony Express']")
	private WebElement checkoutConfirmationImage;

	public void enterFirstName(String fName) {
		typeInput(driver, firstName, fName);
	}

	public void enterLastName(String lName) {
		typeInput(driver, lastName, lName);
	}

	public void enterPostalCode(String pinCode) {
		typeInput(driver, postalCode, pinCode);
	}

	public void clickOnContinueButton() {
		clickOnWebElement(driver, continueBtn);
	}

	public void clickOnFinishButton() {
		clickOnWebElement(driver, finishBtn);
	}

	public void clickOnHomeButton() {
		clickOnWebElement(driver, homeBtn);
	}

	public double[] getSubTotalTaxAndTotalAmountValue() {
		String[] subTotalArr = subTotalLabel.getText().split("\\$");
		String[] taxAmountArr = taxAmountLabel.getText().split("\\$");
		String[] totalAmountArr = totalLabel.getText().split("\\$");

		double[] amountArr = { Double.parseDouble(subTotalArr[1]), Double.parseDouble(taxAmountArr[1]),
				Double.parseDouble(totalAmountArr[1]) };
		return amountArr;
	}

	public boolean verifyPonyImageIsDisplayed() {
		try {
			return verifyUIElementDisplayed(checkoutConfirmationImage);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
