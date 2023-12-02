package com.guru.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class Guru99NewCustomerPage extends SeleniumUtility {

	public Guru99NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	private WebElement customerNameField;

	@FindBy(xpath = "(//input[@name='rad1'])[1]")
	private WebElement maleRadionBtn;

	@FindBy(xpath = "(//input[@name='rad1'])[2]")
	private WebElement femaleRadionBtn;

	@FindBy(id = "dob")
	private WebElement dobField;

	@FindBy(css = "textarea[name='addr']")
	private WebElement addressField;

	@FindBy(css = "input[name='city']")
	private WebElement cityField;

	@FindBy(css = "input[name='state']")
	private WebElement stateField;

	@FindBy(name = "pinno")
	private WebElement pinCodeField;

	@FindBy(css = "input[name='telephoneno']")
	private WebElement telephoneNumberField;

	@FindBy(name = "emailid")
	private WebElement emailIdField;

	@FindBy(css = "input[value='Submit']")
	private WebElement submitBtn;

	public void enterCustomerName(String name) {
		typeInput(driver, customerNameField, name);
	}

	public void clickOnMaleRadioBtn() {
		clickOnWebElement(driver, maleRadionBtn);
	}

	public void clickOnFemaleRadioBtn() {
		clickOnWebElement(driver, femaleRadionBtn);
	}

	public void enterDateOfBirth(String dob) {
		typeInput(driver, dobField, dob);
	}

	public void enterAddress(String address) {
		typeInput(driver, addressField, address);
	}

	public void enterCityName(String cityname) {
		typeInput(driver, cityField, cityname);
	}

	public void enterStateName(String statename) {
		typeInput(driver, stateField, statename);
	}

	public void enterPinCode(String pincode) {
		typeInput(driver, pinCodeField, pincode);
	}

	public void enterEmailId(String emailid) {
		typeInput(driver, emailIdField, emailid);
	}

	public void enterTelephoneNumber(String number) {
		typeInput(driver, telephoneNumberField, number);
	}

	public void clickOnSubmitBtn() {
		clickOnWebElement(driver, submitBtn);
	}
}
