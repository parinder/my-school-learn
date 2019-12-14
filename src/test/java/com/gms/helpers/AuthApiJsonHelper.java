package com.gms.helpers;

import com.google.gson.JsonObject;

public class AuthApiJsonHelper {

	public String getAuthJson() {
		return this.getAuthJson(false);
	}

	public String getAuthJson(boolean allProperties) {
		String chaincode = (allProperties) ? "z0bl0a600" : "643j42h3cb00";
		JsonObject rootJson = new JsonObject();
		rootJson.addProperty("chainCode", chaincode);
		return rootJson.toString();
    }
}