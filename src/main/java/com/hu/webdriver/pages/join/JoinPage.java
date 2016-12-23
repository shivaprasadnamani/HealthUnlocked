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
	By closeButton = By.cssSelector(".close");

	/**
	 * WebElement for community icon.
	 */
	@FindBy(xpath = "(//div[@class='clearfix communityBox-flat'])[1]")
	WebElement communityIcon;

	/**
	 * WebElement for Community search.
	 */
	@FindBy(id = "directory-search-input")
	WebElement communitySearch;

	/**
	 * WebElement for community title.
	 */
	By communityTitle = By.xpath("(//div[@class='box-title'])[1]");

	/**
	 * WebElement for Finish button.
	 */
	By finishButton = By.xpath("//button[text()='Finish']");

	/**
	 * WebElement for follow button.
	 */
	By followButton = By.xpath("(//button[text()='Follow'])[1]");

	/**
	 * WebElement for Popular communities.
	 */
	@FindBy(xpath = "//h3[text()='Popular communities']")
	WebElement popularCommunities;

	/**
	 * Constructor for JoinPage.
	 *
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
		findClickableElement(By.cssSelector(".close")).click();
	}

	/**
	 * Method to click on finish button.
	 */
	public void clickOnFinishButton() {
		findClickableElement(By.xpath("//button[text()='Finish']")).click();
	}

	/**
	 * Method to click on follow button.
	 */
	public void clickOnFollowButton() {
		findClickableElement(By.xpath("(//button[text()='Follow'])[1]")).click();
	}

	/**
	 * Method to get community title.
	 *
	 * @return String
	 */
	public String getCommunityTitle() {
		return getText(By.xpath("(//div[@class='box-title'])[1]"), MAX_WEBELMENT_TIMEOUT);
	}

	/**
	 * Method to verify community icon.
	 *
	 * @return boolean
	 */
	public boolean isCommunityIcon() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("(//div[@class='clearfix communityBox-flat'])[1]"));
	}

	/**
	 * Method to check whether followed community displayed.
	 *
	 * @param communityName
	 * @return boolean
	 */
	public boolean isFollowedCommunityDisplayed(String communityName) {
		final String xpathExpression = "//h6/span[text()='" + communityName + "']";
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath(xpathExpression));
	}

	/**
	 * Method to verify find communities
	 *
	 * @return boolean
	 */
	public boolean isPopularCommunities() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Find communities']"));
	}

	/**
	 * Method to navigate Join page.
	 */
	public void navigateToJoinPage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//div[@class='userHomeNav-username']"));
		driver.get("https://healthunlocked.com/join");
	}

	/**
	 * Method to search Community.
	 */
	public void searcCommunity() {
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.id("directory-search-input"));
		communitySearch.click();
		communitySearch.sendKeys("Running");
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//button[text()='Follow'])[1]"));
	}
}
