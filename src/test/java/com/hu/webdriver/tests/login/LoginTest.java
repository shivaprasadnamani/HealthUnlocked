package com.hu.webdriver.tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.forgotpassword.ForgotPassword;
import com.hu.webdriver.pages.home.HomePage;
import com.hu.webdriver.pages.join.JoinPage;
import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.userprofilepage.UserProfilePage;
import com.hu.webdriver.tests.BaseTest;
import com.hu.webdriver.util.TestLogger;

/**
 *
 * @author SHIVA
 *
 */
public class LoginTest extends BaseTest {
	/**
	 * Instance variables for Forgot password page.
	 */
	ForgotPassword forgotPassword;
	/**
	 * Instance variable for User Home page.
	 */
	HomePage homePage;
	/**
	 * Instance variable for Join page.
	 */
	JoinPage joinPage;
	/**
	 * Test Logger.
	 */
	TestLogger logger = TestLogger.getLogger(LoginTest.class);
	/**
	 * Instance variable for Login page.
	 */
	LoginPage loginPage;
	/**
	 * Instance variable for News feed page.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variable for User profile page.
	 */
	UserProfilePage userProfilePage;

	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		forgotPassword = new ForgotPassword(driver);
		userProfilePage = new UserProfilePage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		joinPage = new JoinPage(driver);
	}

	/**
	 * Login Page-T108: Enter email in forgot password page And Login.
	 * Page-T1011: Access forgot your password page from log in.
	 */
	@Test(description = "Login Page-T108: Enter email in forgot password page And Login Page-T1011: Access forgot your password page from log in.")
	public void verifyEnteringEmailinForgotPasswordPage() {
		logger.logTestStep("Click on login link");
		loginPage.clickOnLogin();
		logger.logTestStep("Click on forgot password link");
		loginPage.clickOnForgotPassword();

		logger.logTestStep("Check whether forgot password header displayed.");
		final boolean isForgotPasswordHeaderDisplayed = forgotPassword.isForgotPasswordHeaderDisplayed();
		logger.logTestVerificationStep(
				"Verifying the reset page header should displayed." + isForgotPasswordHeaderDisplayed);
		Assert.assertTrue(isForgotPasswordHeaderDisplayed, "Page header is not displayed.");

		logger.logTestStep("Store user name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set reset email" + userName);
		forgotPassword.setResetEmail(userName);
		logger.logTestStep("click on submit button.");
		forgotPassword.clickOnSubmitButton();

		logger.logTestStep("Check Reset password alert message.");
		final boolean isResetPasswordAlertMessage = forgotPassword.isResetPasswordAlertMessage();
		logger.logTestVerificationStep("Verifying the alert should present." + isResetPasswordAlertMessage);
		Assert.assertTrue(isResetPasswordAlertMessage, "Alert is not presenting.");

		logger.logTestStep("Navigate to home page.");
		homePage.navigateToHomePage();
		logger.logTestStep("Check wait until invisible of forgot password page banner.");
		final boolean waitUntilInvisibleofForgotPasswordPageBanner = forgotPassword
				.waitUntilInvisibleofForgotPasswordPageBanner();
		logger.logTestVerificationStep(
				"Verify whether Banner is displaying or not." + waitUntilInvisibleofForgotPasswordPageBanner);
		Assert.assertTrue(waitUntilInvisibleofForgotPasswordPageBanner, "Banner is still existing.");

		logger.logTestStep("check home page is displayed.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verify whether Home page is navigating or not." + isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Home Page-T1001:Display log in modal.
	 */
	@Test(description = "Home Page-T1001:Display log in modal.")
	public void verifyHomePage() {
		logger.logTestStep("Click on about us.");
		homePage.clickOnAboutUs();
		logger.logTestStep("Verify about us page.");
		homePage.isAboutUsPage();
		logger.logTestStep("Click on news.");
		homePage.clickOnNews();
		logger.logTestStep("Verify new page.");
		homePage.isNewsPage();
		logger.logTearDownStep("Click on jobs.");
		homePage.clickOnJobs();
		logger.logTestStep("Verify jobs page.");
		homePage.isJObsPage();
		logger.logTestStep("Click on Home Page.");
		homePage.navigateToHomePage();
		logger.logTestStep("Click on communities.");
		homePage.clickOnCommunities();
		logger.logTestStep("Verify communities.");
		homePage.isCommunityPage();
		logger.logTestStep("Navigate to home page.");
		homePage.navigateToHomePage();

		logger.logTestStep("Check Home page displayed.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verifying whether navigating home page or not." + isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Login Page-T102: Test case to verify Login using email address via modal.
	 * And Login page-T1004: Login using email address via Log in page
	 */
	@Test(description = "Login Page-T102:  Test case to verify Login using email address via modal And Login page-T1004: Login using email address via Log in page.")
	public void verifyLoginUsingEmailAddressViaModel() {
		logger.logTestStep("Click on login link.");
		loginPage.clickOnLogin();

		logger.logTestStep("Check Email text field visible.");
		boolean isEmailTextFieldVisible = loginPage.isEmailTextFieldVisible();
		logger.logTestVerificationStep("Verify Login page appeared." + isEmailTextFieldVisible);
		Assert.assertTrue(isEmailTextFieldVisible, "Email texfield doesn't existed.");

		logger.logTestStep("Store user name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set User name." + userName);
		loginPage.setUserName(userName);

		logger.logTestStep("Store password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("click on submit button.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Check newsfeed displayed.");
		final boolean isNewsfeedDisplay = newsFeedPage.isNewsfeedDisplay();
		logger.logTestVerificationStep("Verify the news feed should appear." + isNewsfeedDisplay);
		Assert.assertTrue(isNewsfeedDisplay, "Newsfeed is not appearing.");

		logger.logTestStep("Check Email text field visible.");
		isEmailTextFieldVisible = loginPage.isEmailTextFieldVisible();
		logger.logTestVerificationStep("Verify the login modal should disappear." + isEmailTextFieldVisible);
		Assert.assertFalse(isEmailTextFieldVisible, "Email texfield existed.");

		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on logout.");
		newsFeedPage.clickOnLogout();

		logger.logTestStep("Check Home page displayed.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verifying whether navigating home page or not." + isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Login Page-T1019:log out and redirect to index page.
	 */
	@Test(description = "Login Page-T1019:log out and redirect to index page.")
	public void verifyLogout() {
		logger.logTestStep("Click on login link.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store User name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set user name." + userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on logout.");
		newsFeedPage.clickOnLogout();
		logger.logTestStep("Check Home page displayed.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verifying whether navigating home page or not." + isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Login Page-T1003: Wrong credentials.
	 *
	 * @throws InterruptedException
	 */
	@Test(description = "Login Page-T1003: Wrong credentials.")
	public void verifyWrongCredential() {
		logger.logTestStep("Click on login link.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store userName.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set user name." + userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("wrongPassword");
		logger.logTestStep("Set password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Check is Credentials alert message displayed.");
		final boolean isCredentialsAlertMessage = loginPage.isCredentialsAlertMessage();
		logger.logTestVerificationStep("Verifying the alert message should appear." + isCredentialsAlertMessage);
		Assert.assertTrue(isCredentialsAlertMessage, "Credential alert message is not displaying.");

		logger.logTestStep("Check is Model is present or not.");
		final boolean isModelIsPresent = loginPage.isModelIsPresent();
		logger.logTestVerificationStep("Verifying the model should present."+isModelIsPresent);
		Assert.assertTrue(isModelIsPresent, "Model doesn't exist.");
		logger.logTestStep("Click on Login model close button.");
		loginPage.clickOnLoginModelCloseButtton();
	}
}
