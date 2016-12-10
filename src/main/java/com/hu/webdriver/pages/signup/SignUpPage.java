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
	 * Constructor
	 * 
	 * @param driver
	 */
	public SignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElement for sign up
	 */
	@FindBy(linkText = "Sign up")
	WebElement signUp;
	/**
	 * WebElement for terms of use
	 */
	@FindBy(linkText = "terms of use")
	WebElement termsOfUse;
	/**
	 * WebElement for terms page header
	 */
	@FindBy(xpath = "//h3[text()='1. About us']")
	WebElement termsPageHeader;
	/**
	 * WebElement for user name
	 */
	@FindBy(id = "register-username-input")
	WebElement userName;
	/**
	 * WebElement for email id
	 */
	@FindBy(id = "register-email-input")
	WebElement emailId;
	/**
	 * WebElement for user name message
	 */
	@FindBy(xpath = "//li[text()='Username is not available.']")
	WebElement userNameMessage;
	/**
	 * WebElement for email id message
	 */
	@FindBy(xpath = "//li[text()='Email address is not available.']")
	WebElement emailIdMessage;
	/**
	 * WebElement for sign up with email
	 */
	@FindBy(xpath="//input[@value='Sign up with email']")
	WebElement signUpWithEmail;
	/**
	 * WebElement for password
	 */
	@FindBy(id="register-password-input")
	WebElement password;
	/**
	 * Method for click on sign up
	 */
	public void clickOnSignUp() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.linkText("Sign up"));
		signUp.click();
	}

	/**
	 * Method for click on terms of use
	 */
	public void clickOnTermsOfUse() {
		termsOfUse.click();
	}

	/**
	 * Method to get window handle
	 */
	public void getWindowHandle() {
		// Set<String> handle = driver.getWindowHandles();
		// driver.switchTo().window("0");
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		System.out.println(tab.size());

	}

	/**
	 * Method to verify terms of use page
	 */
	public boolean getTermsPageHeader() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h3[text()='1. About us']"));
		return termsPageHeader.isDisplayed();
	}

	/**
	 * Method to set user name
	 * 
	 * @param value
	 */
	public void setUserName(String value) {
		userName.sendKeys(value);
	}

	/**
	 * Method to set email id
	 * 
	 * @param value
	 */
	public void setEmailId(String value) {
		emailId.sendKeys(value);
	}

	/**
	 * Method to verify user name message
	 * 
	 * @return boolean
	 */
	public boolean verifyUserNameMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, userNameMessage);
		//return userNameMessage.isDisplayed();
	}

	/**
	 * Method to verify email id message
	 * 
	 * @return boolean
	 */
	public boolean verifyEmailIdMessage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, emailIdMessage);
		//return emailIdMessage.isDisplayed();
	}
	/**
	 * Method to click on sign up with email
	 */
	public void clickOnSignUpWithEmail(){
		signUpWithEmail.click();
	}
	/**
	 * Method to set password
	 * @param value
	 */
	public void setPassword(String value){
		password.sendKeys(value);
	}
}
