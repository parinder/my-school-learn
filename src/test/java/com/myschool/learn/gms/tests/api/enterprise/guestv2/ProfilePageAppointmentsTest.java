package com.myschool.learn.gms.tests.api.enterprise.guestv2;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.util.List;

import org.testng.Assert;

public class ProfilePageAppointmentsTest extends BaseGuestV2IntegrationTest {

	@Test(description = "Test get profile appointments (no appointments).")
	public void testGetProfileAppointmentsNoAppointments() {
		String authToken = this.authApi.getAuthTokenViaLogin(this.defaultUsername, this.defaultPassword, false);
		JsonPath responseJsonPath = this.guestV2Api.getProfileAppointments(authToken, "p0bx12w1340bu0em0bh0b10an00");

		List<Object> pastAppointmentsList = responseJsonPath.getList("pastAppointments");
		Assert.assertEquals(pastAppointmentsList.size(), 0, " Response should have 0 past appointments.");

		List<Object> upcomingAppointmentsList = responseJsonPath.getList("upcomingAppointments");
		Assert.assertEquals(upcomingAppointmentsList.size(), 0, " Response should have 0 upcoming appointments.");
	}
}
