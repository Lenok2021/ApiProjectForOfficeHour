package com.cydeo.day1;

import com.cydeo.utilities.SpartansTestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Spartans {

    @BeforeAll
    public void createBeforeAll() {
        RestAssured.baseURI = "http://54.234.53.165:8000";
        RestAssured.basePath = "/api";
    }
        @AfterAll
        public void reset() {

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


    }


}
