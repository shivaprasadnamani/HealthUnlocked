package com.hu.webdriver.pages.newsfeed;

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
public class NewsFeedPage extends BasePage {
	/**
	 * Constructor
	 * @param driver
	 */
 public NewsFeedPage(WebDriver driver){
	 super(driver);
	 PageFactory.initElements(driver, this);
 }
 /**
  * WebElement for Account Settings
  */
 @FindBy(id="sitebar-account-button")
 WebElement accountSettings;
 /**
  * WebElement for i want to delete my account
  */
 @FindBy(id="settings-show-delete-button")
 WebElement iWantToDeleteMyAccount;
 /**
  * WebElement to delete account button
  */
 @FindBy(id="settings-delete-account-button")
 WebElement deleteAccountButton;
 /**
  * WebElement to delete my account	
  */
 @FindBy(className="btn btn-default btn-danger")
 WebElement deleteMyAccount;
 /**
  * Method to click on Account Settings
  */
 public void clickOnAccountSettings(){
	 accountSettings.click();
 }
 /**
  * Method to click on delete my account
  */
 public void clickOnIWantToDeleteMyAccount(){
	 iWantToDeleteMyAccount.click();
 }
 /**
  * Method to click on delete account button 
  */
 public void clickOnDeleteAccountButton(){
	 deleteAccountButton.click();
 }
 /**
  * Method to click on Delete My Account
  */
 public void clickOnDeleteMyAccount(){
	 deleteMyAccount.click();
 }
}
