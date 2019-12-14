package com.myschool.learn.gms.apis.enterprise;

import com.myschool.learn.gms.apis.BaseApi;
import com.myschool.learn.gms.configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GuestV2Api extends BaseApi {

    public GuestV2Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/guest/v2")
                .build();
    }

    public JsonPath getProfileAppointments(String authToken, String profileId) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Authorization", authToken).when().get("/profile/" + profileId + "/appointments").then()
                .assertThat().statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }
}