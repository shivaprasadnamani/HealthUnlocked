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
	 * WebElement for close button
	 */
	@FindBy(css=".close")
	WebElement closeButton;
	/**
	 * WebElement for community title
	 */
	@FindBy(xpath = "(//div[@class='box-title'])[1]")
	WebElement communityTitle;
	/**
	 * WebElement for alert header
	 */
	//@FindBy(xpath = "//h1[@class='center']")
	//WebElement alertHeader;
	/**
	 * 
	 */
	 @FindBy(css = ".center")
	 WebElement joinPagealertHeader;
	
	 @FindBy(xpath = "//button[text()='Finish']")
	 WebElement finishButton;
	 
	 @FindBy(css = ".userHomeNav-username")
	 WebElement profileName;
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
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//button[text()='Follow'])[1]"));
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
	/**
	 * Method for click on close button
	 */
	public void clickonCloseButton(){
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.cssSelector(".close"));
		closeButton.click();
	}
	/**
	 * Method to get community title
	 */
	public String getCommunityTitle(){
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("(//div[@class='box-title'])[1]"));
		 String communityTitleText = communityTitle.getText();
		 return communityTitleText;
	}
	/**
	 * Method to check whether followed community displayed
	 * @param communityName
	 * @return boolean
	 */
	public boolean isFollowedCommunityDisplayed(String communityName){
		String xpathExpression = "//h6/span[text()='"+communityName+"']";
		return isElementPresent(MAX_WEBELMENT_TIMEOUT,By.xpath(xpathExpression));
	}

	public boolean verifyNewsfeedAlertHeader(String userName){
		String xpathExpression = "//h1[text()='Welcome, "+userName+"!']";
		return isElementPresent(MAX_WEBELMENT_TIMEOUT, By.xpath(xpathExpression));
	}
	
	
	/**
	 * Method to click on finish button
	 */
	public void clickOnFinishButton(){
		webDriverWait(MAX_WEBELMENT_TIMEOUT, By.xpath("//button[text()='Finish']"));
		finishButton.click();
	}
	public String getUserName(){
		return profileName.getText();
	}
}
