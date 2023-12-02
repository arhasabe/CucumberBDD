package com.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class OrangeHrmLoginPage extends SeleniumUtility {

	public OrangeHrmLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='username']")
	private WebElement usernameField;

	@FindBy(css = "input[name='password']")
	private WebElement passwordField;

	@FindBy(css = "button.orangehrm-login-button")
	private WebElement loginBtn;

	public void enterUsername(String username) {
		typeInput(driver, usernameField, username);
	}

	public void enterPassword(String pwd) {
		typeInput(driver, passwordField, pwd);
	}

	public void clickOnLoginButton() {
		clickOnWebElement(driver, loginBtn);
	}
}
