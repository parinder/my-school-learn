package com.myschool.learn.gms.tests.login;

import com.myschool.learn.gms.tests.BaseFunctionalTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseFunctionalTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
	}

	@Test(description = "Test failed GMS login with no list access.")
	public void testSuccessfulGmsLogin() {
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test failed GMS login with no list access.")
	public void testFailedLoginWithNoListAccess() {
		this.loginExpectingError("qaautomated.no-list-access", this.defaultPassword, "Login failed");
	}

	@Test(description = "Test failed GMS login as invalid user.")
	public void testFailedLoginAsInvalidUser() {
		this.loginExpectingError("qaautomated.not-a-real-user", this.defaultPassword, "Your Username was not found");
	}

	@Test(description = "Test failed GMS login with expired password.")
	public void testFailedLoginWithExpiredPassword() {
		this.loginExpectingError("qaautomated.expired-password", this.defaultPassword,
				"Login Expired. Please change your Password.");
	}

	@Test(enabled = false, description = "Test failed GMS login with locked password.")
	public void testFailedLoginWithLockedPassword() {
		// DISABLED: user should be seeded with locked password
		this.loginExpectingError("qaautomated.login-locked-user", this.defaultPassword, "Login locked");
	}

	@Test(description = "Test successful RezQueue login.")
	public void testSuccessfulRezQueueLogin() {
		this.rezqueueLogin(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test failed RezQueue login with expired password.")
	public void testFailedRezQueueLoginWithExpiredPassword() {
		// WORKAROUND: DE50130 requires a successsful login to get language
		// cookie
		this.rezqueueLogin(this.defaultUsername, this.defaultPassword);
		this.rezQueueLogout();

		this.rezQueueLoginExpectingError("qaautomated.expired-password", this.defaultPassword,
				"Your Login has expired. Please click on the I forgot my password link below to fix it");
	}
}