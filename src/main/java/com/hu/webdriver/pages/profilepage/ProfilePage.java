package com.hu.webdriver.pages.profilepage;

import java.util.Calendar;

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
public class ProfilePage extends BasePage {
	/**
	 * Web element for Bruise.
	 */
	@FindBy(xpath = "//a[text()='Bruise']")
	WebElement bruise;

	/**
	 * By element for Community follow button;
	 */
	By communityFollowButton = By.id("community-follow-button");

	/**
	 * Web element for Edit profile.
	 */
	@FindBy(id = "profile-edit-button")
	WebElement editProfile;

	/**
	 * Web element for Methotrexate.
	 */
	@FindBy(xpath = "//a[text()='Methotrexate']")
	WebElement methotrexate;

	/**
	 * By element for Profile.
	 */
	By profile = By.id("sitebar-profile-button");

	/**
	 * By element for Profile edit button.
	 */
	By profileEditButton = By.id("profile-edit-button");

	/**
	 * Web element for Thyrotoxicosis.
	 */
	@FindBy(xpath = "//a[text()='Thyrotoxicosis']")
	WebElement thyrotoxicosis;

	/**
	 * Constructor.
	 *
	 * @param driver
	 */
	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to Age calculation.
	 *
	 * @param month
	 * @param year
	 * @return int
	 */
	private int ageCalc(int month, String year) {
		final Calendar c = Calendar.getInstance();
		final int currentYear = c.get(Calendar.YEAR);
		final int currentMonth = c.get(Calendar.MONTH);
		final int birthYear = Integer.parseInt(year);
		int age = currentYear - birthYear;
		if (currentMonth < month) {
			age = age - 1;
		}
		return age;
	}

	/**
	 * Method to Click on edit profile.
	 */
	public void clickOnEditProfile() {
		findClickableElement(By.id("profile-edit-button")).click();
	}

	/**
	 * Method to click on Profile.
	 */
	public void clickOnProfile() {
		findClickableElement(By.id("sitebar-profile-button")).click();
	}

	/**
	 * Method to click on Profile edit button.
	 */
	public void clickOnProfileEditButton() {
		findClickableElement(profileEditButton).click();
	}

	/**
	 * Method to verify whether Age is displayed.
	 *
	 * @param month
	 * @param year
	 * @return boolean
	 */
	public boolean isAgeDisplayed(int month, String year) {
		final int age = ageCalc(month, year);
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath("//td[text()='" + age + "']"));
	}

	/**
	 * Method to verifying whether bio is Displaying or not.
	 *
	 * @return boolean
	 */
	public boolean isBioDisplayed() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT,
				By.xpath("//*[contains(text(),'Hello world! I am a test user for https://healthunlocked.com')]"));
	}

	/**
	 * Method to Verify whether bruise is displayed.
	 *
	 * @return boolean
	 */
	public boolean isBruiseDisplayed() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, bruise);
	}

	/**
	 * Method to is Couch is displayed.
	 *
	 * @return boolean
	 */
	public boolean isCouchIsDisplayed() {
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Couch to 5K']"));
	}

	/**
	 * Method to verify whether gender is Displayed.
	 *
	 * @param value
	 * @return boolean
	 */
	public boolean isGenderDisplayed(String value) {
		boolean isGenderDisplayed = false;
		if (value.equals("Male")) {
			isGenderDisplayed = isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath("//td[text()='M']"));
		}
		if (value.equals("Female")) {
			isGenderDisplayed = isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath("//td[text()='F']"));
		}
		return isGenderDisplayed;
	}

	/**
	 * Method to verify whether Methotrexate is displayed.
	 *
	 * @return boolean
	 */
	public boolean isMethotrexateDisplayed() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
		sleep(1);
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, methotrexate);
	}

	/**
	 * Method to is Methotrexate displayed.
	 *
	 * @return boolean
	 */
	public boolean isThyrotoxicosisDisplayed() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
		sleep(1);
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, thyrotoxicosis);
	}
}
