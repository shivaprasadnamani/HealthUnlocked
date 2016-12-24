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
import com.hu.webdriver.util.TestLogger;

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
	 * Test Logger.
	 */
	TestLogger logger = TestLogger.getLogger(SignUpTest.class);
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
		logger.logTestStep("Click on sign up.");
		signUpPage.clickOnSignUp();
		logger.logTestStep("Click on terms of use.");
		signUpPage.clickOnTermsOfUse();
		logger.logTestStep("Get window handle.");
		signUpPage.swithToChildWindow();

		logger.logTestStep("Check is Terms of usage header displayed.");
		final boolean isTermsOfUsageHeaderDisplayed = signUpPage.isTermsOfUsageHeaderDisplayed();
		logger.logTestVerificationStep(
				"Verify whether terms of use page should appear." + isTermsOfUsageHeaderDisplayed);
		Assert.assertTrue(isTermsOfUsageHeaderDisplayed, "Header not exists.");

		logger.logTestStep("Close window.");
		closeWindow();
		logger.logTestStep("Switch to Main window.");
		signUpPage.switchToMainWindow();
		logger.logTestStep("Click on Sign up close Model.");
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
		logger.logTestStep("Click on sign up.");
		signUpPage.clickOnSignUp();
		logger.logTestStep("Store User name.");
		final String invalidUserName = propertyUtil.getProperty("invalidUserName");
		logger.logTestStep("Set user name." + invalidUserName);
		signUpPage.setUserName(invalidUserName);
		logger.logTestStep("Store Emailid.");
		final String emailId = propertyUtil.getProperty("userName");
		logger.logTestStep("Set email id." + emailId);
		signUpPage.setEmailId(emailId);
		logger.logTestStep("Click on Sign up.");
		signUpPage.clickOnSignUpWithEmail();

		logger.logTestStep("Check is invalid Email errror message displayed.");
		final boolean isInvaildEmailErrorMessageDisplayed = signUpPage.isInvaildEmailErrorMessageDisplayed();
		logger.logTestVerificationStep(
				"verify whether email id message is displaying or not." + isInvaildEmailErrorMessageDisplayed);
		Assert.assertTrue(isInvaildEmailErrorMessageDisplayed, "Message not displying.");

		logger.logTestStep("Click on Sign up close model.");
		signUpPage.clickOnSignUpCloseModel();
	}

	/**
	 * Sign up Page-T1115:Add valid email, user name and password to sign up
	 * using email.
	 */
	@Test(description = "Sign up Page-T1115:Add valid email, user name and password to sign up using email.")
	public void verifySignUpWithValidCredentials() {
		logger.logTestStep("Click on sign up.");
		signUpPage.clickOnSignUp();
		logger.logTestStep("Store User name.");
		final String validUserName = propertyUtil.getProperty("validUserName");
		logger.logTestStep("Set user name." + validUserName);
		signUpPage.setUserName(validUserName);
		logger.logTestStep("Store Emailid.");
		final String emailId = propertyUtil.getProperty("emailId");
		logger.logTestStep("Set email id." + emailId);
		signUpPage.setEmailId(emailId);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set password." + password);
		signUpPage.setPassword(password);
		logger.logTestStep("Click on click on sign up with email.");
		signUpPage.clickOnSignUpWithEmail();

		logger.logTestStep("Check is popular communities displayed.");
		final boolean isPopularCommunities = joinPage.isPopularCommunities();
		logger.logTestVerificationStep("Verify find communities." + isPopularCommunities);
		Assert.assertTrue(isPopularCommunities, "Popular community not displaying.");

		logger.logTestStep("Navigate to Home page.");
		newsFeedPage.navigateToNewsfeedPage();
		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfileforValidCredentials();
		logger.logTestStep("Click on Account settings.");
		newsFeedPage.clickOnAccountSettings();
		logger.logTestStep("Click on Got it.");
		newsFeedPage.clickOnGotit();
		logger.logTestStep("Click on show account delete button.");
		newsFeedPage.clickOnShowAccountDeleteButton();
		logger.logTestStep("Click on settings account delete button.");
		newsFeedPage.clickOnSettingsAccountDeleteButton();
		logger.logTestStep("Click on account delete button.");
		newsFeedPage.clickOnAccountDeleteButton();
		logger.logTestStep("Wait until visibility of Sign up.");
		homePage.waitUntilVisibilityOfSignUP();

		logger.logTestStep("Check whether wait until Invisible of banner of account.");
		final boolean waitUntilInvisibleOfBannerOfAccount = signUpPage.waitUntilInvisibleOfBannerOfAccount();
		logger.logTestStep("Verifying whether banner is invisible or not." + waitUntilInvisibleOfBannerOfAccount);
		Assert.assertTrue(waitUntilInvisibleOfBannerOfAccount, "Banner still exist.");
	}
}
