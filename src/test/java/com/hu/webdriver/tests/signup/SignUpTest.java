package com.hu.webdriver.tests.signup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.signup.SignUpPage;
import com.hu.webdriver.tests.BaseTest;


/**
 * 
 * @author SHIVA
 *
 */
public class SignUpTest extends BaseTest {
	/**
	 * Declaring references for classes
	 */
	SignUpPage signUpPage;

	/**
	 * Initializing classes references
	 */
	@BeforeMethod
	public void InitializeReferences() {
		signUpPage = new SignUpPage(driver);
		driver.get("https://healthunlocked.com");

	}

	/**
	 * Login Page-T1104:Access terms of use page from sign up page
	 */
	@Test(description = "Signup Page-T1104:Access terms of use page from sign up page")
	public void accessUsePage() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Click on terms of use
		signUpPage.clickOnTermsOfUse();
		// Get window handle
		signUpPage.getWindowHandle();
		// Verify whether terms of use page should appear
		Assert.assertTrue(signUpPage.getTermsPageHeader(), "Header not exists");
	}

	/**
	 * Sign up Page-T1109:Email address or user name already registered
	 */
	@Test(description = "Signup Page-T1109:Email address or username already registered")
	public void signupWithInvalidCredentials() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Set user name
		signUpPage.setUserName("shivaprasadnamani");
		// Set email id
		signUpPage.setEmailId("shivaprasadnamani2016@gmail.com");
		// Click on Sign up
		signUpPage.clickOnSignUpWithEmail();
		// Verify whether user name message displaying or not
		// Assert.assertTrue(signUpPage.verifyUserNameMessage(),"Message not
		// displying");
		// verify whether email id message is displaying or not
		Assert.assertTrue(signUpPage.verifyEmailIdMessage(), "Message not displying");
	}

	/**
	 * Sign up Page-T1115:Add valid email, user name and password to sign up
	 * using email
	 */
	@Test(description = "Sign up Page-T1115:Add valid email, user name and password to sign up using email")
	public void signUpWithValidCredentials() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Set user name
		signUpPage.setUserName("shivaprasadnamani");
		// Set email id
		signUpPage.setEmailId("shivaprasadnamani2016@gmail.com");
		// Set password
		signUpPage.setPassword("shivaprasad9");
		// Click on click on sign up with email
		signUpPage.clickOnSignUpWithEmail();
		// Verify find communities
		Assert.assertTrue(signUpPage.verifyPopularCommunities());
	}
	
}
