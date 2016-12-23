package com.hu.webdriver.pages.newsfeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

/**
 *
 * @author SHIVA
 *
 */
public class NewsFeedPage extends BasePage {
	/**
	 * By element to delete my account.
	 */
	By accountDeleteButton = By.xpath("//button[text()='Delete my account']");

	/**
	 * By element for Account Settings.
	 */
	By accountSettings = By.id("sitebar-account-button");

	/**
	 * By element for got it.
	 */
	By gotItAlert = By.xpath("//button[text()='Got it']");

	/**
	 * By element for logout.
	 */
	By logout = By.id("sitebar-logout-button");

	/**
	 * WebElement for News Feed.
	 */
	@FindBy(linkText = "News Feed")
	WebElement newsfeed;

	/**
	 * WebElemenet for News feed page.
	 */
	@FindBy(xpath = "//a[text()='News Feed']")
	WebElement newsfeedPage;

	/**
	 * WebElement for Profile name.
	 */
	@FindBy(css = ".userHomeNav-username")
	WebElement profileName;

	/**
	 * By element to delete account button.
	 */
	By settingsAccountDeleteButton = By.id("settings-delete-account-button");

	/**
	 * By element for i want to delete my account.
	 */
	By showAccountDeleteButton = By.id("settings-show-delete-button");

	/**
	 * By element for user profile.
	 */
	By userProfile = By.xpath("//span[text()='shivaprasadnamani']");

	/**
	 * By element for user profile for valid Credentials.
	 */
	By userProfileForValidCredentials = By.xpath("//span[text()='shivaprasad123']");

	/**
	 * Constructor
	 *
	 * @param driver
	 */
	public NewsFeedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to click on Account Delete Button.
	 */
	public void clickOnAccountDeleteButton() {
		findClickableElement(By.xpath("//button[text()='Delete my account']")).click();
	}

	/**
	 * Method to click on Account Settings.
	 */
	public void clickOnAccountSettings() {
		findClickableElement(By.id("sitebar-account-button")).click();
	}

	/**
	 * Click on Got it.
	 */
	public void clickOnGotit() {
		findClickableElement(By.xpath("//button[text()='Got it']")).click();
	}

	/**
	 * Method to click on logout.
	 */
	public void clickOnLogout() {
		findClickableElement(By.id("sitebar-logout-button")).click();
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
	}

	/**
	 * Method to click on settings Account Delete Button.
	 */
	public void clickOnSettingsAccountDeleteButton() {
		findClickableElement(By.id("settings-delete-account-button")).click();
	}

	/**
	 * Method to click on show Account Delete Button.
	 */
	public void clickOnShowAccountDeleteButton() {
		findClickableElement(By.id("settings-show-delete-button")).click();
	}

	/**
	 * Method to click on user profile.
	 */
	public void clickOnUserProfile() {
		findClickableElement(By.xpath("//span[text()='shivaprasadnamani']")).click();
	}

	/**
	 * Click on user profile for valid credentials.
	 */
	public void clickOnUserProfileforValidCredentials() {
		findClickableElement(By.xpath("//span[text()='shivaprasad123']")).click();
	}

	/**
	 * Method to get User name.
	 *
	 * @return String
	 */
	public String getUserName() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.cssSelector(".userHomeNav-username"));
		return profileName.getText();
	}

	/**
	 * Method to verify news feed alert header.
	 *
	 * @param userName
	 * @return boolean
	 */
	public boolean isNewsfeedAlertHeader(String userName) {
		final String xpathExpression = "//h1[text()='Welcome, " + userName + "!']";
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath(xpathExpression));
	}

	/**
	 * Method to verify the news feed.
	 *
	 * @return boolean.
	 */
	public boolean isNewsfeedDisplay() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.linkText("News Feed"));
		return newsfeed.isDisplayed();
	}

	/**
	 * Method to navigate to News feed page.
	 */
	public void navigateToNewsfeedPage() {
		driver.navigate().to("https://healthunlocked.com");
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='News Feed']"));
	}
}
