package com.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class VtigerHomePage extends SeleniumUtility {
	public VtigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='row app-navigator'])[1]")
	private WebElement appNavigatorBtn;

	@FindBy(css = "div[id='MARKETING_modules_dropdownMenu']")
	private WebElement marketingOption;

	@FindBy(css = "a[title='Campaigns']")
	private WebElement campaignsOption;

	@FindBy(css = ".company-logo")
	private WebElement companyLogo;

	@FindBy(xpath = "(//a[@href ='#'])[3]")
	private WebElement profileBtn;

	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT")
	private WebElement signOutBtn;

	public void clickOnAppNavigator() {
		clickOnWebElement(driver, appNavigatorBtn);
	}

	public void hoverOnMarketingOption() {
		mouseHover("targetElement", marketingOption, 0, 0);
	}

	public void clickOnCampaignsOption() {
		clickOnWebElement(driver, campaignsOption);
	}

	public void clickOnCompanyLogo() {
		clickOnWebElement(driver, companyLogo);
	}

	public void clickOnProfileButton() {
		clickOnWebElement(driver, profileBtn);
	}

	public void clickOnSignOutButton() {
		clickOnWebElement(driver, signOutBtn);
		tearDown(driver);
	}
}
