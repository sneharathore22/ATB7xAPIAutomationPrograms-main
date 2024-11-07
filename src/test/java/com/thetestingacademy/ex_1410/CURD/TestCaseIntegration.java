package com.thetestingacademy.ex_1410.CURD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @BeforeTest
    public String getToken() {
                 String payload = "{\\n\" +\n" +
                    "                                  \\\"username\\\" : \\\"admin\\\",\\n\" +\n" +
                    "                                    \\\"password\\\" : \\\"password123\\\"\\n\" +\n" +
                    "                \"\n" +
                    "    }";

            RequestSpecification r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/auth");
            r.contentType(ContentType.JSON).log().all();
            r.body(payload);

            Response response= r.when().post();


            ValidatableResponse validatableResponse = response.then();
            validatableResponse.statusCode(200);

            token = response.jsonPath().getString("token");
            System.out.println(token);
            return token;



    }


    public String getBookingID() {

        String payloadPOST =        "{\n" +
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
        requestSpecification.basePath( "/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadPOST).log().all();

        Response response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        return bookingId;
    }

    @Test
    public void test_update_request_put() {
        token = getToken();
        bookingId= getBookingID();

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
        requestSpecification.basePath( "/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookies("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }

    @Test
    public void test_update_request_get() {


    }

    @Test
    public void test_delete_booking() {

    }

    @Test
    public void test_after_delete_request_get() {

    }
}
