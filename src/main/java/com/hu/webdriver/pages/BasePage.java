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
	 * Instance Variable for Default web element timeout
	 */
	protected final static int DEFAULT_WEBELMENT_TIMEOUT = 30;

	/**
	 * Instance Variable for Max web element timeout.
	 */
	protected final static int MAX_WEBELMENT_TIMEOUT = 15;

	/**
	 * Instance variable for Minimum web element timeout.
	 */
	protected final static int MIN_WEBELMENT_TIMEOUT = 5;

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
	 * Method to check whether element is present or not.
	 *
	 * @param timeUnits
	 * @param by
	 * @return boolean
	 */
	public boolean isElementPresent(int timeUnits, By by) {
		boolean isDisplayed = false;
		try {
			webDriverWait(timeUnits, by);
			isDisplayed = driver.findElement(by).isDisplayed();
		} catch (final Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to check whether is element is present or not.
	 *
	 * @param timeUnits
	 * @param element
	 * @return boolean
	 */
	public boolean isElementPresent(int timeUnits, WebElement element) {
		boolean isDisplayed = false;
		try {
			final WebDriverWait wait = new WebDriverWait(driver, timeUnits);
			wait.until(ExpectedConditions.visibilityOf(element));
			isDisplayed = element.isDisplayed();
		} catch (final Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
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
		} catch (final Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to wait until invisible of Banner.
	 *
	 * @param by
	 * @return boolean
	 */
	public boolean waitUntilInvisibleOfBanner(By by) {
		final WebDriverWait wait = new WebDriverWait(driver, MAX_WEBELMENT_TIMEOUT);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * Method to wait until element located.
	 *
	 * @param timeUnits
	 * @param by
	 */
	public void webDriverWait(int timeUnits, By by) {
		final WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
