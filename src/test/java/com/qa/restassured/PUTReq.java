package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PUTReq {


    @Test
    public void putreq(){
        JSONObject obj =new JSONObject();
        obj.put("name","swapnali");
        obj.put("job","Devops Engineer");

        RestAssured.baseURI="https://reqres.in/api/users/724s";
        RestAssured.given().header("Content-type","application-json").
                contentType(ContentType.JSON).
                body(obj.toJSONString()).
                when().put().
                then().statusCode(200).
                log().all();



    }
}
