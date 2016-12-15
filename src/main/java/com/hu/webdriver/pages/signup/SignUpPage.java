package com.hu.webdriver.pages.signup;

import java.util.ArrayList;

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
public class SignUpPage extends BasePage {
	/**
	 * WebElement for close sign up model.
	 */
	@FindBy(css = ".icon-close")
	WebElement closeSignUpModel;

	/**
	 * WebElement for email id.
	 */
	@FindBy(id = "register-email-input")
	WebElement emailId;

	/**
	 * WebElement for email id message.
	 */
	@FindBy(xpath = "//li[text()='Email address is not available.']")
	WebElement emailIdMessage;

	/**
	 * WebElement for password.
	 */
	@FindBy(id = "register-password-input")
	WebElement password;

	/**
	 * WebElement for sign up.
	 */
	@FindBy(css = ".btn-min-blue")
	WebElement signUp;

	/**
	 * WebElement for sign up with email.
	 */
	@FindBy(xpath = "//input[@value='Sign up with email']")
	WebElement signUpWithEmail;

	/**
	 * WebElement for terms of use.
	 */
	@FindBy(linkText = "terms of use")
	WebElement termsOfUse;

	/**
	 * WebElement for terms page header.
	 */
	@FindBy(xpath = "//h3[text()='1. About us']")
	WebElement termsPageHeader;

	/**
	 * WebElement for user name.
	 */
	@FindBy(id = "register-username-input")
	WebElement userName;

	/**
	 * WebElement for user name message.
	 */
	@FindBy(xpath = "//li[text()='Username is not available.']")
	WebElement userNameMessage;

	/**
	 * Constructor
	 *
	 * @param driver
	 */
	public SignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method for click on sign up.
	 */
	public void clickOnSignUp() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.cssSelector(".btn-min-blue"));
		signUp.click();
	}

	/**
	 * Method to click on sign up model.
	 */
	public void clickOnSignUpCloseModel() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.cssSelector(".icon-close"));
		closeSignUpModel.click();
	}

	/**
	 * Method to click on sign up with email.
	 */
	public void clickOnSignUpWithEmail() {
		signUpWithEmail.click();
	}

	/**
	 * Method for click on terms of use.
	 */
	public void clickOnTermsOfUse() {
		termsOfUse.click();
	}

	/**
	 * Method to verify terms of use page.
	 */
	public boolean getTermsPageHeader() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h3[text()='1. About us']"));
		return termsPageHeader.isDisplayed();
	}

	public boolean isSignUpUserNameVisibe() {
		return isElementPresent(userName);
	}

	/**
	 * Method to set email id.
	 *
	 * @param value
	 */
	public void setEmailId(String value) {
		emailId.sendKeys(value);
	}

	/**
	 * Method to set password.
	 *
	 * @param value
	 */
	public void setPassword(String value) {
		password.sendKeys(value);
	}

	/**
	 * Method to set user name.
	 *
	 * @param value
	 */
	public void setUserName(String value) {
		userName.sendKeys(value);
	}

	/**
	 * Method to switch to main window.
	 */
	public void switchToMainWindow() {
		final ArrayList<String> tabOne = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabOne.get(0));
	}

	/**
	 * Method to get window handle.
	 */
	public void swithToChildWindow() {
		final ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	/**
	 * Method to verify email id message.
	 *
	 * @return boolean
	 */
	public boolean verifyEmailIdMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, emailIdMessage);
	}

	/**
	 * Method to verify user name message
	 *
	 * @return boolean
	 */
	public boolean verifyUserNameMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, userNameMessage);
	}
}
