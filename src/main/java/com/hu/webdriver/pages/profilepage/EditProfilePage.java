package com.hu.webdriver.pages.profilepage;

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
public class EditProfilePage extends BasePage {
	/**
	 * Web element for Bio text area.
	 */
	@FindBy(xpath = "//textarea[@name = 'limitedTextArea']")
	WebElement bioTextArea;

	/**
	 * Web element for close Health interest.
	 */
	@FindBy(xpath = "//button[text()='×']")
	WebElement closeHealthInterest;

	/**
	 * Web element for Day.
	 */
	@FindBy(css = ".form-control-day")
	WebElement day;

	/**
	 * By element for Make Private.
	 */
	By makePrivate = By.xpath("(//input[@type='checkbox'])[1]");

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
	 * Web element for Save changes.
	 */
	@FindBy(xpath = "//input[@value='Save changes']")
	WebElement saveChanges;

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
	public EditProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to click on close Health Interest.
	 */
	public void clickOnCloseHealthInterest() {
		driver.navigate().refresh();
		sleep(1);
		findVisibleElement(By.xpath("//button[text()='×']"), MAX_WEBELMENT_TIMEOUT).click();
		sleep(1);
	}

	/**
	 * Method to click on Save changes.
	 */
	public void clickOnSaveChanges() {
		sleep(1);
		findVisibleElement(By.xpath("//input[@value='Save changes']")).click();
		waitUntilInvisibleOfBanner(By.xpath("//*[text()='Saved!']"));
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
		sleep(1);
	}

	/**
	 * Method to set Symptoms.
	 *
	 * @param value
	 */
	public void setMySymptoms(String value) {
		sleep(1);
		findVisibleElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(value);
		sleep(1);
	}

	/**
	 * Method to Set my treatments.
	 *
	 * @param value
	 */
	public void setmyTreatments(String value) {
		sleep(1);
		findVisibleElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(value);
		sleep(1);
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
