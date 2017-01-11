package com.hu.webdriver.pages.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

/**
 *
 * @author SHIVA
 *
 */
public class MessagePage extends BasePage {
	/**
	 * By element for Compose button.
	 */
	By compose = By.cssSelector(".icon-pencil-1");
	/**
	 * Web element for Delete message.
	 */
	@FindBy(xpath = "//span[text()='Delete']")
	WebElement deleteMessage;

	/**
	 * Web element for Message text.
	 */
	@FindBy(xpath = "(//input[@type='checkbox'])[2]/following::div[2]/h5//span/strong")
	WebElement mail;
	/**
	 * Web element for Mark as read button.
	 */
	@FindBy(xpath = "//button[text()='Mark as read']")
	WebElement markAsRead;
	/**
	 * By element for Message text.
	 */
	By messages = By.cssSelector(".icon-mail");
	/**
	 * Web element for Message text box.
	 */
	@FindBy(css = ".message-text-box")
	WebElement messageTextBox;
	/**
	 * By Element for My communities.
	 */
	By myCommunities = By.xpath("//span[text()='My Communities']");
	/**
	 * By element for Deselect all.
	 */
	By selectAll = By.xpath("//span[text()='Select all']");
	/**
	 * By element for Select message.
	 */
	By selectMessage = By.xpath("(//li/div/input[@type='checkbox'])[2]");
	/**
	 * By element for Undo banner.
	 */
	By undo = By.xpath("//*[text()='Undo?']");

	/**
	 * Constructor for Message page.
	 *
	 * @param driver
	 */
	public MessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to click on Compose.
	 */
	public void clickOnCompose() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Sent!']"));
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Undo?']"));
		driver.navigate().refresh();
		findClickableElement(compose).click();
	}

	/**
	 * Method to click on Delete message.
	 */
	public void clickOnDeleteMessage() {
		deleteMessage.click();
	}

	/**
	 * Method to click on Mail.
	 */
	public void clickOnMail() {
		waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'in!')]"));
		driver.navigate().refresh();
		findClickableElement(By.xpath("(//input[@type='checkbox'])[2]/following::div[2]/h5//span/strong")).click();
	}

	/**
	 * Method to click on Messages.
	 */
	public void clickOnMessages() {
		findClickableElement(messages).click();
	}

	/**
	 * Method to click on My community.
	 */
	public void clickOnMyCommunities() {
		findClickableElement(myCommunities).click();
	}

	/**
	 * Method to Select all messages.
	 */
	public void clickOnSelectAll() {
		waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'in!')]"));
		sleep(4);
		findClickableElement(selectAll).click();
	}

	/**
	 * Method to click on Select message.
	 */
	public void clickOnSelectMessage() {
		waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'in!')]"));
		driver.navigate().refresh();
		findClickableElement(selectMessage).click();
	}

	/**
	 * Method to click on Undo.
	 */
	public void clickOnUndo() {
		findClickableElement(undo).click();
	}

	/**
	 * Method to Current page url.
	 *
	 * @return String.
	 */
	public String getCurrentPageUrl() {
		return currentPageUrl();
	}

	/**
	 * Method to get Mail text.
	 *
	 * @return String.
	 */
	public String getMailText() {
		return getText(mail);
	}

	/**
	 * Method to verify whether Mail text displayed.
	 *
	 * @param mailText
	 * @return boolean
	 */
	public boolean isMailTextDisplayed(String mailText) {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("(//strong[text()='" + mailText + "'])[2]"));

	}

	/**
	 * Method to verify whether Mail title displayed.
	 *
	 * @return boolean.
	 */
	public boolean isMailTitleDisplayed() {
		return isElementPresent(mail);
	}

	/**
	 * Method to verify whether mark as read button enabled.
	 *
	 * @return boolean.
	 */
	public boolean isMarkAsReadEnabled() {
		return isEnabled(By.xpath("//button[text()='Mark as read']"));
	}

	/**
	 * Method to verify whether Undo displayed.
	 *
	 * @return boolean.
	 */
	public boolean isUndoDisplayed() {
		return isElementPresent(undo);
	}

	/**
	 * Method to set Message text box.
	 *
	 * @param value.
	 */
	public void setMessageTextBox(String value) {
		clearAndType(messageTextBox, value);
	}
}
