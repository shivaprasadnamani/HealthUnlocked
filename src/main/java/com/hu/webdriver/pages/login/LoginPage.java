package com.hu.webdriver.pages.login;

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
public class LoginPage extends BasePage {
	/**
	 * By element for Forgot Password.
	 */
	By forgotPassword = By.xpath("//a[text()='Forgot your password?']");

	/**
	 * WebElement for credentials Alert Message.
	 */
	@FindBy(xpath = "//*[contains(text(),'It looks like that email')]")
	WebElement invalidLoginCredentialsBannerMessage;

	/**
	 * By element for Login.
	 */
	By login = By.xpath("//a[text()='Log in']");

	/**
	 *By element for login model close button.
	 */
	By loginModelCloseButton = By.cssSelector(".modal-close");

	/**
	 * WebElement for model header.
	 */
	@FindBy(xpath = "//span[contains(text(),'Welcome back')]")
	WebElement modelHeader;

	/**
	 * WebElement for Password.
	 */
	@FindBy(name = "password")
	WebElement password;

	/**
	 * By element for Submit Button.
	 */
	By submit = By.id("login-submit-button");

	/**
	 * WebElement for User Name.
	 */
	@FindBy(id = "login-email-input")
	WebElement userName;

	/**
	 * Constructor
	 *
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to click on Forgot Password.
	 */
	public void clickOnForgotPassword() {
		findClickableElement(forgotPassword).click();
	}

	/**
	 * Method to click on Login.
	 */
	public void clickOnLogin() {
		findClickableElement(login).click();
	}

	/**
	 * Method to click on login model close button.
	 */
	public void clickOnLoginModelCloseButtton() {
		findClickableElement(loginModelCloseButton).click();
	}

	/**
	 * Method to click on Submit Button.
	 */
	public void clickOnSubmit() {
		findClickableElement(submit).click();
	}

	/**
	 * Method to verify the Alert Message is Displaying or not.
	 *
	 * @return boolean
	 */
	public boolean isCredentialsAlertMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT,
				invalidLoginCredentialsBannerMessage);
	}

	/**
	 * Method to check whether is Email Text Field Visible.
	 *
	 * @return boolean
	 */
	public boolean isEmailTextFieldVisible() {
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, userName);
	}

	/**
	 * Method to verify Model is Present or not.
	 *
	 * @return boolean
	 */
	public boolean isModelIsPresent() {
		return isElementPresent(modelHeader);
	}

	/**
	 * Method to set Password.
	 *
	 * @param value
	 */
	public void setPassWord(String value) {
		password.sendKeys(value);
	}

	/**
	 * Method to set User Name.
	 *
	 * @param value
	 */
	public void setUserName(String value) {
		userName.sendKeys(value);
	}
}
