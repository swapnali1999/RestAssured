package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class POSTReq {

    @Test
    public void sendpost(){

    JSONObject obj =new JSONObject();
    obj.put("name","swapnali");
    obj.put("job","QA Engineer");

        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().header("Content-type","application-json").
        contentType(ContentType.JSON).
        body(obj.toJSONString()).
                when().post().
                then().statusCode(201).
        log().all();


}
}
