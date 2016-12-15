package com.hu.webdriver.pages.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hu.webdriver.pages.BasePage;

/**
 * @author SHIVA
 */
public class ForgotPassword extends BasePage {
	/**
	 * WebElement for alert message.
	 */
	@FindBy(xpath = "//*[contains(text(),'shortly receive an email')]")
	WebElement alertmessage;

	/**
	 * WebElement HealthUnlocked.
	 */
	@FindBy(xpath = "//a[text()='HealthUnlocked']")
	WebElement healthUnlocked;

	/**
	 * WebElement for Request Email.
	 */
	@FindBy(id = "requestReset-email-button")
	WebElement requestemail;

	/**
	 * WebElement for reset page header.
	 */
	@FindBy(xpath = "//h1[text()='Forgot your password?']")
	WebElement resetPageHeader;

	/**
	 * WebElement for Submit Button.
	 */
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement submitButton;

	/**
	 * Instance variable for WebDriver.
	 */
	/**
	 * Constructor
	 *
	 * @param driver
	 */
	public ForgotPassword(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method for click on Submit Button.
	 */
	public void clickOnSubmitButton() {
		submitButton.click();
	}

	/**
	 * Method to click on Health unlocked.
	 */
	public void navigateToHomePage() {

		driver.navigate().to("https://healthunlocked.com");
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
	}

	/**
	 * Method to set reset email.
	 *
	 */
	public void setResetEmail(String value) {
		requestemail.sendKeys(value);
	}

	/**
	 * Method to verify the alert.
	 *
	 * @return boolean
	 */
	public boolean verifyAlert() {

		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath("//*[contains(text(),'shortly receive an email')]"));
	}

	/**
	 * Method to verify reset page header.
	 *
	 * @return boolean
	 */
	public boolean verifyResetPageHeader() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Forgot your password?']"));
		return isElementPresent(resetPageHeader);
	}

	/**
	 * Method to wait until invisible of banner message.
	 *
	 * @return boolean
	 */
	public boolean waitUntilInvisibleofBannerMessage() {
		final WebDriverWait wait = new WebDriverWait(driver, MAX_WEBELMENT_TIMEOUT);
		return wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'shortly receive an email')]")));
	}
}
