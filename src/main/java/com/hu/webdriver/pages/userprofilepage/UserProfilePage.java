package com.hu.webdriver.pages.userprofilepage;

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
public class UserProfilePage extends BasePage {
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public UserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElement for user profile
	 */
	@FindBy(xpath = "//span[text()='shivaprasadnamani']")
	WebElement userProfile;

	/**
	 * WebElement for logout
	 */
	@FindBy(id = "sitebar-logout-button")
	WebElement logout;

	/**
	 * Method to click on user profile
	 */
	public void clickOnUserProfile() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//span[text()='shivaprasadnamani']"));
		userProfile.click();
	}

	/**
	 * Method to click on logout
	 */
	public void clickOnLogout() {
		logout.click();
	}
}
