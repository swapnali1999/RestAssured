package com.qa.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;
import static  org.testng.annotations.Test.*;



public class HTTPRequest {

    @Test(priority = 1)
    void getUser() {

        Response res= get("https://reqres.in/api/users?page=2");
        System.out.println(res.asString());
        System.out.println("The Status code is  "+res.getStatusCode());
        System.out.print("   ");



    }


    @Test (priority = 2)
    void getUserBDD(){
        baseURI="https://reqres.in/api/users";
        given()
                .queryParam("page,2");
      when().get()
              .then().statusCode(200);


    }
}



        /*given()
                .when()
                    .get("https://reqres.in/api/users?page=2")

                .then()
                        .statusCode(200)
                        .body("page",equalTo(2))
                        .log().all();

    }

    @Test
    void createUser(){

        HashMap data =new HashMap();
        data.put("name","MyUsernew");
        data.put("job","developer");

                given()
                        .contentType("application/json")
                        .body(data);

                when()
                         .post("https://reqres.in/api/users")

                .then()
                         .statusCode(204)
                         .log().all();

    }*/


