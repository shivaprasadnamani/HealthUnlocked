package com.hu.webdriver.tests.signup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.forgotpassword.ForgotPassword;
import com.hu.webdriver.pages.home.HomePage;
import com.hu.webdriver.pages.join.JoinPage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.signup.SignUpPage;
import com.hu.webdriver.tests.BaseTest;


/**
 * @author SHIVA
 */
public class SignUpTest extends BaseTest {
	/**
	 * Instance variables
	 */
	ForgotPassword forgotPasswordPage;
	HomePage homePage;
	JoinPage joinPage;
	NewsFeedPage newsFeedPage;
	SignUpPage signUpPage;

	/**
	 * Login Page-T1104:Access terms of use page from sign up page.
	 */
	@Test(description = "Signup Page-T1104:Access terms of use page from sign up page.")
	public void accessTermsOfUsePageFromSignUpPage() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Click on terms of use
		signUpPage.clickOnTermsOfUse();
		// Get window handle
		signUpPage.swithToChildWindow();
		// Verify whether terms of use page should appear
		Assert.assertTrue(signUpPage.getTermsPageHeader(), "Header not exists.");
		// Close window
		closeWindow();
		// Switch to Main window
		signUpPage.switchToMainWindow();
		// Click on Sign up close Model
		signUpPage.clickOnSignUpCloseModel();
	}

	@BeforeMethod
	public void setup() {
		signUpPage = new SignUpPage(driver);
		forgotPasswordPage = new ForgotPassword(driver);
		newsFeedPage = new NewsFeedPage(driver);
		homePage = new HomePage(driver);
		joinPage = new JoinPage(driver);
	}

	/**
	 * Sign up Page-T1109:Email address or user name already registered.
	 */
	@Test(description = "Signup Page-T1109:Email address or username already registered.")
	public void signupWithInvalidCredentials() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Set user name
		signUpPage.setUserName("shivaprasadnamani");
		// Set email id
		signUpPage.setEmailId("shivaprasadnamani2016@gmail.com");
		// Click on Sign up
		signUpPage.clickOnSignUpWithEmail();
		// verify whether email id message is displaying or not
		Assert.assertTrue(signUpPage.verifyEmailIdMessage(), "Message not displying.");
		// Click on Sign up close model
		signUpPage.clickOnSignUpCloseModel();
	}

	/**
	 * Sign up Page-T1115:Add valid email, user name and password to sign up
	 * using email.
	 */
	@Test(description = "Sign up Page-T1115:Add valid email, user name and password to sign up using email.")
	public void signUpWithValidCredentials() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Set user name
		signUpPage.setUserName("shivaprasad123");
		// Set email id
		signUpPage.setEmailId("shivaprasad.apricot@gmail.com");
		// Set password
		signUpPage.setPassword("shivaprasad9");
		// Click on click on sign up with email
		signUpPage.clickOnSignUpWithEmail();
		// Verify find communities
		Assert.assertTrue(joinPage.verifyPopularCommunities(), "Popular community not displaying.");
		// Navigate to Home page
		newsFeedPage.navigateToNewsfeedPage();
		// Click on user profile
		newsFeedPage.clickOnUserProfileforValidCredentials();
		// Click on Account settings
		newsFeedPage.clickOnAccountSettings();
		// Click on Got it
		newsFeedPage.clickOnGotit();
		// Click on show account delete button
		newsFeedPage.clickOnShowAccountDeleteButton();
		// Click on settings account delete button
		newsFeedPage.clickOnSettingsAccountDeleteButton();
		// Click on account delete button
		newsFeedPage.clickOnAccountDeleteButton();
		// Wait until visibility of Sign up.
		homePage.waitUntilvisibilityOfSignUP();
		// Verifying whether banner is invisible or not
		Assert.assertTrue(homePage.waitUntilInvisibleOfBanner(), "Banner still exist.");
	}
}
