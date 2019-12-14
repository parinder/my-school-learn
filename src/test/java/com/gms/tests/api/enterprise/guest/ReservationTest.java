package com.gms.tests.api.enterprise.guest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class ReservationTest extends BaseGuestIntegrationTest {

	@Test(description = "Verify getting profile reservations by profile ID.")
	public void testGetReservationshByProfileId() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-all", this.defaultPassword,
				true);
		JsonPath responseJsonPath = this.guestApi.getProfileReservations(authToken, "315u1cy1d018914i19416m14800");
		Assert.assertEquals(responseJsonPath.getList("reservations").size(), 8,
				"Did not get 8 reservations in response.");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.name.firstName"),
				"Reservimus");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.name.lastName"),
				"Reservationicus");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.phones[0].phoneNumber"),
				"54515693291689");
		Assert.assertEquals(responseJsonPath.get("reservations[1].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[2].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[3].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[4].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[5].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[6].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[7].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
	}

	@Test(description = "Verify getting profile reservations searching by first name, last name, email, and phone number.")
	public void testSearchReservationsByNameEmailPhoneNumber() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-all", this.defaultPassword,
				true);
		String bodyJson = this.guestApiJsonHelper.getGuestJson("Reservy", "McReservington",
				"reservy.mcreservington@example.com", "54515693291689", null);
		JsonPath responseJsonPath = this.guestApi.getReservationSearch(bodyJson, authToken);
		Assert.assertEquals(responseJsonPath.getList("reservations").size(), 5,
				"Did not get 5 reservations in response.");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.name.firstName"),
				"Reservy");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.name.lastName"),
				"McReservington");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.phones[0].phoneNumber"),
				"54515693291689");
		Assert.assertEquals(responseJsonPath.get("reservations[1].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[2].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[3].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[4].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
	}

	@Test(description = "Verify getting profile reservations searching by dates.")
	public void testSearchReservationByDates() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-all", this.defaultPassword,
				true);
		String bodyJson = this.guestApiJsonHelper.getDateContextJson("2019-06-11", "2019-06-18");
		JsonPath responseJsonPath = this.guestApi.getReservationSearch(bodyJson, authToken);
		Assert.assertEquals(responseJsonPath.getList("reservations").size(), 5,
				"Did not get 5 reservations in response.");
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[1].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[2].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[3].resGuests[0].profile.customer.email"),
				"reservimus.reservationicus@example.com");
		Assert.assertEquals(responseJsonPath.get("reservations[4].resGuests[0].profile.customer.email"),
				"reservy.mcreservington@example.com");
	}

	@Test(description = "Verify getting profile reservations searching by hotel ID.")
	public void testSearchReservationByHotelId() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-all", this.defaultPassword,
				true);
		String searchJson = this.guestApiJsonHelper.getGuestJson("Reservy", "McReservington",
				"reservy.mcreservington@example.com", "54515693291689", "PMSID");
		JsonPath responseJsonPath = this.guestApi.getReservationSearch(searchJson, authToken);
		Assert.assertEquals(responseJsonPath.get("reservations[0].resGlobalInfo.hotelReservationIDs[2].source"),
				"PMSID");
	}
}
