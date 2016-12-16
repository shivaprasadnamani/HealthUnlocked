package com.hu.webdriver.tests.newsfeedtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.userprofilepage.UserProfilePage;
import com.hu.webdriver.tests.BaseTest;

/**
 *
 * @author SHIVA
 *
 */
public class NewsFeedTest extends BaseTest {
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
		loginPage.clickOnLogin();
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		loginPage.clickOnSubmit();
	}

	/**
	 * News feed Page-T1135:Delete user
	 */
	@Test(description = "Newsfeed Page-T1135:Delete user.")
	public void verifyDeleteUser() {
		// Click on User Profile
		newsfeedPage.clickOnUserProfile();
		// Click on Account Settings
		newsfeedPage.clickOnAccountSettings();
		// Click on show Account Delete Button
		newsfeedPage.clickOnShowAccountDeleteButton();
		// Click on Settings Account Delete Button
		newsfeedPage.clickOnSettingsAccountDeleteButton();
		// Click on Account Delete Button
		newsfeedPage.clickOnAccountDeleteButton();
	}

}
