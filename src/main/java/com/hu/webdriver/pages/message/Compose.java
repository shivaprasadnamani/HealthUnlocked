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
	 * Web element for Ban.
	 */
	@FindBy(xpath = "//div[text()='bana24']")
	WebElement ban;
	/**
	 * Web element for Body validation.
	 */
	@FindBy(xpath = "//li[contains(text(),'Body')]")
	WebElement bodyValidation;
	/**
	 * Web element for Message body.
	 */
	@FindBy(id = "compose-body-input")
	WebElement messageBody;
	/**
	 * Web element for Message validation.
	 */
	@FindBy(xpath = "//li[contains(text(),'At')]")
	WebElement messageValidation;
	/**
	 * By element for Recipient close.
	 */
	By recipientClose = By.xpath("//button[@type='button']");
	/**
	 * By element for Send.
	 */
	By send = By.cssSelector(".btn-primary");
	/**
	 * Web element for Sent banner.
	 */
	@FindBy(xpath = "//*[text()='Sent!']")
	WebElement sentBanner;
	/**
	 * Web element for Tes.
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
	 * Method to click on Recipient close.
	 */
	public void clickOnRecipientClose() {
		findClickableElement(By.xpath("//button[@type='button']")).click();
	}

	/**
	 * Method to click on Send.
	 */
	public void clickOnSend() {
		findClickableElement(By.cssSelector(".btn-primary")).click();
	}

	/**
	 * Method to verify whether Ban displayed.
	 *
	 * @return boolean.
	 */
	public boolean isBanDisplayed() {
		return isElementPresent(ban);
	}

	/**
	 * Method to verify whether Body validation displayed.
	 *
	 * @return boolean.
	 */
	public boolean isBodyValidationDisplayed() {
		return isElementPresent(bodyValidation);
	}

	/**
	 * Method to verify whether Message validation displayed.
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
		findVisibleElement(By.xpath("//*[text()='Sent!']"));
		return isElementPresent(sentBanner);
	}

	/**
	 * Method to verify whether Tes displayed.
	 *
	 * @return boolean.
	 */
	public boolean isTesDisplayed() {
		sleep(2);
		return isElementPresent(tes);
	}

	/**
	 * Method to Set message body.
	 *
	 * @param value
	 */
	public void setMessageBody(String value) {
		messageBody.sendKeys(value);
	}

	/**
	 * Method to Set user name text.
	 *
	 * @param value
	 */
	public void setUserNameText(String value) {
		userNameText.sendKeys(value);
		sleep(3);
	}
}