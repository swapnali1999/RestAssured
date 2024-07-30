package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DELETEReq {


    @Test
    public void delRequest(){


        RestAssured.baseURI="https://reqres.in/api/users/724s";
        RestAssured.given().
                when().delete().
                then().statusCode(204).
                log().all();

    }
}
