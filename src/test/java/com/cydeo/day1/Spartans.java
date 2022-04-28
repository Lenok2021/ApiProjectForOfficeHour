package com.cydeo.day1;


import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Spartans {

    @BeforeAll
    public static void createBeforeAll() {
        RestAssured.baseURI = "http://54.234.53.165:8000";
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public  static void reset() {

        RestAssured.reset();

    }


    @Test
    public void test() {

     /*
     Task 3:
1. Send request to Spartan url and save the response
2. GET /spartans
3. Store the response in Response Object that comes from get Request
4. Print out followings
     - response
     - Content-Type
     - Status Code
     - Get me third spartan
     - Get me third spartan gender
     - Get me third spartan name
     - Get me all spartan name

      */
        //Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("/spartans");

        //print response
        System.out.println(response.prettyPrint());

        //print Content-Type
        System.out.println(response.contentType());
        //print status code
        System.out.println(response.statusCode());

        //Get me third spartan

        Object thirdSpartan = response.path("[2]");
        System.out.println("thirdSpartan = " + thirdSpartan);

        //Get me third spartan gender

        String thirdSpartanGender = response.path("[2].gender");
        System.out.println("thirdSpartanGender = " + thirdSpartanGender);

        
        //Get me third spartan name
        String thirdSpartanName = response.path("[2].name");
        System.out.println("thirdSpartanName = " + thirdSpartanName);
        
        // Get me all spartan name
        
        List<String> names = response.path("name");
        System.out.println("names = " + names);

        
        
    }


}
