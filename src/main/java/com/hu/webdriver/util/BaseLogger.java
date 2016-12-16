package com.hu.webdriver.util;

import org.apache.log4j.Logger;
import org.testng.Reporter;

/**
 * BaseLoggger.
 * 
 * @author Venkatesh Aarelly
 */
class BaseLogger {
	/**
	 * factory.
	 * 
	 * @param clazz
	 *            class.
	 * @return {@link BaseLogger}
	 */
	public static BaseLogger getLogger(final Class<?> clazz) {
		return new BaseLogger(clazz);
	}

	/**
	 * factory.
	 * 
	 * @param className
	 *            name.
	 * @return {@link BaseLogger}
	 */
	public static BaseLogger getLogger(final String className) {
		return new BaseLogger(className);
	}

	/**
	 * logger.
	 */
	private final Logger logger;

	/**
	 * Constructor.
	 * 
	 * @param clazz
	 *            Class
	 */
	protected BaseLogger(final Class<?> clazz) {
		this.logger = Logger.getLogger(clazz);
	}

	/**
	 * Constructor.
	 * 
	 * @param className
	 *            name.
	 */
	BaseLogger(final String className) {
		this.logger = Logger.getLogger(className);
	}

	/**
	 * Debug.
	 * 
	 * @param message
	 *            debug message to log.
	 */
	public void debug(final String message) {
		logger.debug(message);
		Reporter.log(message);
	}

	/**
	 * error.
	 * 
	 * @param message
	 *            error message to log.
	 */
	public void error(final String message, final Object... objects) {
		String msg = String.format(message, objects);
		StringBuilder str = new StringBuilder();
		str.append("<font color=\"red\">");
		str.append(msg);
		str.append("</font>");
		logger.error(str.toString());
		Reporter.log(str.toString());
	}

	/**
	 * fatal.
	 * 
	 * @param message
	 *            the message to log..
	 */
	public void fatal(final String message) {
		logger.fatal(message);
		Reporter.log(message);
	}

	/**
	 * info.
	 * 
	 * @param message
	 *            the message to log..
	 */
	public void info(final String message) {
		logger.info(message);
		Reporter.log(message);
	}

	/**
	 * Warn.
	 * 
	 * @param message
	 *            the message to log..
	 */
	public void warn(final String message) {
		logger.warn(message);
		Reporter.log(message);
	}

}
