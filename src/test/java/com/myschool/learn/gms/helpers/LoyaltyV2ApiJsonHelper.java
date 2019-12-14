package com.myschool.learn.gms.helpers;

import com.google.gson.JsonObject;

public class LoyaltyV2ApiJsonHelper {

    public String getCredentialsJson(String loginId, String password) {
        JsonObject credentialsJson = new JsonObject();
        credentialsJson.addProperty("loginID", loginId);
        credentialsJson.addProperty("password", password);

        JsonObject rootJson = new JsonObject();
        rootJson.add("credentials", credentialsJson);
        return rootJson.toString();
    }
}