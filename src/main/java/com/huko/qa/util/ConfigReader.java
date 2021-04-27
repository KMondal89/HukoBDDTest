package com.huko.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	/**
	 * This method is used to load and return config properties.
	 * 
	 * @return
	 */
	public Properties init_prop() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\CodeClouds-Kaustav\\eclipse-workspace\\HukoBDDTest\\src\\test\\resources\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

		return prop;
	}

}
