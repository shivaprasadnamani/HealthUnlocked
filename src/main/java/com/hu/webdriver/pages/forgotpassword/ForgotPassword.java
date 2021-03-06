package com.hu.webdriver.pages.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

/**
 * @author SHIVA
 */
public class ForgotPassword extends BasePage {
	/**
	 * WebElement for forgot password page alert message.
	 */
	@FindBy(xpath = "//*[contains(text(),'shortly receive an email')]")
	WebElement forgotPasswordPageAlertMessage;

	/**
	 * WebElement for Forgot password page header.
	 */
	@FindBy(xpath = "//h1[text()='Forgot your password?']")
	WebElement forgotPasswordPageHeader;

	/**
	 * WebElement for Submit Button.
	 */
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;

	/**
	 * WebElement for User email.
	 */
	@FindBy(id = "requestReset-email-button")
	WebElement userEmail;

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
		findClickableElement(By.xpath("//input[@type='submit']")).click();
	}

	/**
	 * Method to verify forgot Password page header.
	 *
	 * @return boolean
	 */
	public boolean isForgotPasswordHeaderDisplayed() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, forgotPasswordPageHeader);
	}

	/**
	 * Method to verify reset Password alert message.
	 *
	 * @return boolean
	 */
	public boolean isResetPasswordAlertMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, forgotPasswordPageAlertMessage);
	}

	/**
	 * Method to set reset email.
	 *
	 * @param value
	 */
	public void setResetEmail(String value) {
		userEmail.sendKeys(value);
	}

	/**
	 * Method to wait until invisible of Forgot password page banner.
	 *
	 * @return boolean
	 */
	public boolean waitUntilInvisibleofForgotPasswordPageBanner() {
		return waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'shortly receive an email')]"));
	}
}
