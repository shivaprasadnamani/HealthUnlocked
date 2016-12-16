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
	 * Instance variables for Forgot password page.
	 */
	ForgotPassword forgotPasswordPage;
	/**
	 * Instance variables for Home page.
	 */
	HomePage homePage;
	/**
	 * Instance variables for Join page.
	 */
	JoinPage joinPage;
	/**
	 * Instance variables for News feed page.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variables for Sign up page.
	 */
	SignUpPage signUpPage;

	/**
	 * Login Page-T1104:Access terms of use page from sign up page.
	 */
	@Test(description = "Signup Page-T1104:Access terms of use page from sign up page.")
	public void verifyAccessTermsOfUsePageFromSignUpPage() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Click on terms of use
		signUpPage.clickOnTermsOfUse();
		// Get window handle
		signUpPage.swithToChildWindow();
		// Verify whether terms of use page should appear
		Assert.assertTrue(signUpPage.isTermsOfUsageHeaderDisplayed(), "Header not exists.");
		// Close window
		closeWindow();
		// Switch to Main window
		signUpPage.switchToMainWindow();
		// Click on Sign up close Model
		signUpPage.clickOnSignUpCloseModel();
	}

	@BeforeMethod
	public void verifySetup() {
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
	public void verifySignupWithInvalidCredentials() {
		// Click on sign up
		signUpPage.clickOnSignUp();
		// Set user name
		signUpPage.setUserName("shivaprasadnamani");
		// Set email id
		signUpPage.setEmailId("shivaprasadnamani2016@gmail.com");
		// Click on Sign up
		signUpPage.clickOnSignUpWithEmail();
		// verify whether email id message is displaying or not
		Assert.assertTrue(signUpPage.isInvaildEmailErrorMessageDisplayed(), "Message not displying.");
		// Click on Sign up close model
		signUpPage.clickOnSignUpCloseModel();
	}

	/**
	 * Sign up Page-T1115:Add valid email, user name and password to sign up
	 * using email.
	 */
	@Test(description = "Sign up Page-T1115:Add valid email, user name and password to sign up using email.")
	public void verifySignUpWithValidCredentials() {
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
		Assert.assertTrue(joinPage.isPopularCommunities(), "Popular community not displaying.");
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
		homePage.waitUntilVisibilityOfSignUP();
		// Verifying whether banner is invisible or not
		Assert.assertTrue(signUpPage.waitUntilInvisibleOfBannerOfAccount(), "Banner still exist.");
	}
}
