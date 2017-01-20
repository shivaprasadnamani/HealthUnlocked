package com.hu.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
	 *  Instance variable for PropertyUtil.
	 */
	protected PropertyUtil propertyUtil;

	/**
	 * After Test for close browser.
	 */
	@AfterTest
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
	 * Before Test for starting browser.
	 */
	@BeforeTest
	public void startBrowser() {
		propertyUtil = new PropertyUtil();
		final String browser = propertyUtil.getProperty("browser");
		if(browser.equals("Chrome")){
			System.setProperty(propertyUtil.getProperty("chromeDriver"), propertyUtil.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		}
		if(browser.equals("Firefox")){
			System.setProperty(propertyUtil.getProperty("firefoxDrievr"),propertyUtil.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		}
		if(browser.equals("IE")){
			System.setProperty(propertyUtil.getProperty("ieDriver"), propertyUtil.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
		}
		driver.get(propertyUtil.getProperty("url"));
		driver.manage().window().maximize();
	}
}
