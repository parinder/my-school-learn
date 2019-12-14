package com.gms.tests.api.enterprise.guest;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import com.gms.helpers.DataHelper;

import org.testng.Assert;

public class ProfileTest extends BaseGuestIntegrationTest {

	@Test(description = "Verify getting profile with includes set to MEMBERSHIPBASIC.")
	public void testGetProfile() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		JsonPath responseJsonPath = this.guestApi.getProfile(authToken, "733n35233434f38h38a37932d00",
				"MEMBERSHIPBASIC");

		Assert.assertEquals(responseJsonPath.get("profile.id"), "733n35233434f38h38a37932d00");
		Assert.assertEquals(responseJsonPath.get("profile.email"), "testy.mctesterson@example.com");

		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].country.code"), "CA");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].cityName"), "Ottawa");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].postalCode"), "A1A1A1");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].stateProvince.name"), "ON");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressLine[0]"), "1 Test Street");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressLine[1]"), "Unit 1");

		Assert.assertEquals(responseJsonPath.get("profile.preferences.languageCode"), "en");
		Assert.assertFalse(responseJsonPath.get("profile.bounceOut"));
		Assert.assertEquals(responseJsonPath.get("profile.gender"), "MALE");
		Assert.assertEquals(responseJsonPath.get("profile.pictureUrl"),
				"https://gm.travelclick.com/gms/app/addressBook/profiles/733n35233434f38h38a37932d00/photo");

		Assert.assertEquals(responseJsonPath.get("profile.phones[0].phoneType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profile.phones[0].phoneNumber"), "15555550001");
		Assert.assertEquals(responseJsonPath.get("profile.phones[1].phoneType"), "MOBILE");
		Assert.assertEquals(responseJsonPath.get("profile.phones[1].phoneNumber"), "15555550002");
		Assert.assertEquals(responseJsonPath.get("profile.phones[2].phoneType"), "BUSINESS");
		Assert.assertEquals(responseJsonPath.get("profile.phones[2].phoneNumber"), "15555550004");
		Assert.assertEquals(responseJsonPath.get("profile.phones[3].phoneType"), "FAX");
		Assert.assertEquals(responseJsonPath.get("profile.phones[3].phoneNumber"), "15555550003");

		Assert.assertEquals(responseJsonPath.get("profile.employment.title"), "Manager");
		Assert.assertEquals(responseJsonPath.get("profile.birthDate"), "1994-01-01");
		Assert.assertFalse(responseJsonPath.get("profile.optOut"));
		Assert.assertEquals(responseJsonPath.get("profile.audit.createDatetime"), "2019-06-10@04:00:00.000+0000");
		Assert.assertEquals(responseJsonPath.get("profile.citizenships[0].country.code"), "CAN");

		Assert.assertEquals(responseJsonPath.get("profile.name.firstName"), "Testy");
		Assert.assertEquals(responseJsonPath.get("profile.name.lastName"), "McTesterson");
		Assert.assertEquals(responseJsonPath.get("profile.name.namePrefix"), "Mister");
		Assert.assertEquals(responseJsonPath.get("profile.name.middleName"), "T");

		Assert.assertEquals(responseJsonPath.get("profile.company.name"), "TestCo");
	}

	@Test(description = "Verify getting profile with includes set to MEMBERSHIPVERBOSE.")
	public void testGetProfileWithMembership() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		JsonPath responseJsonPath = this.guestApi.getProfile(authToken, "733n35233434f38h38a37932d00",
				"MEMBERSHIPVERBOSE");

		Assert.assertEquals(responseJsonPath.get("profile.id"), "733n35233434f38h38a37932d00");
		Assert.assertEquals(responseJsonPath.get("profile.email"), "testy.mctesterson@example.com");

		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].country.code"), "CA");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].cityName"), "Ottawa");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].postalCode"), "A1A1A1");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].stateProvince.name"), "ON");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressLine[0]"), "1 Test Street");
		Assert.assertEquals(responseJsonPath.get("profile.addresses[0].addressLine[1]"), "Unit 1");

		Assert.assertEquals(responseJsonPath.get("profile.preferences.languageCode"), "en");
		Assert.assertFalse(responseJsonPath.get("profile.bounceOut"));
		Assert.assertEquals(responseJsonPath.get("profile.gender"), "MALE");
		Assert.assertEquals(responseJsonPath.get("profile.pictureUrl"),
				"https://gm.travelclick.com/gms/app/addressBook/profiles/733n35233434f38h38a37932d00/photo");

		Assert.assertNotNull(responseJsonPath.get("profile.externalMemberships")); // this is empty (for now)

		Assert.assertEquals(responseJsonPath.get("profile.phones[0].phoneType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profile.phones[0].phoneNumber"), "15555550001");
		Assert.assertEquals(responseJsonPath.get("profile.phones[1].phoneType"), "MOBILE");
		Assert.assertEquals(responseJsonPath.get("profile.phones[1].phoneNumber"), "15555550002");
		Assert.assertEquals(responseJsonPath.get("profile.phones[2].phoneType"), "BUSINESS");
		Assert.assertEquals(responseJsonPath.get("profile.phones[2].phoneNumber"), "15555550004");
		Assert.assertEquals(responseJsonPath.get("profile.phones[3].phoneType"), "FAX");
		Assert.assertEquals(responseJsonPath.get("profile.phones[3].phoneNumber"), "15555550003");

		Assert.assertEquals(responseJsonPath.get("profile.employment.title"), "Manager");
		Assert.assertEquals(responseJsonPath.get("profile.birthDate"), "1994-01-01");
		Assert.assertFalse(responseJsonPath.get("profile.optOut"));
		Assert.assertEquals(responseJsonPath.get("profile.audit.createDatetime"), "2019-06-10@04:00:00.000+0000");
		Assert.assertEquals(responseJsonPath.get("profile.citizenships[0].country.code"), "CAN");

		Assert.assertEquals(responseJsonPath.get("profile.name.firstName"), "Testy");
		Assert.assertEquals(responseJsonPath.get("profile.name.lastName"), "McTesterson");
		Assert.assertEquals(responseJsonPath.get("profile.name.namePrefix"), "Mister");
		Assert.assertEquals(responseJsonPath.get("profile.name.middleName"), "T");

		Assert.assertEquals(responseJsonPath.get("profile.company.name"), "TestCo");
	}

	@Test(description = "Verify putting to profile successfully updates first name and last name.")
	public void testUpdateProfileName() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String profileId = "p0bx12w1340bu0em0bh0b10an00";

		JsonPath responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPBASIC");
		String originalFirstName = responseJsonPath.get("profile.name.firstName");
		String originalLastName = responseJsonPath.get("profile.name.lastName");
		String newFirstName = DataHelper.getUpdatedString(originalFirstName);
		String newLastName = DataHelper.getUpdatedString(originalLastName);

		String updateJson = this.guestApiJsonHelper.getProfileJson(newFirstName, newLastName, null, null, null);
		this.guestApi.putProfile(updateJson, authToken, profileId);

		responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPBASIC");
		Assert.assertEquals(responseJsonPath.get("profile.id"), profileId);
		Assert.assertEquals(responseJsonPath.get("profile.name.firstName"), newFirstName);
		Assert.assertEquals(responseJsonPath.get("profile.name.lastName"), newLastName);
	}

	@Test(description = "Verify putting to profile successfully updates company name.")
	public void testUpdateCompanyName() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String profileId = "s01n08t09u01k08m02y00100s00";

		JsonPath responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPVERBOSE");
		String originalCompanyName = responseJsonPath.get("profile.company.name");
		String newCompanyName = DataHelper.getUpdatedString(originalCompanyName);

		String updateJson = this.guestApiJsonHelper.getProfileJson(null, null, null, null, newCompanyName);
		this.guestApi.putProfile(updateJson, authToken, profileId);

		responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPVERBOSE");
		Assert.assertEquals(responseJsonPath.get("profile.id"), profileId);
		Assert.assertEquals(responseJsonPath.get("profile.company.name"), newCompanyName);
	}

	@Test(description = "Verify putting to profile successfully updates language between english and french")
	public void testUpdateLanguage() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String profileId = "733d3ai3bd34133v35l37h32d00";

		JsonPath responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPBASIC");
		String originalLanguage = responseJsonPath.get("profile.preferences.languageCode");
		String updatedLanguage = DataHelper.getUpdatedLanguage(originalLanguage);

		String updateJson = this.guestApiJsonHelper.getProfileJson(null, null, null, updatedLanguage, null);
		this.guestApi.putProfile(updateJson, authToken, profileId);

		responseJsonPath = this.guestApi.getProfile(authToken, profileId, "MEMBERSHIPBASIC");
		Assert.assertEquals(responseJsonPath.get("profile.id"), profileId);
		Assert.assertEquals(responseJsonPath.get("profile.preferences.languageCode"), updatedLanguage,
				"Profile preferences language code: ");
	}

	@Test(description = "Verify putting to profile with updated consents successfully gets a 200 response")
	public void testUpdateConsentsTrue() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String profileId = "315u1cy1da17f15v19m16m14800";
		String updateJson = this.guestApiJsonHelper.getProfileWithConsentsJson("true", "EMAIL",
				"This is a test wording.");
		this.guestApi.putProfile(updateJson, authToken, profileId); // update and just verify it gets a 200
	}
}
