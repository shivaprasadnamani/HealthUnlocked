package com.hu.webdriver.tests.profilepagetest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.login.LoginPage;
import com.hu.webdriver.pages.newsfeed.NewsFeedPage;
import com.hu.webdriver.pages.profilepage.EditProfilePage;
import com.hu.webdriver.pages.profilepage.ProfilePage;
import com.hu.webdriver.tests.BaseTest;
import com.hu.webdriver.util.TestLogger;

/**
 *
 * @author SHIVA
 *
 */
public class ProfilePageTest extends BaseTest {
	/**
	 * Instance variable for Edit profile page.
	 */
	EditProfilePage editProfilePage;
	/**
	 * Test Logger.
	 */
	TestLogger logger = TestLogger.getLogger("ProfilePageTest.class");
	/**
	 * Instance variable for Login page.
	 */
	LoginPage loginPage;
	/**
	 * Instance variable for News feed page.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variable for Profile page.
	 */
	ProfilePage profilePage;

	/**
	 * After class for navigate to Home page.
	 */
	@AfterClass
	public void navigateToHomePage() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Logout.");
		newsFeedPage.clickOnLogout();
	}

	/**
	 * Before class for Setup.
	 */
	@BeforeClass
	public void setUp() {
		loginPage = new LoginPage(driver);
		newsFeedPage = new NewsFeedPage(driver);
		profilePage = new ProfilePage(driver);
		editProfilePage = new EditProfilePage(driver);

		logger.logTestStep("Click on Login.");
		loginPage.clickOnLogin();
		logger.logTestStep("Store User name.");
		final String userName = propertyUtil.getProperty("userName");
		logger.logTestStep("Set User name." + userName);
		loginPage.setUserName(userName);
		logger.logTestStep("Store Password.");
		final String password = propertyUtil.getProperty("password");
		logger.logTestStep("Set Password." + password);
		loginPage.setPassWord(password);
		logger.logTestStep("Click on Submit.");
		loginPage.clickOnSubmit();
	}

	/**
	 * ProfilePageTest-T2009:Add a new condition.
	 */
	@Test(description = "ProfilePageTest-T2009:Add a new condition.")
	public void verifyAddANewCondition() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Edit profile.");
		profilePage.clickOnEditProfile();
		logger.logTestStep("Store condition.");
		final String conditions = propertyUtil.getProperty("conditions");
		logger.logTestStep("Set my Conditions." + conditions);
		profilePage.setMyConditions(conditions);
		profilePage.setMyConditions("" + Keys.ENTER);
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether Thyrotoxicosis displayed.");
		boolean isMethotrexateDisplayed = profilePage.isThyrotoxicosisDisplayed();
		logger.logTestVerificationStep("Verify whether Thyrotoxicosis is displyed or not." + isMethotrexateDisplayed);
		Assert.assertTrue(isMethotrexateDisplayed, "Thyrotoxicosis is not Displayed.");

		logger.logTestStep("Click on Edit profile.");
		profilePage.clickOnEditProfile();
		logger.logTestStep("Click on Close health interest.");
		profilePage.clickOnCloseHealthInterest();
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether Methotrexate displayed.");
		isMethotrexateDisplayed = profilePage.isThyrotoxicosisDisplayed();
		logger.logTestVerificationStep("Verify whether Thyrotoxicosis is displyed or not." + isMethotrexateDisplayed);
		Assert.assertFalse(isMethotrexateDisplayed, "Thyrotoxicosis is still Displayed.");
	}

	/**
	 * ProfilePageTest-T2008:Add a new symptom.
	 */
	@Test(description = "ProfilePageTest-T2008:Add a new symptom.")
	public void verifyAddANewSymptom() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Edit profile.");
		profilePage.clickOnEditProfile();
		logger.logTestStep("Store Symptom.");
		final String symptom = propertyUtil.getProperty("symptom");
		logger.logTestStep("Set Symptoms." + symptom);
		profilePage.setMySymptoms(symptom);
		profilePage.setMySymptoms("" + Keys.ENTER);
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether bruise is displayed.");
		boolean bruiseIsDisplayed = profilePage.isBruiseDisplayed();
		logger.logTestVerificationStep("Verify whether bruise is Displayed or not." + bruiseIsDisplayed);
		Assert.assertTrue(bruiseIsDisplayed, "Bruise is not displaying.");

		logger.logTestStep("Click on Edit profile.");
		profilePage.clickOnEditProfile();
		logger.logTestStep("Click on Close health interest.");
		profilePage.clickOnCloseHealthInterest();
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether bruise is displayed.");
		bruiseIsDisplayed = profilePage.isBruiseDisplayed();
		logger.logTestVerificationStep("Verify whether bruise is Displayed or not." + bruiseIsDisplayed);
		Assert.assertFalse(bruiseIsDisplayed, "Bruise is still displaying.");
	}

	/**
	 * ProfilePageTest-T2010:Add a new treatment.
	 */
	@Test(description = "ProfilePageTest-T2010:Add a new treatment.")
	public void verifyAddANewTreatment() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Profile edit button.");
		profilePage.clickOnProfileEditButton();

		logger.logTestStep("Store Methotrexate.");
		final String treatment = propertyUtil.getProperty("treatment");
		logger.logTestStep("Set my Treatments." + treatment);
		profilePage.setmyTreatments(treatment);
		profilePage.setmyTreatments("" + Keys.ENTER);
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether Methotrexate displayed.");
		boolean isMethotrexateDisplayed = profilePage.isMethotrexateDisplayed();
		logger.logTestVerificationStep("Verify whether Methotrexat is displayed." + isMethotrexateDisplayed);
		Assert.assertTrue(isMethotrexateDisplayed, "Methotrexate is not Displayed.");

		logger.logTestStep("Click on Edit profile.");
		profilePage.clickOnEditProfile();
		logger.logTestStep("Click on Close health interest.");
		profilePage.clickOnCloseHealthInterest();
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check whether Methotrexate displayed.");
		isMethotrexateDisplayed = profilePage.isMethotrexateDisplayed();
		logger.logTestVerificationStep("Verify whether Methotrexat is displayed." + isMethotrexateDisplayed);
		Assert.assertFalse(isMethotrexateDisplayed, "Methotrexate is still Displayed.");
	}

	/**
	 * ProfilePageTest-T2001:Add bio to profile.
	 */
	@Test(description = "ProfilePageTest-T2001:Add bio to profile.")
	public void verifyAddBioToProfile() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Profile edit button.");
		profilePage.clickOnProfileEditButton();
		logger.logTestStep("Store Bio.");
		final String bio = propertyUtil.getProperty("bio");
		logger.logTestStep("Set Bio." + bio);
		profilePage.setBio(bio);
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check is Bio displayed.");
		final boolean isBioDisplayed = profilePage.isBioDisplayed();
		logger.logTestVerificationStep("Verifying whether bio is displaying or not." + isBioDisplayed);
		Assert.assertTrue(isBioDisplayed, "Bio is not existing.");
	}

	/**
	 * ProfilePageTest-T2014:Edit Gender.
	 */
	@Test(description = "ProfilePageTest-T2014:Edit Gender.")
	public void verifyEditGender() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Profile edit button.");
		profilePage.clickOnProfileEditButton();
		logger.logTestStep("Store Gender.");
		final String gender = propertyUtil.getProperty("gender");
		logger.logTestStep("Set Gender." + gender);
		profilePage.setGender(gender);
		logger.logTestStep("Click on Save Changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Check is Gender displayed.");
		final boolean isGenderDisplayed = profilePage.isGenderDisplayed(gender);
		logger.logTestVerificationStep("Verify wether Gender displayed on profile page." + isGenderDisplayed);
		Assert.assertTrue(isGenderDisplayed);
	}

	/**
	 * ProfilePageTest-T2013:Edit my DoB
	 */
	@Test(description = "T2013 Edit my DoB")
	public void verifyEditMyDOB() {
		logger.logTestStep("Click on User profile.");
		newsFeedPage.clickOnUserProfile();
		logger.logTestStep("Click on Profile.");
		profilePage.clickOnProfile();
		logger.logTestStep("Click on Profile edit button.");
		profilePage.clickOnProfileEditButton();

		logger.logTestStep("Store Day.");
		final String day = propertyUtil.getProperty("day");
		logger.logTestStep("Set Day." + day);
		editProfilePage.setDay(day);
		logger.logTestStep("Store Month.");
		final String month = "August";
		logger.logTestStep("Set Month." + month);
		editProfilePage.setMonth(month);
		logger.logTestStep("Store Year.");
		final String year = "1996";
		logger.logTestStep("Set Year." + year);
		editProfilePage.setYear(year);
		logger.logTestStep("Click on Save changes.");
		profilePage.clickOnSaveChanges();

		logger.logTestStep("Store birth Month.");
		final int birthMonth = 8;
		logger.logTestStep("Check whether age is displayed.");
		final boolean isAgeDisplayed = profilePage.isAgeDisplayed(birthMonth, year);
		logger.logTestVerificationStep("Verify whether age is displayed." + isAgeDisplayed);
		Assert.assertTrue(isAgeDisplayed);
	}
}
