package com.hu.webdriver.tests.newsfeedtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.userprofilepage.UserProfilePage;
import com.hu.webdriver.tests.BaseTest;

public class NewsFeedTest extends BaseTest{

	NewsFeedPage newsfeedpage;
	LoginPage loginpage;
	UserProfilePage userprofilepage;
	
	@BeforeMethod
	public void initializingClassReferencess(){
		newsfeedpage = new NewsFeedPage(driver);
		loginpage = new LoginPage(driver);
		userprofilepage = new UserProfilePage(driver);
		
		loginpage.clickOnLogin();
		loginpage.setUserName("shivaprasadnamani2016@gmail.com");
		loginpage.setPassWord("shivaprasad9");
		loginpage.clickOnSubmit();
		
		
	}

	/**
	 * News feed Page-T1135:Delete user
	 */
	@Test(description = "Newsfeed Page-T1135:Delete user")
	public void deleteUser(){
		// Click on User Profile
		userprofilepage.clickOnUserProfile();
		// Click on Account Settings
		newsfeedpage.clickOnAccountSettings();
		// Click on i want to delete my account
		newsfeedpage.clickOnIWantToDeleteMyAccount();
		//
		newsfeedpage.clickOnDeleteAccountButton();
		//
		
		
	}

	
}
