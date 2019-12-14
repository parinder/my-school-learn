package com.myschool.learn.gms.tests;

import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class BaseIntegrationTest extends BaseTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
	}
}