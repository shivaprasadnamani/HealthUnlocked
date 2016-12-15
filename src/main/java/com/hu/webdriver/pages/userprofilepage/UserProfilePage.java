package com.hu.webdriver.pages.userprofilepage;

import org.openqa.selenium.WebDriver;
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
}
