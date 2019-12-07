package com.myschool.learn.tests.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import com.myschool.learn.pages.phptravels.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseFunctionalTest {
    protected WebDriver driver;
    protected ConfigPhpTravels configPhpTravels;
    protected HomePage homePage;


    @BeforeClass
    public void setup() throws IOException {
        this.configPhpTravels = new ConfigPhpTravels();

        int windowHeight = Integer.parseInt(configPhpTravels.getProperty("webdriver.window.height"));
        int windowWidth = Integer.parseInt(configPhpTravels.getProperty("webdriver.window.width"));

        this.driver = this.getDriver();

        this.driver.manage().window().setSize(new Dimension(windowWidth, windowHeight)); // better than default size
        this.homePage = new HomePage(this.driver, this.configPhpTravels);
    }

    @AfterClass
    public void teardown() {
        this.driver.quit();
    }

    protected WebDriver getDriver() {
        String hostUrl = configPhpTravels.getProperty("webdriver.host.url");
        String browser = configPhpTravels.getProperty("webdriver.browser");
        switch (browser) {
            case "firefox":
                FirefoxProfile testFirefoxProfile = new FirefoxProfile();
                DesiredCapabilities firefoxDesiredCapabilities = DesiredCapabilities.firefox();
                firefoxDesiredCapabilities.setCapability(FirefoxDriver.PROFILE, testFirefoxProfile);
                try {
                    return new RemoteWebDriver(new URL(hostUrl), firefoxDesiredCapabilities);
                } catch (MalformedURLException e1) {
                    throw new IllegalArgumentException("Invalid webdriver host URL: " + hostUrl);
                }
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setProxy(null);
                DesiredCapabilities chromeDesiredCapabilities = DesiredCapabilities.chrome();
                chromeDesiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                try {
                    return new RemoteWebDriver(new URL(hostUrl), chromeDesiredCapabilities);
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException("Invalid webdriver host URL: " + hostUrl);
                }
            default:
                throw new IllegalArgumentException("Invalid webdriver browser: " + browser);
        }
    }
}