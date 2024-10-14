package com.thetestingacademy.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStylePOST {
    public static void main(String[] args) {



        String payload = "{\\n\" +\n" +
                "                \"                   \\\"username\\\" : \\\"admin\\\",\\n\" +\n" +
                "                \"                    \\\"password\\\" : \\\"password123\\\"\\n\" +\n" +
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

    }

}