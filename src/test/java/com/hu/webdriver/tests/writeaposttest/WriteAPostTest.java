package com.hu.webdriver.tests.writeaposttest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.join.JoinPage;
import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.message.MessagePage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.writeapostpage.WriteAPostPage;
import com.hu.webdriver.tests.BaseTest;
import com.hu.webdriver.util.TestLogger;

public class WriteAPostTest extends BaseTest{

	/**
	 * Instance variable for Join page.
	 */
	JoinPage joinPage;
	/**
	 * Instance variable for Test logger.
	 */
	TestLogger logger = TestLogger.getLogger("ProfilePageTest.class");
	/**
	 * Instance variable for Login page.
	 */
	LoginPage loginPage;
	/**
	 * Instance variable for Message page.
	 */
	MessagePage messagePage;
	/**
	 * Instance variable for Newsfeed Page.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variable for WriteAPost page.
	 */
	WriteAPostPage writeAPostPage;

	@BeforeClass
	public void setup(){
		loginPage = new LoginPage(driver);
		messagePage = new MessagePage(driver);
		joinPage = new JoinPage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		writeAPostPage = new WriteAPostPage(driver);

		logger.logTestStep("Click on Login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store user name.");
		final String userName = propertyUtil.getProperty("userId");
		logger.logTestStep("Set User name." + userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on Submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Click on My communities.");
		messagePage.clickOnMyCommunities();
		logger.logTestStep("Click on Browse community.");
		joinPage.clickOnBrowseCommunity();
		logger.logTestStep("Click on Follow community.");
		joinPage.clickOnFollowCommunity();
	}

	/**
	 * WriteAPostTest:@T6003-Access edit page.
	 */
	@Test(description = "WriteAPostTest:@T6003-Access edit page.")
	public void verifyAccessEditPost(){

		messagePage.clickOnMyCommunities();
		final String communityText = writeAPostPage.getCommunityText();
		writeAPostPage.waitUntilInvisibleOfBanner();
		writeAPostPage.clickOnCommunity(communityText);
		writeAPostPage.clickOnWriteAPostButton();


		final boolean isCommunityPostPageDisplayed =  writeAPostPage.isCommunityPostPageDisplayed(communityText);
		Assert.assertTrue(isCommunityPostPageDisplayed);
		final String text = RandomStringUtils.randomAlphanumeric(8);
		//final String postTitle = propertyUtil.getProperty("postTitle");
		writeAPostPage.setPostTitle(text);

		//final String postBody = propertyUtil.getProperty("postBody");
		writeAPostPage.setPostBody(text);

		writeAPostPage.clickOnPostButton();

		final boolean isWriteAPostDisplayed = writeAPostPage.isWriteAPostDisplayed();
		Assert.assertTrue(isWriteAPostDisplayed);

		writeAPostPage.clickOnPostOptionsButton();

		writeAPostPage.clickOnEditPost();

		//final String postNewBody = propertyUtil.getProperty("postNewBody");
		writeAPostPage.setPostBody(text);

		writeAPostPage.clickOnPostButton();

		Assert.assertTrue(isWriteAPostDisplayed);

		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();


	}

	/**
	 *WriteAPostTest:@T6005-Check my new post on community posts page.
	 */
	@Test(description = "WriteAPostTest:@T6005-Check my new post on community posts page.")
	public void verifyCheckMyNewPostOnCommunityPosts(){
		messagePage.clickOnMyCommunities();
		final String communityText = writeAPostPage.getCommunityText();
		writeAPostPage.waitUntilInvisibleOfBanner();
		writeAPostPage.clickOnCommunity(communityText);
		writeAPostPage.clickOnWriteAPostButton();


		final boolean isCommunityPostPageDisplayed =  writeAPostPage.isCommunityPostPageDisplayed(communityText);
		Assert.assertTrue(isCommunityPostPageDisplayed);
		final String text = RandomStringUtils.randomAlphanumeric(8);
		//final String postTitle = propertyUtil.getProperty("postTitle");
		writeAPostPage.setPostTitle(text);

		//final String postBody = propertyUtil.getProperty("postBody");
		writeAPostPage.setPostBody(text);

		writeAPostPage.clickOnPostButton();

		final boolean isWriteAPostDisplayed = writeAPostPage.isWriteAPostDisplayed();
		Assert.assertTrue(isWriteAPostDisplayed);

		final boolean isPostDisplayed = writeAPostPage.isPostDisplayed(text);
		Assert.assertTrue(isPostDisplayed);

		writeAPostPage.clickOnPostOptionsButton();

		writeAPostPage.clickOnDeletePost();

		writeAPostPage.clickOnDeleteConfirmationButton();

		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();

	}

	/**
	 * WriteAPostTest:@T6011-Delete my post.
	 */
	@Test(description = "WriteAPostTest:@T6011-Delete my post.")
	public void verifyDeleteMyPost(){

		messagePage.clickOnMyCommunities();
		final String communityText = writeAPostPage.getCommunityText();
		writeAPostPage.waitUntilInvisibleOfBanner();
		writeAPostPage.clickOnCommunity(communityText);
		writeAPostPage.clickOnWriteAPostButton();


		final boolean isCommunityPostPageDisplayed =  writeAPostPage.isCommunityPostPageDisplayed(communityText);
		Assert.assertTrue(isCommunityPostPageDisplayed);
		final String text = RandomStringUtils.randomAlphanumeric(8);
		//final String postTitle = propertyUtil.getProperty("postTitle");
		writeAPostPage.setPostTitle(text);

		//final String postBody = propertyUtil.getProperty("postBody");
		writeAPostPage.setPostBody(text);

		writeAPostPage.clickOnPostButton();

		final boolean isWriteAPostDisplayed = writeAPostPage.isWriteAPostDisplayed();
		Assert.assertTrue(isWriteAPostDisplayed);

		final boolean isPostDisplayed = writeAPostPage.isPostDisplayed(text);
		Assert.assertTrue(isPostDisplayed);

		writeAPostPage.clickOnPostOptionsButton();

		writeAPostPage.clickOnDeletePost();

		writeAPostPage.clickOnDeleteConfirmationButton();

		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();

	}

	/**
	 * WriteAPostTest:T6002-Post from community posts page.
	 */
	@Test(description = "WriteAPostTest:T6002-Post from community posts page.")
	public void verifyPostAMessageFromCommunityPage(){
		messagePage.clickOnMyCommunities();
		final String communityText = writeAPostPage.getCommunityText();
		writeAPostPage.waitUntilInvisibleOfBanner();
		writeAPostPage.clickOnCommunity(communityText);
		writeAPostPage.clickOnWriteAPostButton();



		final boolean isCommunityPostPageDisplayed =  writeAPostPage.isCommunityPostPageDisplayed(communityText);
		Assert.assertTrue(isCommunityPostPageDisplayed);

		final String text = RandomStringUtils.randomAlphanumeric(8);
		//final String postTitle = propertyUtil.getProperty("postTitle");
		writeAPostPage.setPostTitle(text);

		//final String postBody = propertyUtil.getProperty("postBody");
		writeAPostPage.setPostBody(text);

		writeAPostPage.clickOnPostButton();

		final boolean isWriteAPostDisplayed = writeAPostPage.isWriteAPostDisplayed();
		Assert.assertTrue(isWriteAPostDisplayed);

		writeAPostPage.clickOnPostOptionsButton();

		writeAPostPage.clickOnDeletePost();

		writeAPostPage.clickOnDeleteConfirmationButton();

		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();

	}

	/**
	 * WriteAPostTest:@T6001-Access or write page from a community I’m following.
	 */
	@Test(description = "WriteAPostTest:@T6001-Access or write page from a community I’m following.")
	public void verifyWriteAPostFromCommunityPage(){
		messagePage.clickOnMyCommunities();
		final String communityText = writeAPostPage.getCommunityText();
		writeAPostPage.waitUntilInvisibleOfBanner();
		writeAPostPage.clickOnCommunity(communityText);
		writeAPostPage.clickOnWriteAPostButton();

		final boolean isCommunityPostPageDisplayed =  writeAPostPage.isCommunityPostPageDisplayed(communityText);
		Assert.assertTrue(isCommunityPostPageDisplayed);

		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();

	}

}
