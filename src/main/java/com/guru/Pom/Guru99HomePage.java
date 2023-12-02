package com.guru.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class Guru99HomePage extends SeleniumUtility {

	public Guru99HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".menusubnav>li:nth-of-type(2)>a")
	private WebElement newCustomerBtn;

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	private WebElement editCustomerBtn;

	@FindBy(xpath = "//a[text()='Delete Customer']")
	private WebElement deleteCustomerBtn;

	@FindBy(css = "//a[text()='New Account']")
	private WebElement newAccountBtn;

	@FindBy(linkText = "Log out")
	private WebElement logoutBtn;

	public void clickOnLogoutBtn() {
		mouseHover("targetElement", logoutBtn, 0, 0);
		clickOnWebElement(driver, logoutBtn);
		driver.switchTo().alert().accept();
	}

	public void clickOnNewCustomerBtn() {
		clickOnWebElement(driver, newCustomerBtn);
	}

	public void clickOnEditCustomerBtn() {
		clickOnWebElement(driver, editCustomerBtn);
	}

	public void clickOnDeleteCustomerBtn() {
		clickOnWebElement(driver, deleteCustomerBtn);
	}

	public void clickOnNewAccountBtn() {
		clickOnWebElement(driver, newAccountBtn);
	}
}
