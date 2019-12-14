package com.gms.apis.enterprise;

import com.gms.apis.BaseApi;
import com.gms.configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JobsV1Api extends BaseApi {

    public JobsV1Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/jobs/v1")
                .build();
    }

    public JsonPath getJobScheduleResetPassword(String authToken) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Authorization", authToken).when().get("/job/scheduleResetPassword").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }
}