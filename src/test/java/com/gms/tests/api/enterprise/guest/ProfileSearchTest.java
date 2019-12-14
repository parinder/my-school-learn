package com.gms.tests.api.enterprise.guest;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ProfileSearchTest extends BaseGuestIntegrationTest {

	@Test(description = "Verify profile search by email.")
	public void testProfileSearchByEmail() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String searchEmail = "testy.mctesterson@example.com";
		String searchJson = this.guestApiJsonHelper.getEmailJson(searchEmail);
		JsonPath responseJsonPath = this.guestApi.getProfileSearch(searchJson, "MEMBERSHIPBASIC", authToken);

		Assert.assertFalse(responseJsonPath.get("mergeEnabled."));

		Assert.assertEquals(responseJsonPath.get("profiles[0].id"), "733n35233434f38h38a37932d00");
		Assert.assertEquals(responseJsonPath.get("profiles[0].email"), "testy.mctesterson@example.com");

		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].country.code"), "CA");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].cityName"), "Ottawa");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].postalCode"), "A1A1A1");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].stateProvince.name"), "ON");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[0]"), "1 Test Street");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[1]"), "Unit 1");

		Assert.assertEquals(responseJsonPath.get("profiles[0].preferences.languageCode"), "en");
		Assert.assertFalse(responseJsonPath.get("profiles[0].bounceOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].gender"), "MALE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].pictureUrl"),
				"https://gm.travelclick.com/gms/app/addressBook/profiles/733n35233434f38h38a37932d00/photo");

		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneNumber"), "15555550001");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneType"), "MOBILE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneNumber"), "15555550002");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneType"), "BUSINESS");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneNumber"), "15555550004");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneType"), "FAX");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneNumber"), "15555550003");

		Assert.assertEquals(responseJsonPath.get("profiles[0].employment.title"), "Manager");
		Assert.assertEquals(responseJsonPath.get("profiles[0].birthDate"), "1994-01-01");
		Assert.assertFalse(responseJsonPath.get("profiles[0].optOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].audit.createDatetime"), "2019-06-10@04:00:00.000+0000");
		Assert.assertEquals(responseJsonPath.get("profiles[0].citizenships[0].country.code"), "CAN");

		Assert.assertEquals(responseJsonPath.get("profiles[0].name.firstName"), "Testy");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.lastName"), "McTesterson");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.namePrefix"), "Mister");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.middleName"), "T");

		Assert.assertEquals(responseJsonPath.get("profiles[0].company.name"), "TestCo");
	}

	@Test(description = "Verify profile search by first and last name.")
	public void testProfileSearchByName() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String searchJson = this.guestApiJsonHelper.getNameJson("Testy", "McTesterson");
		JsonPath responseJsonPath = this.guestApi.getProfileSearch(searchJson, "MEMBERSHIPBASIC", authToken);

		Assert.assertFalse(responseJsonPath.get("mergeEnabled."));

		Assert.assertEquals(responseJsonPath.get("profiles[0].id"), "733n35233434f38h38a37932d00");
		Assert.assertEquals(responseJsonPath.get("profiles[0].email"), "testy.mctesterson@example.com");

		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].country.code"), "CA");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].cityName"), "Ottawa");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].postalCode"), "A1A1A1");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].stateProvince.name"), "ON");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[0]"), "1 Test Street");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[1]"), "Unit 1");

		Assert.assertEquals(responseJsonPath.get("profiles[0].preferences.languageCode"), "en");
		Assert.assertFalse(responseJsonPath.get("profiles[0].bounceOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].gender"), "MALE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].pictureUrl"),
				"https://gm.travelclick.com/gms/app/addressBook/profiles/733n35233434f38h38a37932d00/photo");

		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneNumber"), "15555550001");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneType"), "MOBILE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneNumber"), "15555550002");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneType"), "BUSINESS");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneNumber"), "15555550004");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneType"), "FAX");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneNumber"), "15555550003");

		Assert.assertEquals(responseJsonPath.get("profiles[0].employment.title"), "Manager");
		Assert.assertEquals(responseJsonPath.get("profiles[0].birthDate"), "1994-01-01");
		Assert.assertFalse(responseJsonPath.get("profiles[0].optOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].audit.createDatetime"), "2019-06-10@04:00:00.000+0000");
		Assert.assertEquals(responseJsonPath.get("profiles[0].citizenships[0].country.code"), "CAN");

		Assert.assertEquals(responseJsonPath.get("profiles[0].name.firstName"), "Testy");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.lastName"), "McTesterson");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.namePrefix"), "Mister");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.middleName"), "T");

		Assert.assertEquals(responseJsonPath.get("profiles[0].company.name"), "TestCo");
	}

	@Test(description = "Verify profile search by phone number.")
	public void testProfileSearchByPhoneNumber() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String searchPhoneNumber = "15555550002";
		String searchJson = this.guestApiJsonHelper.getPhoneNumberJson(searchPhoneNumber);
		JsonPath responseJsonPath = this.guestApi.getProfileSearch(searchJson, "MEMBERSHIPBASIC", authToken);

		Assert.assertFalse(responseJsonPath.get("mergeEnabled."));

		Assert.assertEquals(responseJsonPath.get("profiles[0].id"), "733n35233434f38h38a37932d00");
		Assert.assertEquals(responseJsonPath.get("profiles[0].email"), "testy.mctesterson@example.com");

		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].country.code"), "CA");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].cityName"), "Ottawa");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].postalCode"), "A1A1A1");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].stateProvince.name"), "ON");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[0]"), "1 Test Street");
		Assert.assertEquals(responseJsonPath.get("profiles[0].addresses[0].addressLine[1]"), "Unit 1");

		Assert.assertEquals(responseJsonPath.get("profiles[0].preferences.languageCode"), "en");
		Assert.assertFalse(responseJsonPath.get("profiles[0].bounceOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].gender"), "MALE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].pictureUrl"),
				"https://gm.travelclick.com/gms/app/addressBook/profiles/733n35233434f38h38a37932d00/photo");

		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneType"), "HOME");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[0].phoneNumber"), "15555550001");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneType"), "MOBILE");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[1].phoneNumber"), "15555550002");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneType"), "BUSINESS");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[2].phoneNumber"), "15555550004");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneType"), "FAX");
		Assert.assertEquals(responseJsonPath.get("profiles[0].phones[3].phoneNumber"), "15555550003");

		Assert.assertEquals(responseJsonPath.get("profiles[0].employment.title"), "Manager");
		Assert.assertEquals(responseJsonPath.get("profiles[0].birthDate"), "1994-01-01");
		Assert.assertFalse(responseJsonPath.get("profiles[0].optOut"));
		Assert.assertEquals(responseJsonPath.get("profiles[0].audit.createDatetime"), "2019-06-10@04:00:00.000+0000");
		Assert.assertEquals(responseJsonPath.get("profiles[0].citizenships[0].country.code"), "CAN");

		Assert.assertEquals(responseJsonPath.get("profiles[0].name.firstName"), "Testy");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.lastName"), "McTesterson");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.namePrefix"), "Mister");
		Assert.assertEquals(responseJsonPath.get("profiles[0].name.middleName"), "T");

		Assert.assertEquals(responseJsonPath.get("profiles[0].company.name"), "TestCo");
	}
}
