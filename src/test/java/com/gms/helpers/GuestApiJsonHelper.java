package com.gms.helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GuestApiJsonHelper {

	public String getSignupJson(String firstName, String lastName, String email, String language) {
		JsonObject nameJson = new JsonObject();
		nameJson.addProperty("firstName", firstName);
		nameJson.addProperty("lastName", lastName);

		JsonObject preferencesJson = new JsonObject();
		preferencesJson.addProperty("languageCode", language);

		JsonObject profileJson = new JsonObject();
		profileJson.addProperty("email", email);
		profileJson.add("name", nameJson);
		profileJson.add("preferences", preferencesJson);

		JsonObject rootJson = new JsonObject();
		rootJson.add("profile", profileJson);
		return rootJson.toString();
	}

	public String getProfileJson(String firstName, String lastName, String email, String language, String companyName) {
		JsonObject profileJson = new JsonObject();

		if (email != null) {
			profileJson.addProperty("email", email);
		}

		if (firstName != null && lastName != null) {
			JsonObject nameJson = new JsonObject();
			if (firstName != null) {
				nameJson.addProperty("firstName", firstName);
			}
			if (lastName != null) {
				nameJson.addProperty("lastName", lastName);
			}
			profileJson.add("name", nameJson);
		}

		if (language != null) {
			JsonObject preferencesJson = new JsonObject();
			preferencesJson.addProperty("languageCode", language);
			profileJson.add("preferences", preferencesJson);
		}

		if (companyName != null) {
			JsonObject companyJson = new JsonObject();
			JsonObject companyNameJson = new JsonObject();
			companyNameJson.addProperty("companyShortName", companyName);
			companyJson.add("companyName", companyNameJson);
			profileJson.add("company", companyJson);
		}

		JsonObject rootJson = new JsonObject();
		rootJson.add("profile", profileJson);
		return rootJson.toString();
	}

	public String getProfileWithConsentsJson(String accepted, String type, String wording) {
		JsonObject profileJson = new JsonObject();
		JsonObject consentJson = new JsonObject();
		consentJson.addProperty("accepted", accepted);
		consentJson.addProperty("type", type);
		consentJson.addProperty("wording", wording);
		JsonArray consentsArray = new JsonArray();
		consentsArray.add(consentJson);
		JsonObject rootJson = new JsonObject();
		profileJson.add("consents", consentsArray);
		rootJson.add("profile", profileJson);
		return rootJson.toString();
	}

	public String getNameJson(String firstName, String lastName) {
		JsonObject nameJson = new JsonObject();
		nameJson.addProperty("firstName", firstName);
		nameJson.addProperty("lastName", lastName);

		JsonObject rootJson = new JsonObject();
		rootJson.add("name", nameJson);
		return rootJson.toString();
	}

	public String getEmailJson(String email) {
		JsonObject rootJson = new JsonObject();
		rootJson.addProperty("email", email);
		return rootJson.toString();
	}

	public String getPhoneNumberJson(String phone) {
		JsonObject rootJson = new JsonObject();
		rootJson.addProperty("phoneNumber", phone);
		return rootJson.toString();
	}

	public String getGuestJson(String firstName, String lastName, String email, String phone, String hotelId) {
		JsonObject phonesJson = new JsonObject();
		phonesJson.addProperty("phoneNumber", phone);
		JsonArray phonesJsonArray = new JsonArray();
		phonesJsonArray.add(phonesJson);

		JsonObject nameJson = new JsonObject();
		nameJson.addProperty("firstName", firstName);
		nameJson.addProperty("lastName", lastName);

		JsonObject guestJson = new JsonObject();
		guestJson.addProperty("email", email);
		guestJson.add("name", nameJson);
		guestJson.add("phones", phonesJsonArray);

		if (hotelId != null) {
			JsonObject hotelIdsJson = new JsonObject();
			hotelIdsJson.addProperty("id", hotelId);
			JsonArray hotelIdsJsonArray = new JsonArray();
			hotelIdsJsonArray.add(hotelIdsJson);
			guestJson.add("hotelIDs", hotelIdsJsonArray);
		}

		JsonObject rootJson = new JsonObject();
		rootJson.add("guest", guestJson);
		return rootJson.toString();
	}

	public String getDateContextJson(String startDate, String endDate) {
		JsonObject dateContextJson = new JsonObject();
		dateContextJson.addProperty("end", endDate);
		dateContextJson.addProperty("rangeContext", "CHECKOUT");
		dateContextJson.addProperty("start", startDate);

		JsonObject rootJson = new JsonObject();
		rootJson.add("dateContext", dateContextJson);
		return rootJson.toString();
	}
}