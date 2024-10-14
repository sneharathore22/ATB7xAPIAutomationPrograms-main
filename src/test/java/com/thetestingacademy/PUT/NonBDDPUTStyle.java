package com.thetestingacademy.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPUTStyle {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test

    public void test_put_positive_tc(){
//        String payload_token = "{\n"  +
//                "               \"firstname\" : \"James\",\n" +
//                "               \"lastname\" : \"Brown\"\n" +
//
//                "}";

        String payloadPUT =        "{\n" +
                "    \"firstname\" : \"shuchi\",\n" +
                "    \"lastname\" : \"rathore\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2014-01-01\",\n" +
                "        \"checkout\" : \"2014-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"dinner\"\n" +
                "}";




        String token = "0d5c10c0a1064ce";
        String bookingid ="6118";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath( "/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookies("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }
}
