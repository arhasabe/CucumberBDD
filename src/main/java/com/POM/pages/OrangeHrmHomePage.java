package com.POM.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SeleniumUtility;

public class OrangeHrmHomePage extends SeleniumUtility {

	@FindBy(css = "img[alt='client brand banner']")
	private WebElement companyLogo;

	@FindBy(css = "i.oxd-userdropdown-icon")
	private WebElement profileDropdown;

	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

	public boolean verifyUserIsOnHomePage() {
		try {
			return verifyUIElementDisplayed(companyLogo);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void logout() {
		clickOnWebElement(driver, profileDropdown);
		clickOnWebElement(driver, logoutBtn);

	}
}
