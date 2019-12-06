package com.myschool.learn.pages.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected ConfigPhpTravels configPhpTravels;
    protected String url;

    public BasePage(WebDriver driver, ConfigPhpTravels configPhpTravels) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
        this.configPhpTravels = configPhpTravels;
        PageFactory.initElements(this.driver, this);

    }

    public void get(){
       driver.get(this.url);
    }

    public String getCurrentUrl(){
       return this.driver.getCurrentUrl();
    }

    public void closeWindow(){
        this.driver.close();
    }
}
