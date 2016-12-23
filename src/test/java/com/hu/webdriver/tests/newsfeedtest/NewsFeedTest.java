package com.hu.webdriver.tests.newsfeedtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
public class NewsFeedTest extends BaseTest {
	/**
	 * Test logger
	 **/
	TestLogger logger = TestLogger.getLogger(NewsFeedTest.class);
	/**
	 * Instance variables for Login page
	 */
	LoginPage loginPage;
	/**
	 * Instance variable for News feed page.
	 */
	NewsFeedPage newsfeedPage;
	/**
	 * Instance variable for User profile page.
	 */
	UserProfilePage userprofilePage;

	@BeforeMethod
	public void setUp() {
		newsfeedPage = new NewsFeedPage(driver);
		loginPage = new LoginPage(driver);
		userprofilePage = new UserProfilePage(driver);
	}

	/**
	 * News feed Page-T1135:Delete user
	 */
	@Test(description = "Newsfeed Page-T1135:Delete user.")
	public void verifyDeleteUser() {
		logger.logTestStep("Click on Login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store User name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set User name."+userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password."+password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on Submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Click on User Profile");
		newsfeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Account Settings");
		newsfeedPage.clickOnAccountSettings();
		logger.logTestStep("Click on show Account Delete Button.");
		newsfeedPage.clickOnShowAccountDeleteButton();
		logger.logTestStep("Click on Settings Account Delete Button.");
		newsfeedPage.clickOnSettingsAccountDeleteButton();
		logger.logTestStep("Click on Account Delete Button.");
		newsfeedPage.clickOnAccountDeleteButton();
	}
}
