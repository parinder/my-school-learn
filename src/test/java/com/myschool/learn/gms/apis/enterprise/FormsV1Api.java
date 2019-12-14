package com.myschool.learn.gms.apis.enterprise;

import com.myschool.learn.gms.apis.BaseApi;
import com.myschool.learn.gms.configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FormsV1Api extends BaseApi {

    public FormsV1Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/forms/v1")
                .build();
    }

    public JsonPath getEntriesQuestions(String authToken, String surveyId, String entryId, String questionId) {
        Response response = given().spec(this.spec).header("Authorization", authToken).when()
                .get("/" + surveyId + "/entries/" + entryId + "/questions/" + questionId).then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }
}