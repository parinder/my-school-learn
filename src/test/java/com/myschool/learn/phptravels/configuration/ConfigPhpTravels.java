package com.myschool.learn.phptravels.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPhpTravels {
    protected Properties configProperties;

    public ConfigPhpTravels() throws IOException{
        String targetConfigPhpTravels="configuration/" + System.getenv("AUTOMATED_TEST_ENV_CONFIG") + ".config.properties";
        this.loadPropertiesFile(targetConfigPhpTravels);
    }
    private void loadPropertiesFile(String filepath) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());
        FileInputStream configFileInputStream = new FileInputStream(file);
        this.configProperties.load(configFileInputStream);
        configFileInputStream.close();
    }
    public String getProperty(String name){
        return configProperties.getProperty(name);
    }
}
