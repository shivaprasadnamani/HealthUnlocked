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
	 * Constructor
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElement for Login
	 */
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement login;

	/**
	 * WebElement for User Name
	 */
	@FindBy(id = "login-email-input")
	WebElement userName;

	/**
	 * WebElement for Password
	 */
	@FindBy(name = "password")
	WebElement password;

	/**
	 * WebElement for Submit Button
	 */
	@FindBy(xpath = "//button[@id='login-submit-button']")
	WebElement submit;
	/**
	 * WebElement for Forgot Password
	 */
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotPassword;
	/**
	 * WebElement for Alert Message
	 */
	@FindBy(xpath = "//*[contains(text(),'It looks like that email')]")
	WebElement credentialsAlertMessage;
	/**
	 * WebElement for model header
	 */
	@FindBy(xpath = "//span[contains(text(),'Welcome back')]")
	WebElement modelHeader;

	/*
	 * WebElement for health unlocked image
	 */
	@FindBy(xpath = "//img[@class='logo']")
	WebElement healthUnlockedImage;

	/**
	 * Method to click on Login
	 */
	public void clickOnLogin() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Log in']"));
		login.click();
	}

	/**
	 * Method to set User Name
	 * 
	 * @param value
	 */
	public void setUserName(String value) {
		userName.sendKeys(value);
	}

	/**
	 * Method to set Password
	 * 
	 * @param value
	 */
	public void setPassWord(String value) {
		password.sendKeys(value);
	}

	/**
	 * Method to check whether is Email Text Field Visible
	 * 
	 * @return
	 */
	public boolean isEmailTextFieldVisible() {
		// return isElementPresent(username);
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.id("login-email-input"));
	}

	/**
	 * Method to click on Submit Button
	 */
	public void clickOnSubmit() {
		submit.click();
	}

	/**
	 * Method to click on Forgot Password
	 */
	public void clickOnForgotPassword() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Forgot your password?']"));
		forgotPassword.click();
	}

	/**
	 * Method to verify the Alert Message is Displaying or not
	 * 
	 * @return
	 */
	public boolean verifyCredentialsAlertMessage() {
		/*
		 * webDriverWait(MAX_WAIT,
		 * By.xpath("//*[contains(text(),'It looks like that email')]")); return
		 * isElementPresent(alertMessage);
		 */

		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, credentialsAlertMessage);
	}

	/**
	 * Method to verify Model is Present or not
	 * 
	 * @return boolean
	 */
	public boolean verifyModelIsPresent() {
		return isElementPresent(modelHeader);
	}

	/**
	 * Method to verify home page
	 * 
	 * @return
	 */
	public boolean verifyHomePage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
		return healthUnlockedImage.isDisplayed();
	}

}
