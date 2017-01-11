package com.hu.webdriver.pages.join;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

/**
 * @author SHIVA
 */
public class JoinPage extends BasePage {
	/**
	 * By element for Browse communities.
	 */
	By browseCommunities = By.xpath("//a[text()='Browse Communities']");

	/**
	 * By Element for close button.
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
	 * By element for community title.
	 */
	By communityTitle = By.xpath("(//div[@class='box-title'])[1]");

	/**
	 * By element for Finish button.
	 */
	By finishButton = By.xpath("//button[text()='Finish']");

	/**
	 * Web element for Follow.
	 */
	@FindBy(xpath = "(//button[text()='Follow'])[1]")
	WebElement follow;

	/**
	 * By element for follow button.
	 */
	By followButton = By.xpath("(//button[text()='Follow'])[1]");

	/**
	 * Web element for Following.
	 */
	@FindBy(xpath = "//button[text()='Following']")
	WebElement following;

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
	 * Method to click on Browse community.
	 */
	public void clickOnBrowseCommunity() {
		findClickableElement(browseCommunities).click();
	}

	/**
	 * Method for click on close button.
	 */
	public void clickonCloseButton() {
		findClickableElement(closeButton).click();
	}

	/**
	 * Method to click on finish button.
	 */
	public void clickOnFinishButton() {
		findClickableElement(finishButton).click();
	}

	/**
	 * Method to click on follow button.
	 */
	public void clickOnFollowButton() {
		findClickableElement(followButton).click();
	}

	/**
	 * Method to click on Follow community.
	 *
	 * @return String.
	 */
	public String clickOnFollowCommunity() {
		findClickableElement(By.xpath("(//button[text()='Follow'])[1]")).click();
		return getText(follow);
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
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, communityIcon);
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
		findVisibleElement(By.xpath("//div[@class='userHomeNav-username']"), DEFAULT_WEBELMENT_TIMEOUT);
		driver.get("https://healthunlocked.com/join");
	}

	/**
	 * Method to search Community.
	 */
	public void searcCommunity() {
		findVisibleElement(By.id("directory-search-input"), MAX_WEBELMENT_TIMEOUT);
		communitySearch.click();
		communitySearch.sendKeys("Running");
		findVisibleElement(By.xpath("(//button[text()='Follow'])[1]"), MAX_WEBELMENT_TIMEOUT);
	}

	/**
	 * Method to unfollow Communities.
	 */
	public void unfollowCommunities() {
		final List<WebElement> list = findVisibleElements(By.xpath("//button[text()='Following']"));
		for (final WebElement element : list) {
			final Actions action = new Actions(driver);
			action.moveToElement(following);
			element.click();
		}
	}
}
