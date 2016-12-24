package com.hu.webdriver.util;

import java.util.Properties;

/**
 * This class is used to read hu property file.
 * @author SHIVA
 *
 */
public class HUPropertyUtil {


	/**
	 * Instance variable for properties.
	 */
	Properties properties = new Properties();

	/**
	 * Constructor.
	 */
	public HUPropertyUtil(){
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("hu.properties"));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get Property value.
	 * @param key the key value
	 * @return String the property value.
	 */
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}

