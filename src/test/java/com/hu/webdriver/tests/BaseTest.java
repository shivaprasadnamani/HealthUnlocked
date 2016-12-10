package com.hu.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 
 * @author SHIVA
 *
 */
public class BaseTest {
	/**
	 * Instance variable for driver
	 */
	protected WebDriver driver;

	/**
	 * Before class for starting browser.
	 */
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/binaries/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://healthunlocked.com/");
		driver.manage().window().maximize();
	}

	/**
	 * After class for closing browser.
	 */
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
