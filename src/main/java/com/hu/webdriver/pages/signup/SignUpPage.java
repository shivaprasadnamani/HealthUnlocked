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
	WebElement invalidEmailErrorMessage;

	/**
	 * WebElement for user name message.
	 */
	@FindBy(xpath = "//li[text()='Username is not available.']")
	WebElement invalidUserNameErrorMessage;

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
	@FindBy(xpath = "//h1[text()='Terms of use']")
	WebElement termsPageHeader;

	/**
	 * WebElement for user name.
	 */
	@FindBy(id = "register-username-input")
	WebElement userName;

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
	 * Method to verify email id message displaying or not.
	 *
	 * @return boolean
	 */
	public boolean isInvaildEmailErrorMessageDisplayed() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, invalidEmailErrorMessage);
	}

	/**
	 * Method for Sign up user name visible or not.
	 *
	 * @return boolean
	 */
	public boolean isSignUpUserNameVisibe() {
		return isElementPresent(userName);
	}

	/**
	 * Method to verify terms of use page header Displaying or not.
	 */
	public boolean isTermsOfUsageHeaderDisplayed() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Terms of use']"));
		return termsPageHeader.isDisplayed();
	}

	/**
	 * Method to verifying whether user name message present or not.
	 *
	 * @return boolean
	 */
	public boolean isUserNameMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, invalidUserNameErrorMessage);
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
	 * Method to wait until Invisible of banner of Account.
	 *
	 * @return boolean
	 */
	public boolean waitUntilInvisibleOfBannerOfAccount() {
		return waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'account has been deleted')]"));
	}
}
