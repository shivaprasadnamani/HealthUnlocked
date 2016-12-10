package com.hu.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author SHIVA
 */
public class BasePage {
	/**
	 * Instance variable for minimum web element time out.
	 */
	protected final static int MIN_WEBELMENT_TIMEOUT = 5;
	/**
	 * Variable for ten seconds
	 */
	protected final static int MAX_WEBELMENT_TIMEOUT = 10;
	/**
	 * Variable for thirty seconds
	 */
	protected final static int DEFAULT_WEBELMENT_TIMEOUT = 30;

	/**
	 * Instance variable for WebDriver
	 */
	protected WebDriver driver;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to check whether element present or not.
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to wait until element located
	 * 
	 * @param timeUnits
	 * @param by
	 */
	public void webDriverWait(int timeUnits, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Method to check whether is element is present or not
	 * 
	 * @param timeUnits
	 * @param element
	 * @return
	 */

	public boolean isElementPresent(int timeUnits, WebElement element) {
		boolean isDisplayed = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeUnits);
			wait.until(ExpectedConditions.visibilityOf(element));
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to check whether element is present or not
	 * 
	 * @param timeUnits
	 * @param by
	 * @return
	 */
	public boolean isElementPresent(int timeUnits, By by) {
		boolean isDisplayed = false;
		try {
			webDriverWait(timeUnits, by);
			isDisplayed = driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}
}
