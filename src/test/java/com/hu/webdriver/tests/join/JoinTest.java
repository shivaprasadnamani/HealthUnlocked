package com.hu.webdriver.tests.join;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.BasePage;
import com.hu.webdriver.pages.home.HomePage;
import com.hu.webdriver.pages.join.JoinPage;
import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.userprofilepage.UserProfilePage;
import com.hu.webdriver.tests.BaseTest;

/**
 * 
 * @author SHIVA
 *
 */
public class JoinTest extends BaseTest {
	/**
	 * Declaring references for classes
	 */
	JoinPage joinPage;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	UserProfilePage userProfilePage;

	/**
	 * Before method to initializing the pages references
	 */
	@BeforeMethod
	public void intializingForClassReferences() {
		joinPage = new JoinPage(driver);
		basePage = new BasePage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		userProfilePage = new UserProfilePage(driver);
		driver.get("https://healthunlocked.com/");

	}

	/**
	 * Join Page-T123:Follow a community on join page
	 */
	@Test(description = "Join Page-T123:Follow a community on join page")
	public void followCommunityInJoinPage() {
		// Click on login
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName("shivaprasadnamani2016@gmail.com");
		// Set Password
		loginPage.setPassWord("shivaprasad9");
		// Click on submit
		loginPage.clickOnSubmit();
		// Navigate to join page
		joinPage.navigateToJoinPage();
		// Click on follow button
		joinPage.clickOnFollowButton();
		// Verify community icon
		joinPage.verifyCommunityIcon();
		// Navigate to home page
		joinPage.navigateToHomePage();
		// Click on user profile
		userProfilePage.clickOnUserProfile();
		// Click on Logout
		userProfilePage.clickOnLogout();
	}

	/**
	 * Join Page-T1125: Un follow a community I just followed on join page
	 */
	@Test(description = " Join Page-T1125:Unfollow a community I just followed on join page")
	public void verifyFollowCommunity() {
		// Click on login
		loginPage.clickOnLogin();
		// Set User name
		loginPage.setUserName("shivaprasadnamani2016@gmail.com");
		// Set Password
		loginPage.setPassWord("shivaprasad9");
		// Click on Submit
		loginPage.clickOnSubmit();
		// Navigate to Join page
		joinPage.navigateToJoinPage();
		// Get Community text
		String communityText = joinPage.getCommunityTitle();
		// Click on Follow button
		joinPage.clickOnFollowButton();
		// Verifying whether followed community displayed or not
		Assert.assertTrue(joinPage.isFollowedCommunityDisplayed(communityText));
		// Click on close button
		joinPage.clickonCloseButton();
		// Verifying whether followed community displayed or not
		Assert.assertFalse(joinPage.isFollowedCommunityDisplayed(communityText));
		// Navigate to Home page
		joinPage.navigateToHomePage();
		// Click on User profile
		userProfilePage.clickOnUserProfile();
		// Click on Logout
		userProfilePage.clickOnLogout();
	}

	/**
	 * JoinTest-T1127:Finish registration process
	 */
	@Test(description = "JoinTest-T1127:Finish registration process")
	public void verifyFinishRegistrationProcess() {
		// Click on login
		loginPage.clickOnLogin();
		// Set user name
		loginPage.setUserName("shivaprasadnamani2016@gmail.com");
		// Set password
		loginPage.setPassWord("shivaprasad9");
		// Click on submit
		loginPage.clickOnSubmit();
		// Navigate to join page
		joinPage.navigateToJoinPage();
		// Click on follow button
		joinPage.clickOnFollowButton();
		// click on finish button
		joinPage.clickOnFinishButton();
		// Store User Name in to string
		String userName = joinPage.getUserName();
		// Verify whether news feed alert header is displayed or not
		Assert.assertTrue(joinPage.verifyNewsfeedAlertHeader(userName));
	}

}
