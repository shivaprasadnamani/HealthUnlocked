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
	 * By element for Compose.
	 */
	By compose = By.cssSelector(".icon-pencil-1");
	/**
	 * By element for Delete message.
	 */
	By deleteMessage = By.xpath("//span[text()='Delete']");
	/**
	 * By element for Mail.
	 */
	By mail = By.xpath("(//input[@type='checkbox'])[11]/following::div[2]/h5//span/strong");
	/**
	 * Web element for Mark as read.
	 */
	@FindBy(xpath = "//button[text()='Mark as read']")
	WebElement markAsRead;
	/**
	 * By element for Message.
	 */
	By messages = By.xpath("//span[text()='Messages ']");
	/**
	 * Web element for Message text box.
	 */
	@FindBy(css = ".message-text-box")
	WebElement messageTextBox;
	/**
	 * Web element for Replay page header.
	 */
	@FindBy(xpath = "(//div[contains(text(),'Welcome')])[1]")
	WebElement replayPageHeader;
	/**
	 * Web element for Select message.
	 */
	@FindBy(xpath = "(//li/div/input[@type='checkbox'])[11]")
	WebElement selectMessage;
	/**
	 * By element for Send message.
	 */
	By sendMessage = By.cssSelector(".btn-primary");
	/**
	 * By element for Undo.
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
		findClickableElement(By.cssSelector(".icon-pencil-1")).click();
	}

	/**
	 * Method to click on Delete message.
	 */
	public void clickOnDeleteMessage() {
		findClickableElement(By.xpath("//span[text()='Delete']")).click();
		sleep(4);
	}

	/**
	 * Method to click on Mail.
	 */
	public void clickOnMail() {
		findClickableElement(By.xpath("(//input[@type='checkbox'])[11]/following::div[2]/h5//span/strong")).click();
	}

	/**
	 * Method to click on Messages.
	 */
	public void clickOnMessages() {
		findClickableElement(By.xpath("//span[text()='Messages ']")).click();
	}

	/**
	 * Method to click on Select message.
	 */
	public void clickOnSelectMessage() {
		findClickableElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
	}

	/**
	 * Method to click on Send message.
	 */
	public void clickOnSendMessage() {
		findClickableElement(By.cssSelector(".btn-primary")).click();
		sleep(1);
	}

	/**
	 * Method to click on Undo.
	 */
	public void clickOnUndo() {
		findClickableElement(By.xpath("//*[text()='Undo?']")).click();
		sleep(3);
	}

	/**
	 * Method to Current url.
	 *
	 * @return String.
	 */
	public String currentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Method to verify whether Mail displayed.
	 *
	 * @return boolean.
	 */
	public boolean isMailDisplayed() {
		return isElementPresent(mail);
	}

	/**
	 * Method to verify whether Mail title displayed.
	 *
	 * @return boolean.
	 */
	public boolean isMailTitleDisplayed() {
		return isElementPresent(By.xpath("(//input[@type='checkbox'])[11]/following::div[2]/h5//span/strong"));
	}

	/**
	 * Method to verify whether mark as read displayed.
	 *
	 * @return boolean.
	 */
	public boolean isMarkAsReadDisplayed() {
		return isEnabled(By.xpath("//button[text()='Mark as read']"));
	}

	/**
	 * Method to verify whether Message displayed.
	 *
	 * @param userName.
	 * @param userNameTextbana.
	 * @return boolean.
	 */
	public boolean isMessageDisplayed(String userName, String userNameTextbana) {
		return isElementPresent(
				By.xpath("(//strong[text()='Message between " + userName + " and " + userNameTextbana + "'])[2]"));
	}

	/**
	 * Method to verify whether Replay mail displayed.
	 *
	 * @return boolean.
	 */
	public boolean isReplayMailDiplayed() {
		return isElementPresent(By.xpath("(//input[@type='checkbox'])[11]/following::div[2]/h5//span/strong"));
	}

	/**
	 * Method to verify whether Undo displayed.
	 *
	 * @return boolean.
	 */
	public boolean isUndoDisplayed() {
		sleep(3);
		return isElementPresent(undo);
	}

	/**
	 * Method to navigate to Message page.
	 */
	public void navigateToMessagePage() {
		driver.navigate().to("https://healthunlocked.com/messages");
	}

	/**
	 * Method to set Message text box.
	 *
	 * @param value.
	 */
	public void setMessageTextBox(String value) {
		messageTextBox.sendKeys(value);
		sleep(1);
	}
}
