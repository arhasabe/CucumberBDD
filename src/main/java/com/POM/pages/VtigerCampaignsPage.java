package com.POM.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class VtigerCampaignsPage extends SeleniumUtility {

	public VtigerCampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#Campaigns_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addCampaignsBtn;

	@FindBy(id = "Campaigns_editView_fieldName_campaignname")
	private WebElement campaignNameField;

	@FindBy(id = "s2id_autogen1")
	private WebElement assignedToDropdown;

	@FindBy(xpath = "(//li[contains(@class,'select2-result-selectable')])[1]")
	private WebElement dropdownOption;

	@FindBy(id = "Campaigns_editView_fieldName_closingdate")
	private WebElement expectedCloseDateField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//h4[text()=' Campaigns ']")
	private WebElement campaignHeader;

//	@FindAll() ==> for OR operation
//	@FindBys() ==> for AND Operation

	@FindAll({ @FindBy(xpath = "//a[text()='JavaLearning']"), @FindBy(xpath = "//a[text()='SeleniumLearning']") })
	private WebElement newlyCreatedCampaign;

//	@FindBy(xpath = "//a[text()='JavaLearning']")
//	private WebElement newlyCreatedCampaign;

	@FindBy(xpath = "//a[text()='Akash']//ancestor::tr/td[1]//input")
	private WebElement newlyCreatedCampaignCheckbox;

	@FindBy(css = ".listViewEntriesMainCheckBox")
	private WebElement selectAllCheckbox;

	@FindBy(css = "button[title='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesBtn;

	@FindBy(css = ".emptyRecordsContent")
	private WebElement noCampaignsMsg;

	public void clickOnAddCampaignBtn() {
		clickOnWebElement(driver, addCampaignsBtn);

	}

	public void createCampaign(String name, String expectedDate) {
		typeInput(driver, campaignNameField, name);
		typeInput(driver, expectedCloseDateField, expectedDate);
		clickOnWebElement(driver, saveBtn);
	}

	public boolean verifyCreatedCampaign() {
		try {
			return verifyUIElementDisplayed(newlyCreatedCampaign);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void clickOnHeaderLink() {
		clickOnWebElement(driver, campaignHeader);
	}

	public void selectAllCampaginsCheckbox() {
		clickOnWebElement(driver, selectAllCheckbox);
	}

	public void deletedButton() {
		clickOnWebElement(driver, deleteBtn);
	}

	public void clickOnConfirmYesBtn() {
		clickOnWebElement(driver, yesBtn);
	}

	public void deleteCreatedCampaign() {
//		clickOnWebElement(driver, newlyCreatedCampaign);
		clickOnWebElement(driver, newlyCreatedCampaignCheckbox);
		clickOnWebElement(driver, deleteBtn);
		clickOnWebElement(driver, yesBtn);
	}

	public boolean verifyDeletedCampaign() {
		try {
			return verifyUIElementDisplayed(noCampaignsMsg);
		} catch (TimeoutException e) {
			return false;
		}
	}
	
}
