package com.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class SwagLabsHomepage extends SeleniumUtility {
	WebDriver driver;

	public SwagLabsHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product_sort_container")
	private WebElement dropDown;

	@FindBy(css = "#add-to-cart-sauce-labs-onesie")
	private WebElement onesieAddToCartBtn;

	@FindBy(xpath = "(//div[@class='inventory_item_name '])[1]")
	private WebElement productName;

	@FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
	private WebElement jacketAddToCartBtn;

	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement addToCartFirstProduct;

	@FindBy(className = "shopping_cart_link")
	private WebElement cart;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement burgerMenu;

	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

	public void sortProductPriceAscending() {
		selectElementFromDropDown("selectByVisibleText", dropDown, 0, "", "Price (low to high)");
	}

	public void sortProductPriceDescending() {
		selectElementFromDropDown("selectByVisibleText", dropDown, 0, "", "Price (high to low)");
	}

	public String getProductName() {
		return productName.getText();
	}

	public boolean verifyProductInCart(String productName) {
		try {
			return verifyUIElementDisplayed(driver.findElement(By.xpath("//*[text()='" + productName + "']")));
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void addProductToCart() {
		clickOnWebElement(driver, addToCartFirstProduct);
	}

	public void moveToCartPage() {
		clickOnWebElement(driver, cart);
	}

	public void clickOnBurgertMenuButton() {
		clickOnWebElement(driver, burgerMenu);
	}

	public void logout() {
		clickOnWebElement(driver, logoutBtn);
	}
}
