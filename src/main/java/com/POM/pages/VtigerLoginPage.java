package com.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class VtigerLoginPage extends SeleniumUtility {

	public VtigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement signInBtn;

	public void enterUsernameAndPassword(String username, String pwd) {
		typeInput(driver, usernameField, username);
		typeInput(driver, passwordField, pwd);
	}

	public void clickOnSignInButton() {
		clickOnWebElement(driver, signInBtn);
	}
}
