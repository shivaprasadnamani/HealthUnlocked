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
	 * WebElement to delete my account.
	 */
	@FindBy(xpath = "//button[text()='Delete my account']")
	WebElement accountDeleteButton;

	/**
	 * WebElement for Account Settings.
	 */
	@FindBy(id = "sitebar-account-button")
	WebElement accountSettings;

	/**
	 * WebElement for got it.
	 */
	@FindBy(xpath = "//button[text()='Got it']")
	WebElement gotItAlert;

	/**
	 * WebElement for logout.
	 */
	@FindBy(id = "sitebar-logout-button")
	WebElement logout;

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
	 * WebElement to delete account button.
	 */
	@FindBy(id = "settings-delete-account-button")
	WebElement settingsAccountDeleteButton;

	/**
	 * WebElement for i want to delete my account.
	 */
	@FindBy(id = "settings-show-delete-button")
	WebElement showAccountDeleteButton;

	/**
	 * WebElement for user profile.
	 */
	@FindBy(xpath = "//span[text()='shivaprasadnamani']")
	WebElement userProfile;

	/**
	 * WebElement for user profile for valid Credentials.
	 */
	@FindBy(xpath = "//span[text()='shivaprasad123']")
	WebElement userProfileForValidCredentials;

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
		accountDeleteButton.click();
	}

	/**
	 * Method to click on Account Settings.
	 */
	public void clickOnAccountSettings() {
		accountSettings.click();
	}

	/**
	 * Click on Got it.
	 */
	public void clickOnGotit() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//button[text()='Got it']"));
		gotItAlert.click();
	}

	/**
	 * Method to click on logout.
	 */
	public void clickOnLogout() {
		logout.click();
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
	}

	/**
	 * Method to click on settings Account Delete Button.
	 */
	public void clickOnSettingsAccountDeleteButton() {
		settingsAccountDeleteButton.click();
	}

	/**
	 * Method to click on show Account Delete Button.
	 */
	public void clickOnShowAccountDeleteButton() {
		showAccountDeleteButton.click();
	}

	/**
	 * Method to click on user profile.
	 */
	public void clickOnUserProfile() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//span[text()='shivaprasadnamani']"));
		userProfile.click();
	}

	/**
	 * Click on user profile for valid credentials.
	 */
	public void clickOnUserProfileforValidCredentials() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//span[text()='shivaprasad123']"));
		userProfileForValidCredentials.click();
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
