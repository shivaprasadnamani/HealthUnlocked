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
	 * Web element for Bio text area.
	 */
	@FindBy(xpath = "//textarea[@name = 'limitedTextArea']")
	WebElement bioTextArea;

	/**
	 * Web element for Bruise.
	 */
	@FindBy(xpath = "//a[text()='Bruise']")
	WebElement bruise;

	/**
	 * Web element for close Health interest.
	 */
	@FindBy(xpath = "//button[text()='×']")
	WebElement closeHealthInterest;

	/**
	 * By element for Community follow button;
	 */
	By communityFollowButton = By.id("community-follow-button");

	/**
	 * Web element for Day.
	 */
	@FindBy(css = ".form-control-day")
	WebElement day;

	/**
	 * Web element for Edit profile.
	 */
	@FindBy(id = "profile-edit-button")
	WebElement editProfile;

	/**
	 * By element for Make Private.
	 */
	By makePrivate = By.xpath("(//input[@type='checkbox'])[1]");

	/**
	 * Web element for Methotrexate.
	 */
	@FindBy(xpath = "//a[text()='Methotrexate']")
	WebElement methotrexate;

	/**
	 * Web element for Month.
	 */
	@FindBy(css = ".form-control-month")
	WebElement month;

	/**
	 * Web element for Symptoms search.
	 */
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement mySymptoms;

	/**
	 * Web element for my Treatments.
	 */
	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement myTreatments;

	/**
	 * By element for Profile.
	 */
	By profile = By.id("sitebar-profile-button");

	/**
	 * By element for Profile edit button.
	 */
	By profileEditButton = By.id("profile-edit-button");

	/**
	 * Web element for Save changes.
	 */
	@FindBy(xpath = "//input[@value='Save changes']")
	WebElement saveChanges;

	/**
	 * Web element for Thyrotoxicosis.
	 */
	@FindBy(xpath = "//a[text()='Thyrotoxicosis']")
	WebElement thyrotoxicosis;

	/**
	 * Web element for Year.
	 */
	@FindBy(css = ".form-control-year")
	WebElement year;

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
	private int ageCalc(int month, int year) {
		final Calendar c = Calendar.getInstance();
		final int currentYear = c.get(Calendar.YEAR);
		final int currentMonth = c.get(Calendar.MONTH);
		int age = currentYear - year;
		if (currentMonth < month) {
			age = age - 1;
		}
		return age;
	}

	/**
	 * Method to click on close Health Interest.
	 */
	public void clickOnCloseHealthInterest() {
		findVisibleElement(By.xpath("//button[text()='×']"), MAX_WEBELMENT_TIMEOUT).click();
		sleep(1);
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
		findClickableElement(By.id("profile-edit-button")).click();
	}

	/**
	 * Method to click on Save changes.
	 */
	public void clickOnSaveChanges() {
		findVisibleElement(By.xpath("//input[@value='Save changes']")).click();
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
	}

	/**
	 * Method to verify whether Age is displayed.
	 *
	 * @param month
	 * @param year
	 * @return boolean
	 */
	public boolean isAgeDisplayed(int month, int year) {
		final int age = ageCalc(month, year);
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath("//td[text()='" + age + "']"));
	}

	/**
	 * Method to verifying whether bio is Displaying or not.
	 *
	 * @return boolean
	 */
	public boolean isBioDisplayed() {
		return isElementPresent(MAX_WEBELMENT_TIMEOUT,
				By.xpath("//*[contains(text(),'Hello world! I am a test user for https://healthunlocked.com')]"));
	}

	/**
	 * Method to Verify whether bruise is displayed.
	 *
	 * @return boolean
	 */
	public boolean isBruiseDisplayed() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Bruise']"));
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
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Methotrexate']"));
	}

	/**
	 * Method to is Methotrexate displayed.
	 *
	 * @return boolean
	 */
	public boolean isThyrotoxicosisDisplayed() {
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Thyrotoxicosis']"));
	}

	/**
	 * Method to set Bio.
	 *
	 * @param value
	 */
	public void setBio(String value) {
		findVisibleElement(By.xpath("//textarea[@name = 'limitedTextArea']"), MAX_WEBELMENT_TIMEOUT).sendKeys(value);
	}

	/**
	 * Method to set Day.
	 *
	 * @param value
	 */
	public void setDay(String value) {
		findVisibleElement(By.cssSelector(".form-control-day"));
		selectDropdown(day, -1, value, null);
	}

	/**
	 * Method to set Gender.
	 *
	 * @param gender
	 */
	public void setGender(String gender) {
		sleep(1);
		findVisibleElement(By.xpath("//input[@label='" + gender + "']"), MAX_WEBELMENT_TIMEOUT).click();
	}

	/**
	 * Method to set Month.
	 *
	 * @param value
	 */
	public void setMonth(String value) {
		findVisibleElement(By.cssSelector(".form-control-month"));
		selectDropdown(month, -1, null, value);
	}

	/**
	 * Method to set my conditions.
	 *
	 * @param value
	 */
	public void setMyConditions(String value) {
		sleep(1);
		findVisibleElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(value);
	}

	/**
	 * Method to set Symptoms.
	 *
	 * @param value
	 */
	public void setMySymptoms(String value) {
		sleep(1);
		findVisibleElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(value);
	}

	/**
	 * Method to Set my treatments.
	 *
	 * @param value
	 */
	public void setmyTreatments(String value) {
		sleep(1);
		findVisibleElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(value);
	}

	/**
	 * Method to set Year.
	 *
	 * @param value
	 */
	public void setYear(String value) {
		findVisibleElement(By.cssSelector(".form-control-year"));
		selectDropdown(year, -1, value, null);
	}
}
