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
		// Click on login link
		loginPage.clickOnLogin();
		// Click on forgot password link
		loginPage.clickOnForgotPassword();
		// Verifying the reset page header should display
		Assert.assertTrue(forgotPassword.isForgotPasswordHeaderDisplayed(), "Page header is not displaying.");
		// Set reset email
		forgotPassword.setResetEmail(propertyUtil.getProperty("userName"));
		// click on submit button
		forgotPassword.clickOnSubmitButton();
		// Verifying the alert should present
		Assert.assertTrue(forgotPassword.isResetPasswordAlertMessage(), "Alert is not presenting.");
		// Navigate to home page
		homePage.navigateToHomePage();
		// Verify whether Banner is displaying or not.
		Assert.assertTrue(forgotPassword.waitUntilInvisibleofForgotPasswordPageBanner(), "Banner is still existing.");
		//

		// Verify whether Home page is navigating or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Home Page-T1001:Display log in modal.
	 */
	@Test(description = "Home Page-T1001:Display log in modal.")
	public void verifyHomePage() {
		// Click on about us
		homePage.clickOnAboutUs();
		// Verify about us page
		homePage.isAboutUsPage();
		// Click on news
		homePage.clickOnNews();
		// Verify new page
		homePage.isNewsPage();
		// Click on jobs
		homePage.clickOnJobs();
		// Verify jobs page
		homePage.isJObsPage();
		// Click on Home Page
		homePage.navigateToHomePage();
		// Click on communities
		homePage.clickOnCommunities();
		// Verify communities
		homePage.isCommunityPage();
		// Navigate to home page
		homePage.navigateToHomePage();
		// Verifying whether navigating home page or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Login Page-T102: Test case to verify Login using email address via modal.
	 * And Login page-T1004: Login using email address via Log in page
	 */
	@Test(description = "Login Page-T102:  Test case to verify Login using email address via modal And Login page-T1004: Login using email address via Log in page.")
	public void verifyLoginUsingEmailAddressViaModel() {
		// Click on login link.
		loginPage.clickOnLogin();
		// Verify Login page appeared.
		Assert.assertTrue(loginPage.isEmailTextFieldVisible(), "Email texfield doesn't existed.");
		// Set User name.
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set Password.
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		// click on submit button.
		loginPage.clickOnSubmit();
		// Verify the news feed should appear
		Assert.assertTrue(newsFeedPage.isNewsfeedDisplay(), "Newsfeed is not appearing.");
		// Verify the login modal should disappear.
		Assert.assertFalse(loginPage.isEmailTextFieldVisible(), "Email texfield existed.");
		// Click on user profile
		newsFeedPage.clickOnUserProfile();
		// Click on logout
		newsFeedPage.clickOnLogout();
		// Verifying whether navigating home page or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Login Page-T1019:log out and redirect to index page.
	 */
	@Test(description = "Login Page-T1019:log out and redirect to index page.")
	public void verifyLogout() {
		// Click on login link
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set password
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		// Click on submit
		loginPage.clickOnSubmit();
		// Click on user profile
		newsFeedPage.clickOnUserProfile();
		// Click on logout
		newsFeedPage.clickOnLogout();
		// Verifying whether navigating home page or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Login Page-T1003: Wrong credentials.
	 *
	 * @throws InterruptedException
	 */
	@Test(description = "Login Page-T1003: Wrong credentials.")
	public void verifyWrongCredential() {
		// Click on login link
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set password
		loginPage.setPassWord(propertyUtil.getProperty("wrongPassword"));
		// Click on submit
		loginPage.clickOnSubmit();
		// Verifying the alert message should appear
		Assert.assertTrue(loginPage.isCredentialsAlertMessage(), "Credential alert message is not displaying.");
		// Verifying the model should present
		Assert.assertTrue(loginPage.isModelIsPresent(), "Model doesn't exist.");
		// Click on Login model close button
		loginPage.clickOnLoginModelCloseButtton();
	}
}
