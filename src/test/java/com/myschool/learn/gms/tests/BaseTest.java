package com.myschool.learn.gms.tests;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.helpers.RandomDataHelper;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

	protected Config config;

	protected RandomDataHelper randomDataHelper;

	protected String defaultUsername = "qaautomated.main-user";
	protected String defaultPassword = "Quality1!";

	@BeforeClass
	public void setup() throws IOException {
		this.config = new Config();
		this.randomDataHelper = new RandomDataHelper();
	}
}