package com.myschool.learn.gms.apis.enterprise;

import com.myschool.learn.gms.apis.BaseApi;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.helpers.GuestApiJsonHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GuestApi extends BaseApi {

    protected GuestApiJsonHelper guestApiJsonHelper;

    public GuestApi(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.enterprise.baseurl") + "/guest")
                .build();
        this.guestApiJsonHelper = new GuestApiJsonHelper();
    }

    public void postProgramGuestMembership(String bodyJson, String authToken) {
        given().spec(this.spec).body(bodyJson).header("Authorization", authToken)
                .header("Content-Type", "application/json").when().post("/program/guest/membership").then().assertThat()
                .statusCode(200);
    }

    public JsonPath getProfileSearch(String bodyJson, String includes, String authToken) {
        Response response = given().spec(this.spec).body(bodyJson).queryParam("includes", includes)
                .header("Content-Type", "application/json").header("Authorization", authToken).when()
                .post("/profile/search").then().assertThat().statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getProfile(String authToken, String profileId, String includes) {
        Response response = given().spec(this.spec).queryParam("language", "en").queryParam("includes", includes)
                .header("Accept", "application/json").header("Authorization", authToken).when()
                .get("/profile/" + profileId).then().assertThat().statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getProfilePreferences(String authToken, String profileId) {
        Response response = given().spec(this.spec).header("Authorization", authToken).queryParam("language", "en")
                .when().get("/profile/" + profileId + "/preferences").then().assertThat().statusCode(200).extract()
                .response();
        return new JsonPath(response.asString());
    }

    public JsonPath getProfileReservations(String authToken, String profileId) {
        Response response = given().spec(this.spec).header("Authorization", authToken)
                .header("Content-Type", "application/json").when().get("/profile/" + profileId + "/reservations").then()
                .assertThat().statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getReservationSearch(String bodyJson, String authToken) {
        Response response = given().spec(this.spec).body(bodyJson).header("Authorization", authToken)
                .header("Content-Type", "application/json").when().post("/reservation/search").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public void putProfile(String bodyJson, String authToken, String profileId) {
        given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Authorization", authToken).header("Accept", "application/json").when()
                .put("/profile/" + profileId).then().assertThat().statusCode(200);
    }
}