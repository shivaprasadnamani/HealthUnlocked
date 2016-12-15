package com.hu.webdriver.pages.join;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

/**
 * @author SHIVA
 */
public class JoinPage extends BasePage {
	/**
	 * WebElement for close button.
	 */
	@FindBy(css = ".close")
	WebElement closeButton;

	/**
	 * WebElement for community icon.
	 */
	@FindBy(xpath = "(//div[@class='clearfix communityBox-flat'])[1]")
	WebElement communityIcon;

	/**
	 * WebElement for Community search.
	 */
	@FindBy(id="directory-search-input")
	WebElement communitySearch;

	/**
	 * WebElement for community title.
	 */
	@FindBy(xpath = "(//div[@class='box-title'])[1]")
	WebElement communityTitle;

	/**
	 * WebElement for Finish button.
	 */
	@FindBy(xpath = "//button[text()='Finish']")
	WebElement finishButton;

	/**
	 * WebElement for follow button.
	 */
	@FindBy(xpath = "(//button[text()='Follow'])[1]")
	WebElement followButton;

	/**
	 * WebElement for Join page alert header.
	 */
	@FindBy(css = ".center")
	WebElement joinPagealertHeader;

	/**
	 * WebElement for find communities.
	 */
	@FindBy(xpath = "//h3[text()='Popular communities']")
	WebElement popularCommunities;

	/**
	 * Constructor for JoinPage.
	 * @param driver
	 */
	public JoinPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method for click on close button.
	 */
	public void clickonCloseButton() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.cssSelector(".close"));
		closeButton.click();
	}

	/**
	 * Method to click on finish button.
	 */
	public void clickOnFinishButton() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//button[text()='Finish']"));
		finishButton.click();
	}

	/**
	 * Method to click on follow button.
	 */
	public void clickOnFollowButton() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//button[text()='Follow'])[1]"));
		followButton.click();
	}

	/**
	 * Method to get community title.
	 * @return String
	 */
	public String getCommunityTitle() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//div[@class='box-title'])[1]"));
		final String communityTitleText = communityTitle.getText();
		return communityTitleText;
	}

	/**
	 * Method to check whether followed community displayed.
	 *
	 * @param communityName
	 * @return boolean
	 */
	public boolean isFollowedCommunityDisplayed(String communityName) {
		final String xpathExpression = "//h6/span[text()='" + communityName + "']";
		return isElementPresent(MIN_WEBELMENT_TIMEOUT, By.xpath(xpathExpression));
	}

	/**
	 * Method to get join page.
	 */
	public void navigateToJoinPage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//div[@class='userHomeNav-username']"));
		driver.get("https://healthunlocked.com/join");
	}

	public void searcCommunity(){
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.id("directory-search-input"));
		communitySearch.click();
		communitySearch.sendKeys("Running");
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//button[text()='Follow'])[1]"));
	}

	/**
	 * Method to verify community icon.
	 * @return boolean
	 */
	public boolean verifyCommunityIcon() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("(//div[@class='clearfix communityBox-flat'])[1]"));
		return communityIcon.isDisplayed();
	}

	/**
	 * Method to verify find communities
	 *
	 * @return boolean
	 */
	public boolean verifyPopularCommunities() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Find communities']"));
	}
}
