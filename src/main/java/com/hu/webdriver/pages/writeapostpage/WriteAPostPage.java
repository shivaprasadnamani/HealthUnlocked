package com.hu.webdriver.pages.writeapostpage;

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
public class WriteAPostPage extends BasePage{
	@FindBy(xpath = "//button[text()='×']")
	WebElement closeBanner;

	@FindBy(xpath = "(//button[text()='Follow'])[1]//preceding::span[11]")
	WebElement community;

	@FindBy(xpath = "(//input[@type='submit'])[2]")
	WebElement deleteConfirmationButton;

	By deletePost = By.xpath("//a[text()='Delete']");

	By editPost = By.xpath("//a[text()='Edit']");

	@FindBy(css = ".content-editor")
	WebElement postBody;

	@FindBy(xpath = "//input[@id='write-submit-button']")
	WebElement postButton;

	@FindBy(xpath = "(//span[@class='icon-down-open-1'])[3]")
	WebElement postOptionsButton;

	@FindBy(xpath = "//textarea[@id='write-title-input']")
	WebElement postTitle;

	By writeAPostButton = By.xpath("//a[text()='Write a post']");

	/**
	 * Constructor
	 * @param driver
	 */
	public WriteAPostPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCloseBanner(){
		closeBanner.click();
	}

	public void clickOnCommunity(String communityText){
		findClickableElement(By.xpath("(//a[text()='"+communityText+"'])[1]")).click();

	}
	public void clickOnDeleteConfirmationButton(){
		deleteConfirmationButton.click();
	}
	public void clickOnDeletePost(){
		findClickableElement(deletePost).click();
	}

	public void clickOnEditPost(){
		findClickableElement(editPost).click();
	}

	public void clickOnPostButton(){
		postButton.click();
	}

	public void clickOnPostOptionsButton(){
		postOptionsButton.click();
	}

	public void clickOnWriteAPostButton(){
		findClickableElement(writeAPostButton).click();
	}

	public String getCommunityText(){
		return getText(community);
	}

	public boolean isCommunityPostPageDisplayed(String communityText){
		return isElementPresent(By.xpath("(//a[text()='"+communityText+"'])[2]"));
	}

	public boolean isPostDisplayed(String postTitle){
		return isElementPresent(By.xpath("//p[text()='"+postTitle+"']"));
	}

	public boolean isWriteAPostDisplayed(){
		return isElementPresent(writeAPostButton);
	}

	public void setPostBody(String value){
		clearAndType(postBody, value);
	}

	public void setPostTitle(String value){
		clearAndType(postTitle, value);
	}

	public void waitUntilInvisibleOfBanner(){
		waitUntilInvisibleOfBanner(By.xpath("//*[contains(text(),'in!')]"));
	}
}
