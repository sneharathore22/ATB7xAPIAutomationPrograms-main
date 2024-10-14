package com.thetestingacademy;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {

        System.out.println("Rest Assured Test Case ");
        System.out.println("Get Request Demo");

        //Gerkins
        //given() - url,header,body or payload
        //when() - http method - get, post, patch, put, delete
        // then() - verify the response - er = ar

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/1").log().all()
                .when()
                    .get()
                .then().log().all()
                .statusCode(200);

    }
}
