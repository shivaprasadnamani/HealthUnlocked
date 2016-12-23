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
	 * By element for about us.
	 */
	By aboutUs = By.xpath("//a[text()='About us']");

	/**
	 * WebElement for about us page header.
	 */
	@FindBy(css = ".selected")
	WebElement aboutusPageHeader;

	/**
	 * By element for communities.
	 */
	By communities = By.xpath("//a[text()='Communities']");

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
	 * By element for jobs.
	 */
	By jobs = By.linkText("Jobs");

	/**
	 * WebElement for jobs page header.
	 */
	@FindBy(xpath = "//h3[text()='Jobs']")
	WebElement jobsPageHeader;

	/**
	 * By element for news.
	 */
	By news = By.linkText("News");

	/**
	 * WeElement for new page header.
	 */
	@FindBy(xpath = "//h3[text()='Media enquiries']")
	WebElement newsPageHeader;

	/**
	 * By element for search button.
	 */
	By searchButton = By.cssSelector(".btn-search");

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
		findClickableElement(By.xpath("//a[text()='About us']")).click();
	}

	/**
	 * Method to click on Communities.
	 */
	public void clickOnCommunities() {
		findClickableElement(By.xpath("//a[text()='Communities']")).click();
	}

	/**
	 * Method to click on jobs.
	 */
	public void clickOnJobs() {
		findClickableElement(By.linkText("Jobs")).click();
	}

	/**
	 * Method to click on jobs.
	 */
	public void clickOnNews() {
		findClickableElement(By.linkText("News")).click();
	}

	/**
	 * Method to click on search button.
	 */
	public void clickOnSearchButton() {
		findClickableElement(By.cssSelector(".btn-search")).click();
	}

	/**
	 * Method to verify about us page.
	 *
	 * @return boolean
	 */
	public boolean isAboutUsPage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.cssSelector(".selected"));
	}

	/**
	 * Method to verify community page.
	 *
	 * @return boolean
	 */
	public boolean isCommunityPage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//h1[text()='Find communities']"));
	}

	/**
	 * Method to verify home page.
	 *
	 * @return boolean
	 */
	public boolean isHomePage() {
		return isElementPresent(DEFAULT_WEBELMENT_TIMEOUT, By.xpath("//img[@class='logo']"));
	}

	/**
	 * Method to verify jobs page.
	 *
	 * @return boolean
	 */
	public boolean isJObsPage() {
		return isElementPresent(By.xpath("//h3[text()='Jobs']"));
	}

	/**
	 * Method to verify news page.
	 *
	 * @return boolean
	 */
	public boolean isNewsPage() {
		return isElementPresent(By.xpath("//h3[text()='Media enquiries']"));
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