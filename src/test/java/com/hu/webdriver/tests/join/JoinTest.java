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
		// Get join page
		joinPage.navigateToJoinPage();
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
	
	/**
	 *  Join Page-T1125: Un follow a community I just followed on join page
	 */
	@Test(description = " Join Page-T1125:Unfollow a community I just followed on join page")
	public void verifyFollowCommunity(){	
		//
		loginPage.clickOnLogin();
		//
		loginPage.setUserName("shivaprasadnamani2016@gmail.com");
		//
		loginPage.setPassWord("shivaprasad9");
		//
		loginPage.clickOnSubmit();
		//
		joinPage.navigateToJoinPage();
		
		//
		String communityText = joinPage.getCommunityTitle();
		
		//
		joinPage.clickOnFollowButton();
		
		Assert.assertTrue(joinPage.isFollowedCommunityDisplayed(communityText));
		
		//
		joinPage.clickonCloseButton();
		
		//
		Assert.assertFalse(joinPage.isFollowedCommunityDisplayed(communityText));
		//
		joinPage.getHomePage();
		//
		userProfilePage.clickOnUserProfile();
		//
		userProfilePage.clickOnLogout();
	}
	/**
	 * JoinTest-T1127:Finish registration process
	 */
	@Test(description = "JoinTest-T1127:Finish registration process")
	public void finishRegistrationProcess(){
		//Click on login
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
		// Verify whether news feed alert header is displating or not
		Assert.assertTrue(joinPage.verifyNewsfeedAlertHeader(userName));
	}

	
}
