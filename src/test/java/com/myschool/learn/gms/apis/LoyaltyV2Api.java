package com.myschool.learn.gms.apis;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.helpers.LoyaltyV2ApiJsonHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoyaltyV2Api extends BaseApi {

    protected LoyaltyV2ApiJsonHelper loyaltyV2ApiJsonHelper;
    protected String enterpriseId;
    protected String clientId;
    protected String clientSecret;

    public LoyaltyV2Api(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.loyalty.v2.baseurl")).build();
        this.loyaltyV2ApiJsonHelper = new LoyaltyV2ApiJsonHelper();
        this.enterpriseId = this.config.getProperty("api.loyalty.v2.enterpriseid");
        this.clientId = this.config.getProperty("api.loyalty.v2.clientid");
        this.clientSecret = this.config.getProperty("api.loyalty.v2.clientsecret");
    }

    public String postOathTokenAndReturnToken() {
        JsonPath responseJsonPath = this.postOauthToken(this.clientId, this.clientSecret);
        return responseJsonPath.getString("access_token");
    }

    public JsonPath postOauthToken(String clientId, String clientSecret) {
        Response response = given().spec(this.spec).auth().preemptive().basic(clientId, clientSecret)
                .formParam("grant_type", "client_credentials").when().post("/oauth/token").then().assertThat()
                .statusCode(200).extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath getAuthRecaptcha(String oauthToken) {
        Response response = given().spec(this.spec).header("Authorization", "Bearer " + oauthToken).when()
                .get("loyalty/v2/" + this.enterpriseId + "/auth/recaptcha").then().assertThat().statusCode(200)
                .extract().response();
        return new JsonPath(response.asString());
    }

    public JsonPath postAuth(String loginId, String password, String oauthToken) {
        String bodyJson = loyaltyV2ApiJsonHelper.getCredentialsJson(loginId, password);
        Response response = given().spec(this.spec).body(bodyJson).header("Authorization", "Bearer " + oauthToken)
                .when().post("/loyalty/v2/" + this.enterpriseId + "/auth").then().assertThat().statusCode(200).extract()
                .response();
        return new JsonPath(response.asString());
    }
}