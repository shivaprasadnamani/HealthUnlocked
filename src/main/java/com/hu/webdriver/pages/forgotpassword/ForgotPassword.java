package com.hu.webdriver.pages.forgotpassword;

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
public class ForgotPassword extends BasePage {
	/**
	 * Instance variable for WebDriver
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
	 * WebElement for Request Email
	 */
	@FindBy(id = "requestReset-email-button")
	WebElement requestemail;
	/**
	 * WebElement for Submit Button
	 */
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement submitButton;
	/**
	 * WebElement for News Feed
	 */
	@FindBy(linkText = "News Feed")
	WebElement newsfeed;
	/**
	 * WebElement for alert message
	 */
	@FindBy(xpath = "//*[contains(text(),'shortly receive an email')]")
	WebElement alertmessage;
	/**
	 * WebElement for reset page header
	 */
	@FindBy(xpath = "//h1[text()='Forgot your password?']")
	WebElement resetPageHeader;

	/**
	 * Method to set reset email
	 * 
	 */
	public void setResetEmail(String value) {
		requestemail.sendKeys(value);
	}

	/**
	 * Method for click on Submit Button
	 */
	public void clickOnSubmitButton() {
		submitButton.click();
	}

	/**
	 * Method to verify the news feed
	 * 
	 * @return boolean.
	 */
	public boolean newsfeeddisplay() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.linkText("News Feed"));
		return newsfeed.isDisplayed();
	}

	/**
	 * Method to verify the alert
	 * 
	 * @return
	 */
	public boolean verifyAlert() {
		return alertmessage.isDisplayed();
	}

	/**
	 * Method to verify reset page header
	 * 
	 * @return
	 */
	public boolean verifyResetPageHeader() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Forgot your password?']"));
		return isElementPresent(resetPageHeader);
	}

}
