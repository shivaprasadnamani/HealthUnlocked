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
public class Compose extends BasePage {
	/**
	 * Web element for Ban user.
	 */
	@FindBy(xpath = "//div[text()='bana24']")
	WebElement ban;
	/**
	 * Web element for Body validation.
	 */
	@FindBy(xpath = "//li[text()='Body is required.']")
	WebElement bodyValidation;
	/**
	 * Web element for Message body.
	 */
	@FindBy(id = "compose-body-input")
	WebElement messageBody;
	/**
	 * Web element for Message validation.
	 */
	@FindBy(xpath = "//li[text()='At least one recipient is required']")
	WebElement messageValidation;
	/**
	 * Web element for Recipient close button.
	 */
	@FindBy(xpath = "//button[@type='button']")
	WebElement recipientClose;
	/**
	 * By element for Send button.
	 */
	By send = By.cssSelector(".btn-primary");
	/**
	 * By element for Send message.
	 */
	By sendMessage = By.cssSelector(".btn-primary");
	/**
	 * Web element for Sent banner.
	 */
	@FindBy(xpath = "//*[text()='Sent!']")
	WebElement sentBanner;
	/**
	 * Web element for Tes user.
	 */
	@FindBy(xpath = "//div[text()='Tes1970']")
	WebElement tes;
	/**
	 * Web element for User name text.
	 */
	@FindBy(xpath = "//input[@placeholder='Start typing username...']")
	WebElement userNameText;
	/**
	 * Constructor for Compose page.
	 *
	 * @param driver
	 */
	public Compose(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 *Method to Clear text area.
	 */
	public void clearTextArea(){
		userNameText.clear();
	}

	/**
	 * Method to click on Recipient close.
	 */
	public void clickOnRecipientClose() {
		recipientClose.click();
	}

	/**
	 * Method to click on Send button.
	 */
	public void clickOnSend() {
		findClickableElement(send).click();
	}

	/**
	 * Method to click on Send message.
	 */
	public void clickOnSendMessage() {
		findClickableElement(sendMessage).click();
	}

	/**
	 * Method to verify whether Ban user displayed.
	 *
	 * @return boolean.
	 */
	public boolean isBanDisplayed() {
		sleep(3);
		return isElementPresent(ban);
	}

	/**
	 * Method to verify whether Body validation error message displayed.
	 *
	 * @return boolean.
	 */
	public boolean isBodyValidationDisplayed() {
		return isElementPresent(bodyValidation);
	}

	/**
	 * Method to verify whether Message validation error message displayed.
	 *
	 * @return boolean.
	 */
	public boolean isMessageValidationDisplayed() {
		return isElementPresent(messageValidation);
	}

	/**
	 * Method to verify whether Sent banner displayed.
	 *
	 * @return boolean.
	 */
	public boolean isSentBannerDisplayed() {
		return isElementPresent(By.xpath("//*[text()='Sent!']"));
	}

	/**
	 * Method to verify whether Tes user displayed.
	 *
	 * @return boolean.
	 */
	public boolean isTesDisplayed() {
		sleep(1);
		return isElementPresent(By.xpath("//div[text()='Tes1970']"));
	}

	/**
	 * Method to Set message body.
	 *
	 * @param value
	 */
	public void setMessageBody(String value) {
		clearAndType(messageBody, value);
	}

	/**
	 * Method to Set user name text.
	 *
	 * @param value
	 */
	public void setUserNameText(String value) {
		type(userNameText, value);
	}

	/**
	 * Method to wait until Alert present.
	 */
	public boolean waitUntilAlertPresent(){
		return isAlertPresent();
	}

}