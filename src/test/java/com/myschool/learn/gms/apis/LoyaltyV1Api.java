package com.myschool.learn.gms.apis;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.helpers.FormattingHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoyaltyV1Api extends BaseApi {

    protected String portalName;

    public LoyaltyV1Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.loyalty.v1.baseurl")).build();
        this.portalName = this.config.getProperty("api.loyalty.v1.portalname");
    }

    public JsonPath postLogin(String email, String password, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Content-Type", "x-www-form-urlencoded")
                .contentType(ContentType.URLENC.withCharset("UTF-8")).formParam("email", email)
                .formParam("password", password).when()
                .post("/portal/client/" + this.portalName + "/en/auth/json/login").then().assertThat().statusCode(200)
                .extract().response();
        String responseJsonString = FormattingHelper.deDerpifyJson(response.asString()); // because derpy json
        return new JsonPath(responseJsonString);
    }

    public String postLoginAndReturnAuthToken(String email, String password, String appSecret) {
        Response loginResponse = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Content-Type", "x-www-form-urlencoded")
                .contentType(ContentType.URLENC.withCharset("UTF-8")).formParam("email", email)
                .formParam("password", password).when()
                .post("/portal/client/" + this.portalName + "/en/auth/json/login").then().assertThat().statusCode(200)
                .extract().response();
        return loginResponse.getHeader("Authorization");
    }

    public JsonPath postLogout(String email, String password, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Content-Type", "x-www-form-urlencoded")
                .contentType(ContentType.URLENC.withCharset("UTF-8")).formParam("email", email)
                .formParam("password", password).when()
                .post("/portal/client/" + this.portalName + "/en/account/json/logout").then().assertThat()
                .statusCode(200).extract().response();
        String responseJsonString = FormattingHelper.deDerpifyJson(response.asString()); // because derpy json
        return new JsonPath(responseJsonString);
    }

    public JsonPath getProfile(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/profile").then().assertThat()
                .statusCode(200).extract().response();
        String responseJsonString = FormattingHelper.deDerpifyJson(response.asString()); // because derpy json
        return new JsonPath(responseJsonString);
    }

    public JsonPath postSaveSettings(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/saveSettings").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postUpcomingStays(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/upcomingStays").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postPastStays(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/pastStays").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getPointsHistory(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/points/history").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getPoints(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/points").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getPointsExpiry(String authToken, String appSecret, Boolean expired) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret).queryParam("expired", expired)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/points").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getPrograms(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/points/programs").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getProgramsWithProgramId(String authToken, String appSecret, String programId) {
        Response response = given().spec(this.spec).header("x-app-secret", appSecret)
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("Content-Type", "application/json").when()
                .get("/portal/client/" + this.portalName + "/en/account/json/points/programs/" + programId).then()
                .assertThat().statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postSignupAccount(String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Origin", this.config.getProperty("api.loyalty.v1.baseurl")).when()
                .post("/portal/client/" + this.portalName + "/en/account/json/signup").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postResendEmail(String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Origin", this.config.getProperty("api.loyalty.v1.baseurl")).when()
                .post("/portal/client/" + this.portalName + "s/en/account/json/sendOrResendEmail").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getAccountPreferences(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/preferences").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getSurveyPreferences(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/preferencesSurvey").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postPreferences(String authToken, String appSecret, String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .post("/portal/client/" + this.portalName + "/en/account/json/preferences").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getCustomFields(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/profile/customFields").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath putCustomFields(String authToken, String appSecret, String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .put("/portal/client/" + this.portalName + "/en/account/json/profile/customFields").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getProfileCompletness(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/profile/completeness").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getSubscriptions(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/account/json/subscriptions").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath putSubscriptions(String authToken, String appSecret, String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .put("/portal/client/" + this.portalName + "/en/account/json/subscriptions").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getCatalogItems(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/module/ItemCatalogModule").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postRedeemCatalogItem(String authToken, String appSecret, String bodyJson) {
        Response response = given().spec(this.spec).body(bodyJson).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .post("/portal/client/" + this.portalName + "/en/module/ItemCatalogModule").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getRecaptcha(String authToken, String appSecret) {
        Response response = given().spec(this.spec).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Authorization", authToken)
                .header("x-app-secret", appSecret).when()
                .get("/portal/client/" + this.portalName + "/en/authjson/recaptcha").then().assertThat().statusCode(200)
                .extract().response();
        return new JsonPath(response.asString());
    }
}