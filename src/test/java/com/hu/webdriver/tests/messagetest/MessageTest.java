package com.hu.webdriver.tests.messagetest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.home.HomePage;
import com.hu.webdriver.pages.join.JoinPage;
import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.message.Compose;
import com.hu.webdriver.pages.message.MessagePage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.profilepage.ProfilePage;
import com.hu.webdriver.tests.BaseTest;
import com.hu.webdriver.util.TestLogger;

/**
 *
 * @author SHIVA
 *
 */
public class MessageTest extends BaseTest {
	/**
	 * Instance variable for Compose page.
	 */
	Compose compose;
	/**
	 * Instance variable for Home page.
	 */
	HomePage homePage;
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
	 * Instance variable for News feed page.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variable for Profile page.
	 */
	ProfilePage profilePage;

	@BeforeMethod
	private void followCommunities() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
	}

	@AfterMethod
	public void navigateToMessagePage() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
	}

	@BeforeClass
	public void setUpLogin() {
		loginPage = new LoginPage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		messagePage = new MessagePage(driver);
		compose = new Compose(driver);
		profilePage = new ProfilePage(driver);
		homePage = new HomePage(driver);
		joinPage = new JoinPage(driver);

		logger.logTestStep("Click on Login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store user name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set User name." + userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on Submit.");
		loginPage.clickOnSubmit();

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();

		messagePage.clickOnSelectAll();
		messagePage.clickOnDeleteMessage();

		messagePage.clickOnMyCommunities();
		logger.logTestStep("Click on Browse community.");
		joinPage.clickOnBrowseCommunity();
		logger.logTestStep("Click on Follow community.");
		joinPage.clickOnFollowCommunity();



	}

	@AfterClass
	private void unfollowCommunities() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
		logger.logTestStep("Click on My community.");
		messagePage.clickOnMyCommunities();
		logger.logTestStep("Click on Browse community.");
		joinPage.clickOnBrowseCommunity();
		logger.logTestStep("Un follow Communities.");
		joinPage.unfollowCommunities();
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
		logger.logTestStep("Click on select all.");
		//messagePage.clickOnSelectAll();
		logger.logTestStep("Click on Delete message.");
		//messagePage.clickOnDeleteMessage();
	}

	/**
	 * MessageTest-T323:Add Recipients.
	 */
	@Test(description = "MessageTest-T323:Add Recipients.")
	public void verifyAddRecipients() {
		logger.logTestStep("Click on Compose.");
		messagePage.clickOnCompose();
		logger.logTestStep("Store User name.");
		final String userNameText = propertyUtil.getProperty("userNameText");
		logger.logTestStep("Set User name text." + userNameText);
		compose.setUserNameText(userNameText);
		logger.logTestStep("Set User name text." + userNameText);
		compose.setUserNameText("" + Keys.ENTER);
		logger.logTestStep("Check is Tes Displayed.");
		final boolean isTesDisplayed = compose.isTesDisplayed();
		logger.logTestVerificationStep("Verify wheher Tes displayed." + isTesDisplayed);
		Assert.assertTrue(isTesDisplayed, "Tes is not displayed.");
		logger.logTestStep("Clear text area.");
		compose.clearTextArea();
		logger.logTestStep("Store User name text Ban.");
		final String userNametextBan = propertyUtil.getProperty("userNameTextban");
		logger.logTestStep("Set name text Ban." + userNametextBan);
		compose.setUserNameText(userNametextBan);
		logger.logTestStep("Set name text Ban and Enter.");
		compose.setUserNameText("" + Keys.ENTER);
		logger.logTestStep("Check whether Ban user displayed.");
		final boolean isBanDisplayed = compose.isBanDisplayed();
		logger.logTestVerificationStep("Verify whether Ban is displayed." + isBanDisplayed);
		Assert.assertTrue(isBanDisplayed, "Ban is not displayed.");
	}

	/**
	 * MessageTest:@T3305-At least one recipient is required.
	 */
	@Test(description = "MessageTest:@T3305-At least one recipient is required.")
	public void verifyAtLeastOneRecipientIsRequired() {
		logger.logTestStep("Click on Compose.");
		messagePage.clickOnCompose();
		logger.logTestStep("Store Message body.");
		final String messageBody = propertyUtil.getProperty("messageBody");
		logger.logTestStep("Set message body." + messageBody);
		compose.setMessageBody(messageBody);
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();
		logger.logTestStep("Check is Message validation displayed.");
		final boolean isMessageValidationDisplayed = compose.isMessageValidationDisplayed();
		logger.logTestVerificationStep("Verify whether Message validation displayed." + isMessageValidationDisplayed);
		Assert.assertTrue(isMessageValidationDisplayed, "Message validation is not displayed.");
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();

		logger.logTestStep("Wait until alert present.");
		compose.waitUntilAlertPresent();
		logger.logTestStep("Driver switch to Alert.");
		final Alert confirmationAlert = driver.switchTo().alert();
		logger.logTestStep("Driver accept alert.");
		confirmationAlert.accept();
	}

	/**
	 * MessageTest:@T3308-Clicking several times on Send message.
	 */
	@Test(description = "MessageTest:@T3308-Clicking several times on Send message.")
	public void verifyClickingSeveralTimesOnSendMessage() {
		logger.logTestStep("Click on ");
		messagePage.clickOnCompose();
		logger.logTestStep("Store User name text bana.");
		final String userNameTextbana = propertyUtil.getProperty("userNameTextbana");
		logger.logTestStep("Set usre name text." + userNameTextbana);
		compose.setUserNameText(userNameTextbana);
		logger.logTestStep("Driver wait.");
		messagePage.sleep(4);
		logger.logTestStep("Set user name text.");
		compose.setUserNameText("" + Keys.ENTER);

		logger.logTestStep("Check whether Ban displayed.");
		final boolean isBanDisplayed = compose.isBanDisplayed();
		logger.logTestVerificationStep("Verify whether Ban displayed." + isBanDisplayed);
		Assert.assertTrue(isBanDisplayed, "Ban is not Displayed.");

		logger.logTestStep("Store Message body.");
		final String messageBody = propertyUtil.getProperty("messageBody");
		logger.logTestStep("Set Message body." + messageBody);
		compose.setMessageBody(messageBody);
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();

		logger.logTestStep("Check whether Mark as read displayed.");
		final boolean isMarkAsReadDisplayed = messagePage.isMarkAsReadEnabled();
		logger.logTestVerificationStep("Verify whether Mark as read button displayed." + isMarkAsReadDisplayed);
		Assert.assertFalse(isMarkAsReadDisplayed, "Mark as read button not displayed.");
	}

	/**
	 * MessageTest:@T3307-Empty message.
	 */
	@Test(description = "MessageTest:@T3307-Empty message.")
	public void verifyEmptyMessage() {
		logger.logTestStep("Click on Compose.");
		messagePage.clickOnCompose();
		logger.logTestStep("Store User name text.");
		final String userNameText = propertyUtil.getProperty("userNameText");
		logger.logTestStep("Set User name text." + userNameText);
		compose.setUserNameText(userNameText);
		logger.logTestStep("Set User name text and Enter.");
		compose.setUserNameText("" + Keys.ENTER);

		logger.logTestStep("Check whether Tes displayed.");
		final boolean isTesDisplayed = compose.isTesDisplayed();
		logger.logTestVerificationStep("Verify whether Tes displayed." + isTesDisplayed);
		Assert.assertTrue(isTesDisplayed, "Tes is not displayed.");
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();

		logger.logTestStep("Check whether body validation displayed.");
		final boolean isBodyValidationDisplayed = compose.isBodyValidationDisplayed();
		logger.logTestVerificationStep("Verify whetehr body validation displayed." + isBodyValidationDisplayed);
		Assert.assertTrue(isBodyValidationDisplayed, "Body validation not displayed.");
	}

	/**
	 * MessageTest:@T3210-Replaying to a message.
	 */
	@Test(description = "MessageTest:@T3210-Replaying to a message.")
	public void verifyReplayingToTheMessage() {
		logger.logTestStep("Click on Mail.");
		messagePage.clickOnMail();
		logger.logTestStep("Store Message text.");
		final String messageText = propertyUtil.getProperty("messageText");
		logger.logTestStep("Set message text box." + messageText);
		messagePage.setMessageTextBox(messageText);
		logger.logTestStep("Click on send message.");
		compose.clickOnSendMessage();
		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
		logger.logTestStep("Wait until alert present.");
		final boolean isAlertPresent = compose.waitUntilAlertPresent();
		if(isAlertPresent){
			logger.logTestStep("Driver accept alert.");
			messagePage.handleAlert(true);
		}

		logger.logTestStep("Check whether Replay mail displayed.");
		final boolean isMailTitleDisplayed = messagePage.isMailTitleDisplayed();
		logger.logTestVerificationStep("Verify whether Replay mail displayed." + isMailTitleDisplayed);
		Assert.assertTrue(isMailTitleDisplayed, "Replay mail not displayed.");
	}

	/**
	 * MessageTest:@T334-Send Message.
	 */
	@Test(description = " MessageTest:@T334-Send Message.")
	public void verifySendMessage() {
		logger.logTestStep("Click on Compose.");
		messagePage.clickOnCompose();
		logger.logTestStep("Store User name text.");
		final String userNameText = propertyUtil.getProperty("userNameText");
		logger.logTestStep("Set User name text." + userNameText);
		compose.setUserNameText(userNameText);
		logger.logTestStep("Set User name text and eenter.");
		compose.setUserNameText("" + Keys.ENTER);

		logger.logTestStep("Check whether Tes displayed.");
		final boolean isTesDisplayed = compose.isTesDisplayed();
		logger.logTestStep("Verify whether Tes displayed." + isTesDisplayed);
		Assert.assertTrue(isTesDisplayed, "Tes not displayed.");
		logger.logTestStep("store Message body.");
		final String messageBody = propertyUtil.getProperty("messageBody");
		logger.logTestStep("Set Message body." + messageBody);
		compose.setMessageBody(messageBody);
		logger.logTestStep("Click on send.");
		compose.clickOnSend();

		logger.logTestStep("Check whether Send banner displayed.");
		final boolean isSendBannerDisplayed = compose.isSentBannerDisplayed();
		logger.logTestVerificationStep("Verify whether Send banner displayed." + isSendBannerDisplayed);
		Assert.assertTrue(isSendBannerDisplayed, "Send banner not displayed.");
	}

	/**
	 * MessageTest:@T3309-Send message from user profile.
	 */
	@Test(description = "MessageTest:@T3309-Send message from user profile.")
	public void verifySendMessageFromUserProfile() {
		logger.logTestStep("Driver wait.");
		messagePage.sleep(2);
		logger.logTestStep("Navigate to User profile.");
		newsFeedPage.navigateToUserProfile();
		logger.logTestStep("Click on Message.");
		profilePage.clickOnMessage();

		logger.logTestStep("Store Expected url.");
		final String expectedUrl = "https://healthunlocked.com/messages/compose/pesho";
		logger.logTestStep("Store Actual url.");
		final String actualUrl = driver.getCurrentUrl();
		logger.logTestVerificationStep("Verify whether url's are Equal." + actualUrl + "" + expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "We are not in expected page.");
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();
	}

	/**
	 * MessageTest:@T326-Undo.
	 */
	@Test(description = "MessageTest:@T326-Undo.")
	public void verifyTheUndo() {
		logger.logTestStep("Click on Select message.");
		messagePage.clickOnSelectMessage();
		logger.logTestStep("Store mail text.");
		final String mailText = messagePage.getMailText();

		logger.logTestStep("Click on Delete message.");
		messagePage.clickOnDeleteMessage();
		logger.logTestStep("Click on Undo.");
		messagePage.clickOnUndo();

		logger.logTestStep("Check whether Mail text displayed.");
		final boolean isMailTextDisplayed = messagePage.isMailTextDisplayed(mailText);
		logger.logTestVerificationStep("Verify whether Mail text displayed." + isMailTextDisplayed);
		Assert.assertTrue(isMailTextDisplayed, "Mail text is not displayed.");
		driver.navigate().refresh();
	}

	/**
	 * MessageTest:@T325-Message Deleted.
	 */
	@Test(description = "MessageTest:@T325-Message Deleted.")
	public void verifyToMessageDeleted() {
		logger.logTestStep("Click on select Message.");
		messagePage.clickOnSelectMessage();
		logger.logTestStep("Click on Delete message.");
		messagePage.clickOnDeleteMessage();

		logger.logTestStep("Check whether Undo displayed.");
		final boolean isUndoDisplayed = messagePage.isUndoDisplayed();
		logger.logTestVerificationStep("Verify whether Undo displayed." + isUndoDisplayed);
		Assert.assertTrue(isUndoDisplayed, "Undo is not displayed.");

		logger.logTestStep("Store Expected url.");
		final String expectedUrl = "https://healthunlocked.com/messages";
		logger.logTestStep("Store Actual url.");
		final String actualUrl = messagePage.currentPageUrl();
		logger.logTestStep("Verify whether url's are Equal." + actualUrl + "" + expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "We are not in expected page.");
	}

	/**
	 * MessageTest:@T333-User Removed from Message.
	 */
	@Test(description = "MessageTest:@T333-User Remove from Message.")
	public void verifyUserRemoveFromMessage() {
		logger.logTestStep("Click on Compose.");
		messagePage.clickOnCompose();
		logger.logTestStep("Store User name text.");
		final String userNameText = propertyUtil.getProperty("userNameText");
		logger.logTestStep("Set User name text." + userNameText);
		compose.setUserNameText(userNameText);
		logger.logTestStep("set User name text and Enter.");
		compose.setUserNameText("" + Keys.ENTER);

		logger.logTestStep("Check whether Tes displayed.");
		boolean isTesDisplayed = compose.isTesDisplayed();
		logger.logTestVerificationStep("Verify whether Tes user displayed." + isTesDisplayed);
		Assert.assertTrue(isTesDisplayed, "Tes not displayed.");

		logger.logTestStep("Click on Recipient close.");
		compose.clickOnRecipientClose();

		logger.logTestStep("Check whether Tes displayed.");
		isTesDisplayed = compose.isTesDisplayed();
		logger.logTestVerificationStep("Verify whether Tes user displayed." + isTesDisplayed);
		Assert.assertFalse(isTesDisplayed, "Tes not displayed.");
	}
}
