package com.POM.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class SwagLabsLogin extends SeleniumUtility {
	WebDriver driver;

	public SwagLabsLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='user-name']")
	private WebElement usernameField;

	@FindBy(xpath = "//form//div[2]//input")
	private WebElement passwordField;

	@FindBy(css = "#login-button")
	private WebElement loginBtn;

	@FindBy(css = ".error-message-container.error")
	private WebElement warningMsg;

	public void enterUsernameAndPssword(String username, String pwd) {
		typeInput(driver, usernameField, username);
		typeInput(driver, passwordField, pwd);
	}

	public void clickOnLoginButton() {
		clickOnWebElement(driver, loginBtn);
	}

	public boolean isWarningMsgDisplayed() {
		try {
			return verifyUIElementDisplayed(warningMsg);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
