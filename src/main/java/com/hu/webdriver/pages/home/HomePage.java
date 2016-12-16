package com.hu.webdriver.pages.home;

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
public class HomePage extends BasePage {
	/**
	 * Web Element for about us.
	 */
	@FindBy(xpath = "//a[text()='About us']")
	WebElement aboutUs;

	/**
	 * WebElement for about us page header.
	 */
	@FindBy(css = ".selected")
	WebElement aboutusPageHeader;

	/**
	 * Web element for communities.
	 */
	@FindBy(xpath = "//a[text()='Communities']")
	WebElement communities;

	/**
	 * WebElement for communities page header.
	 */
	@FindBy(xpath = "//h1[text()='Find communities']")
	WebElement communitiesPageHeader;

	/**
	 * WebElement for health unlocked image.
	 */
	@FindBy(xpath = "//img[@class='logo']")
	WebElement healthUnlockedImage;

	/**
	 * WebElement for home page.
	 */
	@FindBy(xpath = "//a[text()='HealthUnlocked']")
	WebElement homePage;

	/**
	 * WebElement for jobs.
	 */
	@FindBy(linkText = "Jobs")
	WebElement jobs;

	/**
	 * WebElement for jobs page header.
	 */
	@FindBy(xpath = "//h3[text()='Jobs']")
	WebElement jobsPageHeader;

	/**
	 * WebElement for news.
	 */
	@FindBy(linkText = "News")
	WebElement news;

	/**
	 * WeElement for new page header.
	 */
	@FindBy(xpath = "//h3[text()='Media enquiries']")
	WebElement newsPageHeader;

	/**
	 * WebElement for search button.
	 */
	@FindBy(css = ".btn-search")
	WebElement searchButton;

	/**
	 * WebElement for search text.
	 */
	@FindBy(css = ".search-text")
	WebElement searchText;

	/**
	 * Constructor
	 *
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to click on about us.
	 */
	public void clickOnAboutUs() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='About us']"));
		aboutUs.click();
	}

	/**
	 * Method to click on Communities.
	 */
	public void clickOnCommunities() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//a[text()='Communities']"));
		communities.click();
	}

	/**
	 * Method to click on jobs.
	 */
	public void clickOnJobs() {
		jobs.click();
	}

	/**
	 * Method to click on jobs.
	 */
	public void clickOnNews() {
		news.click();
	}

	/**
	 * Method to click on search button.
	 */
	public void clickOnSearchButton() {
		searchButton.click();
	}

	/**
	 * Method to verify about us page.
	 *
	 * @return boolean
	 */
	public boolean isAboutUsPage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.cssSelector(".selected"));
		return aboutusPageHeader.isDisplayed();
	}

	/**
	 * Method to verify community page.
	 *
	 * @return boolean
	 */
	public boolean isCommunityPage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Find communities']"));
		return communitiesPageHeader.isDisplayed();
	}

	/**
	 * Method to verify home page.
	 *
	 * @return boolean
	 */
	public boolean isHomePage() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
		return healthUnlockedImage.isDisplayed();
	}

	/**
	 * Method to verify jobs page.
	 *
	 * @return boolean
	 */
	public boolean isJObsPage() {
		return jobsPageHeader.isDisplayed();
	}

	/**
	 * Method to verify news page.
	 *
	 * @return boolean
	 */
	public boolean isNewsPage() {
		return newsPageHeader.isDisplayed();
	}

	/**
	 * Method for navigate to Home page.
	 */
	public void navigateToHomePage() {
		driver.navigate().to("https://healthunlocked.com/");
	}

	/**
	 * Method to set search text.
	 *
	 * @param value
	 */
	public void setSearchText(String value) {
		searchText.sendKeys(value);
	}

	/**
	 * Method to wait until Visibility of Sign up.
	 */
	public void waitUntilVisibilityOfSignUP() {
		webDriverWait(DEFAULT_WEBELMENT_TIMEOUT, By.cssSelector(".btn-min-blue"));
	}
}