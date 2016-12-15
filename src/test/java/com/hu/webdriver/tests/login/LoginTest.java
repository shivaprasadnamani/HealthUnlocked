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
	 * Instance variables
	 */
	ForgotPassword forgotPassword;
	HomePage homePage;
	JoinPage joinPage;
	LoginPage loginPage;
	NewsFeedPage newsFeedPage;
	UserProfilePage userProfilePage;

	/**
	 * Login Page-T108: Enter email in forgot password page And Login.
	 * Page-T1011: Access forgot your password page from log in.
	 */
	@Test(description = "Login Page-T108: Enter email in forgot password page And Login Page-T1011: Access forgot your password page from log in.")
	public void enteringEmailinForgotPasswordPage() {
		// Click on login link
		loginPage.clickOnLogin();
		// Click on forgot password link
		loginPage.clickOnForgotPassword();
		// Verifying the reset page header should display
		Assert.assertTrue(forgotPassword.verifyResetPageHeader(), "Page header is not displaying.");
		// Set reset email
		forgotPassword.setResetEmail(propertyUtil.getProperty("userName"));
		// click on submit button
		forgotPassword.clickOnSubmitButton();
		// Verifying the alert should present
		Assert.assertTrue(forgotPassword.verifyAlert(), "Alert is not presenting.");
		// Verify whether Banner is displaying or not.
		Assert.assertTrue(forgotPassword.waitUntilInvisibleofBannerMessage(), "Banner is still existing.");
		// Click on Health unlocked
		forgotPassword.navigateToHomePage();
	}

	/**
	 * Login Page-T1019:log out and redirect to index page.
	 */
	@Test(description = "Login Page-T1019:log out and redirect to index page.")
	public void logout() {
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
		// Verifying home page
		Assert.assertTrue(homePage.verifyHomePage(), "Not redirected to home page.");
	}

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
	 * Home Page-T1001:Display log in modal.
	 */
	@Test(description = "Home Page-T1001:Display log in modal.")
	public void verifyHomePage() {
		// Click on about us
		homePage.clickOnAboutUs();
		// Verify about us page
		homePage.verifyAboutUsPage();
		// Click on news
		homePage.clickOnNews();
		// Verify new page
		homePage.verifyNewsPage();
		// Click on jobs
		homePage.clickOnJobs();
		// Verify jobs page
		homePage.verifyJObsPage();
		// Click on Home Page
		homePage.clickOnHomePage();
		// Click on communities
		homePage.clickOnCommunities();
		// Verify communities
		homePage.verifyCommunityPage();
		// Click on home page
		homePage.clickOnHomePage();
		// Click on about us
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
		Assert.assertTrue(newsFeedPage.newsfeeddisplay(), "Newsfeed is not appearing.");
		// Verify the login modal should disappear.
		Assert.assertFalse(loginPage.isEmailTextFieldVisible(), "Email texfield existed.");
		// Click on user profile
		newsFeedPage.clickOnUserProfile();
		// Click on logout
		newsFeedPage.clickOnLogout();
	}

	/**
	 * Login Page-T1003: Wrong credentials.
	 *
	 * @throws InterruptedException
	 */
	@Test(description = "Login Page-T1003: Wrong credentials.")
	public void wrongCredential() {
		// Click on login link
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set password
		loginPage.setPassWord(propertyUtil.getProperty("wrongPassword"));
		// Click on submit
		loginPage.clickOnSubmit();
		// Verifying the alert message should appear
		Assert.assertTrue(loginPage.verifyCredentialsAlertMessage(), "Credential alert message is not displaying.");
		// Verifying the model should present
		Assert.assertTrue(loginPage.verifyModelIsPresent(), "Model doesn't exist.");
		// Click on Login model close button
		loginPage.clickOnLoginModelCloseButtton();
	}
}
