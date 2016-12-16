package com.hu.webdriver.tests.join;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
public class JoinTest extends BaseTest {
	/**
	 * Instance variable for Home page.
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
	public void setup() {
		joinPage = new JoinPage(driver);
		loginPage = new LoginPage(driver);
		userProfilePage = new UserProfilePage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * JoinTest-T1127:Finish registration process.
	 */
	@Test(description = "JoinTest-T1127:Finish registration process.")
	public void verifyFinishRegistrationProcess() {
		// Click on login
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set password
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		// Click on submit
		loginPage.clickOnSubmit();
		// Navigate to join page
		joinPage.navigateToJoinPage();
		// Search for Community
		joinPage.searcCommunity();
		// Click on follow button
		joinPage.clickOnFollowButton();
		// click on finish button
		joinPage.clickOnFinishButton();
		// Get user name
		newsFeedPage.getUserName();
		// Click on User profile
		newsFeedPage.clickOnUserProfile();
		// Click on Logout
		newsFeedPage.clickOnLogout();
		// Verify whether Home page is navigating or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Join Page-T1125: Un follow a community I just followed on join page.
	 */
	@Test(description = " Join Page-T1125:Unfollow a community I just followed on join page.")
	public void verifyFollowCommunity() {
		// Click on login
		loginPage.clickOnLogin();
		// Set User name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set Password
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		// Click on Submit
		loginPage.clickOnSubmit();
		// Navigate to Join page
		joinPage.navigateToJoinPage();
		// Search for Community
		joinPage.searcCommunity();
		// Get Community text
		final String communityText = joinPage.getCommunityTitle();
		// Click on Follow button
		joinPage.clickOnFollowButton();
		// Verifying whether followed community displayed or not
		Assert.assertTrue(joinPage.isFollowedCommunityDisplayed(communityText), "Followed community not displaying.");
		// Click on close button
		joinPage.clickonCloseButton();
		// Verifying whether followed community displayed or not
		Assert.assertFalse(joinPage.isFollowedCommunityDisplayed(communityText), "Followed community displaying.");
		// Navigate to Home page
		homePage.navigateToHomePage();
		// Click on User profile
		newsFeedPage.clickOnUserProfile();
		// Click on Logout
		newsFeedPage.clickOnLogout();
		// Verify whether Home page is navigating or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}

	/**
	 * Join Page-T123:Follow a community on join page.
	 */
	@Test(description = "Join Page-T123:Follow a community on join page.")
	public void verifyFollowCommunityInJoinPage() {
		// Click on login
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName(propertyUtil.getProperty("userName"));
		// Set Password
		loginPage.setPassWord(propertyUtil.getProperty("password"));
		// Click on submit
		loginPage.clickOnSubmit();
		// Navigate to join page
		joinPage.navigateToJoinPage();
		// Search for Community
		joinPage.searcCommunity();
		// Click on follow button
		joinPage.clickOnFollowButton();
		// Verify community icon
		joinPage.isCommunityIcon();
		// Navigate to home page
		homePage.navigateToHomePage();
		// Click on user profile
		newsFeedPage.clickOnUserProfile();
		// Click on Logout
		newsFeedPage.clickOnLogout();
		// Verifying whether navigating to Home page or not.
		Assert.assertTrue(homePage.isHomePage(), "Not redirected to home page.");
	}
}
