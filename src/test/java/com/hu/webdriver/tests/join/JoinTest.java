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
import com.hu.webdriver.util.TestLogger;

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
	 * Test Logger.
	 */
	TestLogger logger = TestLogger.getLogger(JoinTest.class);
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
		logger.logTestStep("Click on login");
		loginPage.clickOnLogin();

		logger.logTestStep("Store user name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set UserName: "+userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set password: "+password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep(" Navigate to join page.");
		joinPage.navigateToJoinPage();
		logger.logTestStep("Search for Community.");
		joinPage.searcCommunity();
		logger.logTestStep("Click on follow button.");
		joinPage.clickOnFollowButton();
		joinPage.sleep(1);
		//driver.findElement(By.cssSelector(".btn-block")).click();
		logger.logTestStep("Click on finish button.");
		joinPage.clickOnFinishButton();

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();

		logger.logTestStep("Check whether home page is displayed or not.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verify Home page is displayed: "+isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Join Page-T1125: Un follow a community I just followed on join page.
	 */
	@Test(description = " Join Page-T1125:Unfollow a community I just followed on join page.")
	public void verifyFollowCommunity() {
		logger.logTestStep("Click on login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store User name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set User name." +userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set password."+password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on Submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Navigate to Join page.");
		joinPage.navigateToJoinPage();
		logger.logTestStep("Search for Community.");
		joinPage.searcCommunity();
		logger.logTestStep("Get Community text.");
		final String communityText = joinPage.getCommunityTitle();
		logger.logTestStep("Click on Follow button.");
		joinPage.clickOnFollowButton();

		logger.logTestStep("Check whether followed community displayed or not.");
		boolean isFollowedCommunityDisplayed = joinPage.isFollowedCommunityDisplayed(communityText);
		logger.logTestVerificationStep("Verifying whether followed community displayed or not."+isFollowedCommunityDisplayed);
		Assert.assertTrue(isFollowedCommunityDisplayed, "Followed community not displaying.");

		logger.logTestStep("Click on close button.");
		joinPage.clickonCloseButton();

		logger.logTestStep("Verifying whether followed community displayed or not.");
		isFollowedCommunityDisplayed = joinPage.isFollowedCommunityDisplayed(communityText);
		logger.logTestVerificationStep("Verifying whether followed community displayed or not."+isFollowedCommunityDisplayed);
		Assert.assertFalse(isFollowedCommunityDisplayed, "Followed community displaying.");

		logger.logTestStep("Navigate to Home page");
		homePage.navigateToHomePage();
		logger.logTestStep("Click on User profile");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout");
		newsFeedPage.clickOnLogout();

		logger.logTestStep("Check whether Home page displaying or not.");
		final boolean isHomePageDisplayed = homePage.isHomePage();
		logger.logTestVerificationStep("Verify whether Home page is navigating or not."+isHomePageDisplayed);
		Assert.assertTrue(isHomePageDisplayed, "Not redirected to home page.");
	}

	/**
	 * Join Page-T123:Follow a community on join page.
	 */
	@Test(description = "Join Page-T123:Follow a community on join page.")
	public void verifyFollowCommunityInJoinPage() {
		logger.logTestStep("Click on login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store User name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set user name"+userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password"+password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Navigate to join page.");
		joinPage.navigateToJoinPage();
		logger.logTestStep("Search for Community.");
		joinPage.searcCommunity();
		logger.logTestStep("Click on follow button.");
		joinPage.clickOnFollowButton();

		logger.logTestStep("Check Community is Displayed.");
		final boolean isCommunityIconDisplaying = joinPage.isCommunityIcon();
		logger.logTestVerificationStep("Verify community icon" +isCommunityIconDisplaying);
		Assert.assertTrue(isCommunityIconDisplaying,"Community is not Displayed.");

		logger.logTestStep("Navigate to home page.");
		homePage.navigateToHomePage();
		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();

		logger.logTestStep("Verifying Home page is Displayed.");
		final boolean isHomePageDisplaying = homePage.isHomePage();
		logger.logTestVerificationStep("Verifying whether navigating to Home page or not."+isHomePageDisplaying);
		Assert.assertTrue(isHomePageDisplaying, "Not redirected to Home page.");
	}
}
