package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SeleniumUtility {
//	here we keep the commonly used method related to Selenium actions
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions act;

	public static WebDriver setUp(String browser, String appUrl) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}

		if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		}
		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
		}

		if (browser.equalsIgnoreCase("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		Reporter.log("Launched Browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(appUrl);

		return driver;
	}

	public static void typeInput(WebDriver driver, WebElement element, String input) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(input);
		Reporter.log("Text Entered");
	}

	public static void clickOnWebElement(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Reporter.log("Clicked");
	}

	public static void waitForTitleContains(WebDriver driver, String title) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
		Reporter.log("Checked if title contains");
	}

	public static void waitForVisibilityOf(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Checked visibility of WebElement");
	}

//	-----------------------  Mouse Operations  --------------------------------
	public static void mouseClick(WebDriver driver, WebElement element) {
		act = new Actions(driver);
		act.click(element).perform();
	}

	public static void mouseDoubleClick(WebElement element) {
		act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}

	public static void mouseRightClick(WebElement element) {
		act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public static void mouseHover(String hoverOpe, WebElement element, int x, int y) {
		act = new Actions(driver);
		if (hoverOpe.equalsIgnoreCase("Offsets")) {
			act.moveByOffset(x, y).perform();
		}
		if (hoverOpe.equalsIgnoreCase("targetElement")) {
			act.moveToElement(element).perform();
		}
		if (hoverOpe.equalsIgnoreCase("targetElementWithOffSets")) {
			act.moveToElement(element, x, y).build().perform();
		}
	}

	public static void mouseclickHoldRelease(String releaseOpe, WebElement sourceElement, WebElement targetElement,
			Integer x, Integer y) {
		act = new Actions(driver);
		if (releaseOpe.equalsIgnoreCase("sourceAndTarget")) {
			act.clickAndHold(sourceElement).build().perform();
			act.release(targetElement).build().perform();
		}
		if (releaseOpe.equalsIgnoreCase("sourceAndOffSet")) {
			act.clickAndHold(sourceElement).build().perform();
			act.moveByOffset(x, y).perform();
			act.release().perform();
		}
	}

	public static void dragAndDrop(String dragDropOpe, WebElement sourceElement, WebElement targetElement, Integer x,
			Integer y) {
		act = new Actions(driver);
		if (dragDropOpe.equalsIgnoreCase("sourceAndTarget")) {
			act.dragAndDrop(sourceElement, targetElement).build().perform();
		}
		if (dragDropOpe.equalsIgnoreCase("sourceAndOffSet")) {
			act.dragAndDropBy(sourceElement, x, y).build().perform();
		}
	}

//	-----------------------  Mouse Operations ends --------------------------------
	/**
	 * We can use this function to read and get the data from properties file
	 * 
	 * @param filePath
	 * @param key
	 * @return Value against the provided key and it's type is String
	 * @throws IOException
	 */
	public static String getPropertiesFileData(String filePath, String key) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static boolean verifyUIElementDisplayed(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}

	public static String verifyCurrentPageTitle(String expectedTitle) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		return driver.getTitle();
	}

	public static String verifyCurrentPageUrl(String expectedUrl) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
		return driver.getCurrentUrl();
	}

	public static void tearDown(WebDriver driver) {
		driver.close();
		Reporter.log("Browser Closed");
	}

	public static void selectElementFromDropDown(String selectOpe, WebElement dropdownElement, int index, String value,
			String visibleText) {
		Select s = new Select(dropdownElement);
		if (selectOpe.equalsIgnoreCase("selectByIndex"))
			s.selectByIndex(index);
		if (selectOpe.equalsIgnoreCase("selectByValue"))
			s.selectByValue(value);
		if (selectOpe.equalsIgnoreCase("selectByVisibleText"))
			s.selectByVisibleText(visibleText);
	}
}