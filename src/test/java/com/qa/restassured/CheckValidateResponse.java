package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckValidateResponse {
    @Test
    public void Checkresponsevalidation(){

        RestAssured.baseURI="https://reqres.in/api/users?page=2";

        RequestSpecification requestSpecification= RestAssured.given();
        Response res=requestSpecification.get();
        int responsecode=res.getStatusCode();

        ResponseBody responseBody=res.getBody();
        String response = responseBody.asString();
        //Print the responsecode

        System.out.println(res.asString());
        // validate the response code for particaular value
        Assert.assertEquals(response.contains("george.bluth@reqres.in"),true,"Value not found");

        Assert.assertEquals(responsecode,200,"Correct status code received");

        String statusLine=res.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","Incorrect statusline received");
    //Check if the response contains particular string

        //Assert.assertEquals(res.contains)
        


    }
}
