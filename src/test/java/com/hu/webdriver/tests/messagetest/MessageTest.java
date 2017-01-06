package com.hu.webdriver.tests.messagetest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.home.HomePage;
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
	public void setup() {

		loginPage = new LoginPage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		messagePage = new MessagePage(driver);
		compose = new Compose(driver);
		profilePage = new ProfilePage(driver);
		homePage = new HomePage(driver);

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
		Assert.assertTrue(isTesDisplayed);
		logger.logTestStep("Driver wait.");
		messagePage.sleep(2);
		logger.logTestStep("Store User name text Ban.");
		final String userNametextBan = propertyUtil.getProperty("userNameTextban");
		logger.logTestStep("Set name text Ban." + userNametextBan);
		compose.setUserNameText(userNametextBan);
		logger.logTestStep("Set name text Ban and Enter.");
		compose.setUserNameText("" + Keys.ENTER);
		final boolean isBanDisplayed = compose.isBanDisplayed();
		logger.logTestVerificationStep("Verify whether Ban is displayed." + isBanDisplayed);
		Assert.assertTrue(isBanDisplayed);
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
	}

	/**
	 * MessageTest:@T3305-At least one recipient is required.
	 *
	 * @throws InterruptedException
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
		Assert.assertTrue(isMessageValidationDisplayed);
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
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
		Assert.assertTrue(isBanDisplayed);

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
		final boolean isMarkAsReadDisplayed = messagePage.isMarkAsReadDisplayed();
		logger.logTestVerificationStep("Verify whether Mark as read displayed." + isMarkAsReadDisplayed);
		Assert.assertFalse(isMarkAsReadDisplayed);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
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
		Assert.assertTrue(isTesDisplayed);
		logger.logTestStep("Click on Send.");
		compose.clickOnSend();

		logger.logTestStep("Check whether body validation displayed.");
		final boolean isBodyValidationDisplayed = compose.isBodyValidationDisplayed();
		logger.logTestVerificationStep("Verify whetehr body validation displayed." + isBodyValidationDisplayed);
		Assert.assertTrue(isBodyValidationDisplayed);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
	}

	/**
	 * MessageTest:@T3210-Replaying to a message.
	 */
	@Test(description = "MessageTest:@T3210-Replaying to a message.")
	public void verifyReplayingToAMessage() {
		logger.logTestStep("Click on Mail.");
		messagePage.clickOnMail();
		logger.logTestStep("Store Message text.");
		final String messageText = propertyUtil.getProperty("messageText");
		logger.logTestStep("Set message text box." + messageText);
		messagePage.setMessageTextBox(messageText);
		logger.logTestStep("Click on send message.");
		messagePage.clickOnSendMessage();
		logger.logTestStep("Click on user profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Messages.");
		messagePage.clickOnMessages();

		logger.logTestStep("Check whether Replay mail displayed.");
		final boolean isReplayMailDiplayed = messagePage.isReplayMailDiplayed();
		logger.logTestVerificationStep("Verify whether Replay mail displayed." + isReplayMailDiplayed);
		Assert.assertTrue(isReplayMailDiplayed);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
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
		Assert.assertTrue(isTesDisplayed);
		logger.logTestStep("store Message body.");
		final String messageBody = propertyUtil.getProperty("messageBody");
		logger.logTestStep("Set Message body." + messageBody);
		compose.setMessageBody(messageBody);
		logger.logTestStep("Click on send.");
		compose.clickOnSend();

		logger.logTestStep("Check whether Send banner displayed.");
		final boolean isSendBannerDisplayed = compose.isSentBannerDisplayed();
		logger.logTestVerificationStep("Verify whether Send banner displayed." + isSendBannerDisplayed);
		Assert.assertTrue(isSendBannerDisplayed);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
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
		Assert.assertEquals(actualUrl, expectedUrl);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();

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
		Assert.assertTrue(isUndoDisplayed);

		logger.logTestStep("Store Expected url.");
		final String expectedUrl = "https://healthunlocked.com/messages";
		logger.logTestStep("Store Actual url.");
		final String actualUrl = messagePage.currentUrl();
		logger.logTestStep("Verify whether url's are Equal." + actualUrl + "" + expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
	}

	/**
	 * MessageTest:@T326-Undo.
	 */
	@Test(description = "MessageTest:@T326-Undo.")
	public void verifyUndo() {
		logger.logTestStep("Check whether Mail title displayed.");
		final boolean isMailTitleDisplayed = messagePage.isMailTitleDisplayed();
		logger.logTestVerificationStep("Verify whether Mail title displayed." + isMailTitleDisplayed);
		Assert.assertTrue(isMailTitleDisplayed);
		logger.logTestStep("Click on Select message.");
		messagePage.clickOnSelectMessage();
		logger.logTestStep("Click on Delete message.");
		messagePage.clickOnDeleteMessage();
		logger.logTestStep("Click on Undo.");
		messagePage.clickOnUndo();

		logger.logTestStep("Check whether Mail tilte displayed.");
		final boolean isMailTitleDisplay = messagePage.isMailTitleDisplayed();
		logger.logTestVerificationStep("Verify whether Mail title displayed." + isMailTitleDisplay);
		Assert.assertTrue(isMailTitleDisplay);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
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
		logger.logTestVerificationStep("Verify whether Tes displayed." + isTesDisplayed);
		Assert.assertTrue(isTesDisplayed);

		logger.logTestStep("Click on Recipient close.");
		compose.clickOnRecipientClose();
		logger.logTestStep("Check whether Tes displayed.");
		isTesDisplayed = compose.isTesDisplayed();
		logger.logTestVerificationStep("Verify whether Tes displayed." + isTesDisplayed);
		Assert.assertFalse(isTesDisplayed);

		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
	}
}
