package com.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class SwagLabsCartPage extends SeleniumUtility {

	WebDriver driver;

	public SwagLabsCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;

	public void clickOnCheckoutButton() {
		clickOnWebElement(driver, checkoutBtn);
	}
}
