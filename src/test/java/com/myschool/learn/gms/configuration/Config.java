package com.myschool.learn.gms.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	protected Properties configProperties;

	public Config() throws IOException {
		String targetConfig="C:\\Users\\pasingh\\Travelclick\\my-school-learn\\src\\test\\resources\\configuration\\local-prod-firefox.config.properties";
		FileInputStream configFileInputStream = new FileInputStream(targetConfig);
		configProperties = new Properties();
		configProperties.load(configFileInputStream);
		configFileInputStream.close();
	}

	public String getProperty(String name) {
		return configProperties.getProperty(name);
	}
}
