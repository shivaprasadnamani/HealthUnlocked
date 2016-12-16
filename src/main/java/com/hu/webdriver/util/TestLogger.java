package com.hu.webdriver.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * This class is for Generating logger at different levels.
 * @author venkatesh
 *
 */
public class TestLogger {
	/**
	 * Screen shot directory name.
	 */
	public static final String SCREEN_SHOT_DIR_NAME = "Screenshots";
	
	/**
	 * factory.
	 * 
	 * @param clazz
	 *            class.
	 * @return {@link BaseLogger}
	 */
	public static TestLogger getLogger(final Class<?> clazz) {
		return new TestLogger(clazz);
	}

	/**
	 * factory.
	 * 
	 * @param className
	 *            name.
	 * @return {@link BaseLogger}
	 */
	public static TestLogger getLogger(final String className) {
		return new TestLogger(className);
	}
	
	/**
	 * logger.
	 */
	private static BaseLogger logger;

	/**
	 * Constructor.
	 * 
	 * @param clazz
	 *            Class
	 */
	public TestLogger(final Class<?> clazz) {
		logger = BaseLogger.getLogger(clazz);
	}

	/**
	 * Constructor.
	 * 
	 * @param className
	 *            name.
	 */
	public TestLogger(final String className) {
		logger = BaseLogger.getLogger(className);
	}

	
	/**
	 * Logger at Debug level.
	 * @param message
	 */
	public void logDebug(String message){
		logger.debug(message);
	}
	
	/**
	 * Logger at Error level.
	 * @param message
	 */
	public void logError(String message,final Object... objects){
		logger.error(message);
	}
	
	/**
	 * Logger at Info level.
	 * @param message
	 */
	public void logInfo(String message){
		logger.info(message);
	}
	
	/**
	 * Logger at Warn level.
	 * @param message
	 */
	public void logWarning(String message){
		logger.warn(message);
	}
	
	/**
	 * Logger for set up methods.
	 * @param message
	 */
	public void logSetUpStep(String message){
		StringBuffer sb = new StringBuffer();
		sb.append("###### SetUp ########## \n");
		sb.append(message);
		logInfo(sb.toString());
	}
	
	/**
	 * Logger for tear down methods.
	 * @param message
	 */
	public void logTearDownStep(String message){
		StringBuffer sb = new StringBuffer();
		sb.append("###### Tear Down ########## \n");
		logInfo(message);
		logInfo(sb.toString());
	}
	
	/**
	 * Logger for Test step.
	 * @param message
	 */
	public void logTestStep(String message){
		logInfo(message);
	}
	
	/**
	 * Logger for Test verification step.
	 * @param message
	 */
	public void logTestVerificationStep(String message){
		logger.info("Verification: "+message);
	}
	
	/**
	 * Post a screenshot and in test report. 
	 * @param msg
	 *            like message to be logged with the screen shot.
	 * @param driver
	 */
	public void postScreenShot(String message, WebDriver driver) {
		TakeBrowserScreenshot ts = new TakeBrowserScreenshot(driver);
		File imgFile = ts.takeScreenShot();
		String imgPath = String.format("%s/%s", SCREEN_SHOT_DIR_NAME, imgFile.getName());
		String htmlStr = createhtmlTagString(message, imgPath);
		Reporter.log(htmlStr);
		logInfo(imgFile.getAbsolutePath());
	}

	/**
	 * Creates a html string tag to be added to html reports.
	 * 
	 * @param msg
	 *            like "screenshot before join"
	 * @param imgPath
	 *            like "../piranhascreenshot/myimagename.png"
	 * @return string
	 */
	private static String createhtmlTagString(final String msg, final String imgPath) {
		String htmlStr = String.format(
				"" + "<strong style=\"color: blue;\">%s</strong>" + "<p>" + "<a href=\"%s\" target=\"_blank\">"
						+ "<img width=\"256\" src=\"%s\" alt=\"%s \" title=\"%s\"/>" + "</a>" + "</p>",
				msg, imgPath, imgPath, "Screenshot should be here for msg : " + msg, msg);
		return htmlStr;
	}
	
}
