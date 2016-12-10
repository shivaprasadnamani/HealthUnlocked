package com.hu.webdriver.tests.join;

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
		// Get join page
		joinPage.getJoinPage();
		// Click on follow button
		joinPage.clickOnFollowButton();
		// Verify community icon
		joinPage.verifyCommunityIcon();
		// Get home page
		joinPage.getHomePage();
		// Click on user profile
		userProfilePage.clickOnUserProfile();
		// Click on Logout
		userProfilePage.clickOnLogout();
	}

}
