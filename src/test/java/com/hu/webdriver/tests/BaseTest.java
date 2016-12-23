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
		driver.quit();
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
			System.setProperty("webdriver.chrome.driver", "src/main/resources/binaries/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.equals("Firefox")){
			System.setProperty("webdriver.firefox.marionette","src/main/resources/binaries/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "src/main/resources/binaries/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(propertyUtil.getProperty("url"));
		driver.manage().window().maximize();
	}
}
