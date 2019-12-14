package com.gms.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	protected Properties configProperties;

	public Config() throws IOException {
		String targetConfig = "configuration/" + System.getenv("AUTOMATED_TEST_CONFIG");
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(targetConfig).getFile());
		FileInputStream configFileInputStream = new FileInputStream(file);
		configProperties = new Properties();
		configProperties.load(configFileInputStream);
		configFileInputStream.close();
	}

	public String getProperty(String name) {
		return configProperties.getProperty(name);
	}
}
