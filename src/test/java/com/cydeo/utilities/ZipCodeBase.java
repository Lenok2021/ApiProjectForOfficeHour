package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ZipCodeBase {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://api.zippopotam.us";

    }




}
