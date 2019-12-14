package com.gms.apis.enterprise;

import com.gms.apis.BaseApi;
import com.gms.configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AdminV1Api extends BaseApi {

    public AdminV1Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/admin/v1")
                .build();
    }

    public JsonPath getChainsCategory(String authToken) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Authorization", authToken).when().get("/chains/category").then().assertThat().statusCode(200)
                .extract().response();
        return new JsonPath(response.asString());
    }
}