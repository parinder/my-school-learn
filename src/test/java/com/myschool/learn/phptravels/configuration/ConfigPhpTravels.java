package com.myschool.learn.phptravels.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPhpTravels {
    protected Properties configProperties;

    public ConfigPhpTravels() throws IOException{
        String targetConfigPhpTravels="C:\\Users\\parin\\workspace\\my-school-learn\\src\\test\\resources\\configuration\\local-phptravels-firefox-config.properties";
        FileInputStream configPhpTravelsInputStream=new FileInputStream(targetConfigPhpTravels);
        configProperties=new Properties();
        configProperties.load(configPhpTravelsInputStream);
        configPhpTravelsInputStream.close();
    }
    public String getProperty(String name){
        return configProperties.getProperty(name);
    }
}
