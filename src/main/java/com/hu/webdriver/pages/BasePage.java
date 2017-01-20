package com.hu.webdriver.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	 * Method to Clear and Type.
	 * @param element
	 * @param value
	 */
	public void clearAndType(WebElement element,String value){
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method to Current page url.
	 *
	 * @return String.
	 */
	public String currentPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Method to find click-able element.
	 *
	 * @param by.
	 * @return web element.
	 */
	public WebElement findClickableElement(By by) {
		WebElement element;
		try {
			element = (new WebDriverWait(driver, DEFAULT_WEBELMENT_TIMEOUT)
					.until(ExpectedConditions.elementToBeClickable(by)));
		} catch (final Exception e) {
			final String message = "Could not find clickable element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to find presence of web element.
	 *
	 * @param by.
	 * @return web element.
	 */
	public WebElement findPresenceElement(By by) {
		WebElement element;
		try {
			element = (new WebDriverWait(driver, DEFAULT_WEBELMENT_TIMEOUT)
					.until(ExpectedConditions.presenceOfElementLocated(by)));
		} catch (final Exception e) {
			final String message = "Could not find presence element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to find presence of web element.
	 *
	 * @param by.
	 * @param timeOutInSeconds.
	 * @return web element.
	 */
	public WebElement findPresenceElement(By by, int timeOutInSeconds) {
		WebElement element;
		try {
			element = (new WebDriverWait(driver, timeOutInSeconds)
					.until(ExpectedConditions.presenceOfElementLocated(by)));
		} catch (final Exception e) {
			final String message = "Could not find presence element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to find visible web element.
	 *
	 * @param by.
	 * @return web element.
	 */
	public WebElement findVisibleElement(By by) {
		WebElement element;
		try {
			element = (new WebDriverWait(driver, DEFAULT_WEBELMENT_TIMEOUT)
					.until(ExpectedConditions.visibilityOfElementLocated(by)));
		} catch (final Exception e) {
			final String message = "Could not find visible element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to find visible web element.
	 *
	 * @param by.
	 * @param timeOutInSeconds.
	 * @return web element.
	 */
	public WebElement findVisibleElement(By by, int timeOutInSeconds) {
		WebElement element;
		try {
			element = (new WebDriverWait(driver, timeOutInSeconds)
					.until(ExpectedConditions.visibilityOfElementLocated(by)));
		} catch (final Exception e) {
			final String message = "Could not find visible element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to find list of visible web elements.
	 *
	 * @param by.
	 * @return web element.
	 */
	public List<WebElement> findVisibleElements(By by) {
		List<WebElement> element = null;
		try {
			element = (new WebDriverWait(driver, DEFAULT_WEBELMENT_TIMEOUT)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		} catch (final Exception e) {
			final String message = "Could not find visible element: " + by.toString();
			throw new RuntimeException(message);
		}
		return element;
	}

	/**
	 * Method to get the element text.
	 *
	 * @param by.
	 * @param timeInSeconds.
	 * @return String.
	 */
	public String getText(By by, int timeInSeconds) {
		String text = null;
		try {
			text = findVisibleElement(by, timeInSeconds).getText();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Method to get the element text.
	 *
	 * @param by.
	 * @return String.
	 */
	public String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return text;
	}


	public void handleAlert(boolean isAlertExist){
		if(isAlertExist){
			if(isAlertPresent()){
				driver.switchTo().alert().accept();
			}}
		else{
			if(isAlertPresent()){
				driver.switchTo().alert().dismiss();
			}}
	}

	/**
	 * Method to verify Alert present.
	 * @return boolean.
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (final Exception e) {
			return false;
		} // catch
	}

	/**
	 * Method to check whether element is present or not.
	 *
	 * @param by.
	 * @return boolean.
	 */
	public boolean isElementPresent(By by) {
		boolean isDisplayed = false;
		try {
			isDisplayed = findVisibleElement(by).isDisplayed();
		} catch (final Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to check whether element is present or not.
	 *
	 * @param timeUnits.
	 * @param by.
	 * @return boolean.
	 */
	public boolean isElementPresent(int timeUnits, By by) {
		boolean isDisplayed = false;
		try {
			isDisplayed = findVisibleElement(by, timeUnits).isDisplayed();
		} catch (final Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * Method to check whether is element is present or not.
	 *
	 * @param timeUnits.
	 * @param element.
	 * @return boolean.
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
	 * @param element.
	 * @return boolean.
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
	 * Method to check whether element is Enabled or not.
	 *
	 * @param by.
	 * @return boolean.
	 */
	public boolean isEnabled(By by) {
		boolean isEnabled = false;
		try {
			isEnabled = findVisibleElement(by).isEnabled();
		} catch (final Exception e) {
			isEnabled = false;
		}
		return isEnabled;
	}

	/**
	 * Method to check whether element is Enabled or not.
	 *
	 * @param element.
	 * @return boolean.
	 */
	public boolean isEnabled(WebElement element) {
		boolean isEnabled = false;
		try {
			isEnabled = element.isEnabled();
		} catch (final Exception e) {
			isEnabled = false;
		}
		return isEnabled;
	}

	/**
	 * Method to check whether element Selected or not.
	 *
	 * @param by.
	 * @return boolean.
	 */
	public boolean isSelected(By by) {
		boolean isSelected = false;
		try {
			isSelected = findVisibleElement(by).isSelected();
		} catch (final Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

	/**
	 * Method to check whether element is Selected or not.
	 *
	 * @param element.
	 * @return boolean.
	 */
	public boolean isSelected(WebElement element) {
		boolean isSelected = false;
		try {
			isSelected = element.isSelected();
		} catch (final Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

	/**
	 * Method to select by visible text.
	 *
	 * @param element.
	 * @param value.
	 */
	public void selectByVisibleText(WebElement element, String value) {
		sleep(1);
		final Select set = new Select(element);
		set.selectByVisibleText(value);
	}

	/**
	 * Method to select the dropdown.
	 *
	 * @param element.
	 * @param value.
	 * @param index.
	 * @param visibleText.
	 */
	public void selectDropdown(WebElement element, int index, String value, String visibleText) {
		final Select select = new Select(element);

		if (index != -1) {
			select.selectByIndex(index);
		}
		if (value != null) {
			select.selectByValue(value);
		}
		if (visibleText != null) {
			select.selectByVisibleText(visibleText);
		}
	}

	/**
	 * Method to sleep.
	 *
	 * @param timeUnits.
	 */
	public void sleep(int timeUnits) {
		final int milliSec = 1000;
		try {
			Thread.sleep(milliSec * timeUnits);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to type.
	 * @param element
	 * @param value
	 */
	public void type(WebElement element,String value){
		final WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		sleep(2);
	}

	/**
	 * Method to wait until invisible of Banner.
	 *
	 * @param by.
	 * @return boolean.
	 */
	public boolean waitUntilInvisibleOfBanner(By by) {
		final WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WEBELMENT_TIMEOUT);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * Method to wait until element located.
	 *
	 * @param timeUnits.
	 * @param by.
	 */
	public void webDriverWait(int timeUnits, By by) {
		final WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
