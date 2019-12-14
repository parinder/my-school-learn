package com.gms.tests;

import com.gms.pages.HomePage;
import com.gms.pages.LoginPage;
import com.gms.pages.NavigationBarPage;
import com.gms.pages.rezqueue.RezqueueHomePage;
import com.gms.pages.rezqueue.RezqueueLoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseFunctionalTest extends BaseTest {

	protected WebDriver driver;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected NavigationBarPage navigationBarPage;
	protected RezqueueLoginPage rezqueueLoginPage;
	protected RezqueueHomePage rezqueueHomePage;

	protected String defaultUsername = "qaautomated.main-user";
	protected String defaultPassword = "Quality1!";

	@BeforeClass
	public void setup() throws IOException {
		super.setup();

		int windowHeight = Integer.parseInt(config.getProperty("webdriver.window.height"));
		int windowWidth = Integer.parseInt(config.getProperty("webdriver.window.width"));

		this.driver = this.getDriver();
		this.driver.manage().window().setSize(new Dimension(windowWidth, windowHeight)); // better than default size

		this.homePage = new HomePage(this.driver, this.config);
		this.loginPage = new LoginPage(this.driver, this.config);
		this.navigationBarPage = new NavigationBarPage(this.driver, this.config);
		this.rezqueueLoginPage = new RezqueueLoginPage(this.driver, this.config);
		this.rezqueueHomePage = new RezqueueHomePage(this.driver, this.config);
	}

	@AfterClass
	public void teardown() {
		this.driver.quit();
	}

	protected WebDriver getDriver() {
		String hostUrl = config.getProperty("webdriver.host.url");
		String browser = config.getProperty("webdriver.browser");
		switch (browser) {
		case "firefox":
			FirefoxProfile testFirefoxProfile = new FirefoxProfile();
			FirefoxOptions testFirefoxOptions = new FirefoxOptions();
			testFirefoxOptions.setProfile(testFirefoxProfile);
			try {
				return new RemoteWebDriver(new URL(hostUrl), testFirefoxOptions);
			} catch (MalformedURLException e1) {
				throw new IllegalArgumentException("Invalid webdriver host URL: " + hostUrl);
			}
		case "chrome":
			ChromeOptions testChromeOptions = new ChromeOptions();
			testChromeOptions.setProxy(null);
			try {
				return new RemoteWebDriver(new URL(hostUrl), testChromeOptions);
			} catch (MalformedURLException e) {
				throw new IllegalArgumentException("Invalid webdriver host URL: " + hostUrl);
			}
		default:
			throw new IllegalArgumentException("Invalid webdriver browser: " + browser);
		}
	}

	public void login(String username, String password) {
		this.loginPage.get();
		this.loginPage.waitForPageLoad();
		this.loginPage.enterUsername(username);
		this.loginPage.enterPassword(password);
		this.loginPage.clickLoginButton();
		this.homePage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		Assert.assertTrue(this.homePage.homePageTitleIsVisible());
	}

	public void loginExpectingError(String username, String password, String expectedErrorMessage) {
		this.loginPage.get();
		this.loginPage.waitForPageLoad();
		this.loginPage.enterUsername(username);
		this.loginPage.enterPassword(password);
		this.loginPage.clickLoginButton();
		Assert.assertEquals(this.loginPage.getLoginErrorMessage(), expectedErrorMessage,
				"Login error message should be '" + expectedErrorMessage + "'.");
	}

	public void rezqueueLogin(String userName, String password) {
		this.rezqueueLoginPage.get();
		this.rezqueueLoginPage.waitForPageLoad();
		this.rezqueueLoginPage.enterUsername(userName);
		this.rezqueueLoginPage.enterPassword(password);
		this.rezqueueLoginPage.clickRezqueLoginButton();
		this.rezqueueHomePage.waitForPageLoad();
		Assert.assertTrue(this.rezqueueHomePage.rezQueueHomePageTitleIsVisible());
	}

	public void rezQueueLoginExpectingError(String userName, String password, String expectedErrorMessage) {
		this.rezqueueLoginPage.get();
		this.rezqueueLoginPage.waitForPageLoad();
		this.rezqueueLoginPage.enterUsername(userName);
		this.rezqueueLoginPage.enterPassword(password);
		this.rezqueueLoginPage.clickRezqueLoginButton();
		Assert.assertEquals(this.rezqueueLoginPage.getLoginErrorMessage(), expectedErrorMessage,
				"Login error message should be '" + expectedErrorMessage + "''.");
	}

	public void logout() {
		this.navigationBarPage.clickLogoutMenuItem();
		this.loginPage.waitForPageLoad();
	}

	public void rezQueueLogout() {
		this.navigationBarPage.clickLogoutMenuItem();
		this.rezqueueLoginPage.waitForPageLoad();
	}
}