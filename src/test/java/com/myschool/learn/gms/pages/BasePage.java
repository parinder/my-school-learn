package com.myschool.learn.gms.pages;

import com.myschool.learn.gms.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected Config config;
	protected String url;

	public BasePage(WebDriver driver, Config config) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 25);
		this.config = config;
		PageFactory.initElements(this.driver, this);
	}

	public void get() {
		driver.get(this.url);
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	// window management

	public void waitForNumberOfWindowsToBe(Integer expected) {
		this.wait.until(ExpectedConditions.numberOfWindowsToBe(expected));
	}

	public void switchToNewWindow() {
		String newWindow = null;
		Set<String> allwindows = this.driver.getWindowHandles();
		for (String WinID : allwindows) {
			newWindow = WinID;
		}
		this.driver.switchTo().window(newWindow);
	}

	public void closeWindow() {
		this.driver.close();
	}

	// alerts

	public String getAlertText() {
		this.wait.until(ExpectedConditions.alertIsPresent());
		return this.driver.switchTo().alert().getText();
	}

	public void clickAlertOk() {
		this.wait.until(ExpectedConditions.alertIsPresent());
		this.driver.switchTo().alert().accept();
	}

	// implicit wait (shameful I know)

	public void implicitlyWait(Integer secondsToWait) {
		long millisToWait = secondsToWait * 1000;
		try {
			Thread.sleep(millisToWait);
		} catch (Exception e) {
			// do nothing as this will literally never happen
		}
	}

}
