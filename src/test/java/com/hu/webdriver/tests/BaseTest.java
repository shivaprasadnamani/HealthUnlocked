package com.hu.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.hu.webdriver.util.PropertyUtil;

/**
 * @author SHIVA
 */
public class BaseTest {
	/**
	 * Instance variable for driver.
	 */
	protected WebDriver driver;
	/**
	 *  Instance variable for PropertyUtil
	 */
	protected PropertyUtil propertyUtil;

	/**
	 * After class for closing browser.
	 */
	@AfterClass
	public void closeBrowser() {
		//driver.quit();
	}

	/**
	 * Method to close window.
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * Before class for starting browser.
	 */
	@BeforeClass
	public void startBrowser() {
		propertyUtil = new PropertyUtil();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/binaries/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(propertyUtil.getProperty("url"));
		driver.manage().window().maximize();
	}
}
