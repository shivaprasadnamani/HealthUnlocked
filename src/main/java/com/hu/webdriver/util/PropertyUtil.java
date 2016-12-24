package com.hu.webdriver.util;

import java.util.Properties;

/**
 * This class is used to read default property file.
 * @author SHIVA
 *
 */
public class PropertyUtil {

	/**
	 * Instance variable for properties.
	 */
	Properties properties = new Properties();

	/**
	 * Constructor.
	 */
	public PropertyUtil(){
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("default.properties"));
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
