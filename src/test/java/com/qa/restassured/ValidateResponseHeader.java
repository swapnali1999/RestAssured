package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseHeader {

    @Test
    public void validateResponse(){

        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("/api/users?page=2");

        Response response=requestSpecification.get();

        //Validate response Header

        String ContentType= response.getHeader("Content-Type");
        System.out.println("ContentType is "+ContentType);


        Headers headersList=response.getHeaders();
        for(Header header:headersList) {


            System.out.println("header name is " + header.getName() +
                    "Header value us " + header.getValue());
        }

        Assert.assertEquals(ContentType,"application/json; charset=utf-8","Header Content Type message is mismatched");


    }
}
