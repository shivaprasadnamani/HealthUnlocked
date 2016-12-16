package com.hu.webdriver.util;

import java.util.Properties;

/**
 * This class is used to read all property files.
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
