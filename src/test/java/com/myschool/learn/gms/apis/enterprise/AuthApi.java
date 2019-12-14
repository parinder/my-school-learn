package com.myschool.learn.gms.apis.enterprise;

import static io.restassured.RestAssured.given;

import com.myschool.learn.gms.apis.BaseApi;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.helpers.AuthApiJsonHelper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AuthApi extends BaseApi {

    protected AuthApiJsonHelper authApiJsonHelper;

    public AuthApi(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/auth")
                .build();
        this.authApiJsonHelper = new AuthApiJsonHelper();
    }

    public String getAuthTokenViaLogin(String username, String password, Boolean allProperties) {
        JsonPath responseJsonPath = this.postAuth(username, password, allProperties);
        return responseJsonPath.get("accessToken");
    }

    public JsonPath postAuth(String username, String password, Boolean allProperties) {
        String authJson = this.authApiJsonHelper.getAuthJson(allProperties);
        Response response = given().spec(this.spec).body(authJson).header("ClientID", username)
                .header("Accept", "application/json").header("Content-Type", "application/json")
                .header("ClientSecret", password).when().post().then().assertThat().statusCode(200).extract()
                .response();
        return new JsonPath(response.asString());
    }
}