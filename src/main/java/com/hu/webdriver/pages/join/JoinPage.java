package com.hu.webdriver.pages.join;

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

public class JoinPage extends BasePage {
	/**
	 * Constructor for JoinPage
	 * 
	 * @param driver
	 */
	public JoinPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElement for join page header
	 */
	@FindBy(xpath = "header-title")
	WebElement joinPageHeader;
	/**
	 * WebElement for follow button
	 */
	@FindBy(xpath = "(//button[text()='Follow'])[1]")
	WebElement followButton;
	/**
	 * WebElement for community icon
	 */
	@FindBy(xpath = "(//div[@class='clearfix communityBox-flat'])[1]")
	WebElement communityIcon;

	/**
	 * Method to get join page
	 */
	public void getJoinPage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//div[@class='userHomeNav-username']"));
		driver.get("https://healthunlocked.com/join");
	}

	/**
	 * Method to click on follow button
	 */
	public void clickOnFollowButton() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("(//button[text()='Follow'])[1]"));
		followButton.click();
	}

	/**
	 * Method to verify community icon
	 * 
	 * @return
	 */
	public boolean verifyCommunityIcon() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("(//div[@class='clearfix communityBox-flat'])[1]"));
		return communityIcon.isDisplayed();
	}

	/**
	 * Method for get home page
	 */
	public void getHomePage() {
		driver.get("https://healthunlocked.com/");
	}
}
