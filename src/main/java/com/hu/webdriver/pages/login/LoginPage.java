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
	 * WebElement for Alert Message.
	 */
	@FindBy(xpath = "//*[contains(text(),'It looks like that email')]")
	WebElement credentialsAlertMessage;

	/**
	 * WebElement for Forgot Password.
	 */
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotPassword;

	/**
	 * WebElement for Login.
	 */
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement login;

	/**
	 * WebElement for login model close button.
	 */
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement loginModelCloseButton;

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
	 * WebElement for Submit Button.
	 */
	@FindBy(xpath = "//button[@id='login-submit-button']")
	WebElement submit;

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
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Forgot your password?']"));
		forgotPassword.click();
	}

	/**
	 * Method to click on Login.
	 */
	public void clickOnLogin() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Log in']"));
		login.click();
	}

	/**
	 * Method to click on login model close button.
	 */
	public void clickOnLoginModelCloseButtton() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//button[@type='button'])[1]"));
		loginModelCloseButton.click();
	}

	/**
	 * Method to click on Submit Button.
	 */
	public void clickOnSubmit() {
		submit.click();
	}

	/**
	 * Method to check whether is Email Text Field Visible.
	 *
	 * @return boolean
	 */
	public boolean isEmailTextFieldVisible() {
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.id("login-email-input"));
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

	/**
	 * Method to verify the Alert Message is Displaying or not.
	 *
	 * @return boolean
	 */
	public boolean verifyCredentialsAlertMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT,
				By.xpath("//*[contains(text(),'It looks like that email')]"));
	}

	/**
	 * Method to verify Model is Present or not.
	 *
	 * @return boolean
	 */
	public boolean verifyModelIsPresent() {
		return isElementPresent(modelHeader);
	}
}
