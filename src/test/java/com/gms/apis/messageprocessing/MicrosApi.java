package com.gms.apis.messageprocessing;

import com.gms.apis.BaseApi;
import com.gms.configuration.Config;
import com.gms.helpers.XmlDataHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.w3c.dom.Document;

import static io.restassured.RestAssured.given;

public class MicrosApi extends BaseApi {

    public MicrosApi(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.messageprocessing.baseurl"))
                .build();
    }

    public String postMessage(String xmlBody, String propertyName, String messageType, int expectedStatusCode) {
        String url = "/micros/integration?propertyName=" + propertyName + "&messageType=" + messageType;
        Response response = given().spec(this.spec).body(xmlBody).header("Content-Type", "application/xml").when()
                .post(url).then().assertThat().statusCode(expectedStatusCode).extract().response();
        return response.asString();
    }

    public String postProfileMessage(String property, String date, String fname, String lname, String email,
            String guestId) {
        Document xmlDocument = XmlDataHelper.getXmlDocument("fixtures/messages/micros.profile.xml");

        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/createdDate", date);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/genericName", fname);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/IndividualName/nameFirst", fname);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/IndividualName/nameSur", lname);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/ElectronicAddresses/ElectronicAddress/eAddress", email);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/mfResort", property);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/mfResortProfileID", guestId);
        XmlDataHelper.setNodeValue(xmlDocument, "/Profile/ResortList", property);

        String xmlBody = XmlDataHelper.getString(xmlDocument);

        return this.postMessage(xmlBody, property, "PROFILE", 200);
    }
}