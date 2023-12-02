package com.guru.Pom;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class Guru99LoginPage extends SeleniumUtility {

	public Guru99LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='uid']")
	private WebElement usernameField;

	@FindBy(css = "input[name='password']")
	private WebElement pwdField;

	@FindBy(css = "input[value='LOGIN']")
	private WebElement loginBtn;

	@FindBy(css = "input[value='RESET']")
	private WebElement resetBtn;

	public boolean verifyUsernameFieldIsDisplayed() {
		try {
			return verifyUIElementDisplayed(usernameField);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean verifyPasswordFieldIsDisplayed() {
		try {
			return verifyUIElementDisplayed(pwdField);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean verifyLoginBtnIsDisplayed() {
		try {
			return verifyUIElementDisplayed(loginBtn);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean verifyResetBtnIsDisplayed() {
		try {
			return verifyUIElementDisplayed(resetBtn);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void enterUsername(String username) {
		typeInput(driver, usernameField, username);
	}

	public void enterPassword(String pwd) {
		typeInput(driver, pwdField, pwd);
	}

	public void clickOnLoginBtn() {
		clickOnWebElement(driver, loginBtn);
	}
}
