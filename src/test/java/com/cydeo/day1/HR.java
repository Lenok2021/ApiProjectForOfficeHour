package com.cydeo.day1;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;


public class HR extends HrTestBase {

   /*
   1. Send request to HR url and save the response
2. GET /regions
3. Store the response in Response Object that comes from get Request
4. Print out followings
- Headers
Content-Type
Status Code
Response
- Date
5.
Verify response body has
"Europe"

    */

    @Test
    public void test1() {
        //1. Send request to HR url and save the response
        //2. GET /regions
        //3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://3.86.82.161:1000/ords/hr/regions");

        // print response
        response.prettyPrint();
        //4. Print out followings
        //   - Headers
        System.out.println("==============================");
        System.out.println("response.headers() = " + response.headers());
        //   - Content-Type
        System.out.println("==============================");
        System.out.println(response.contentType());
        //   - Status Code
        System.out.println("==============================");
        System.out.println(response.statusCode());

        //   - Date
        System.out.println(response.header("Date"));
        //5. Verify response body has "Europe"
        Assertions.assertTrue(response.body().asString().contains("Europe"));
        //6. Verify response has Date
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

    }

    @DisplayName("GET/employees/150 with path() method")
    @Test
    public void test2() {

     /*
       Task 2:

1. Send request to HR url and save the response
2. GET /employees/150
3. Store the response in Response Object that comes from get Request
4. Print out followings
First Name
Last Name
Verify status code is 200
Verify First Name is "Peter"
- Verify content-Type is application/json
      */

        Response response =
                given()
                        .accept(ContentType.JSON)
                        .pathParam("id", 150)
                        .when().get("/employees/{id}");
        response.prettyPrint();


        String firstName = response.path("first_name");
        System.out.println("firstName = " + firstName);

        String lastName = response.path("last_name");
        System.out.println("lastName = " + lastName);

        int employeeId = response.path("employee_id");
        System.out.println("employeeId = " + employeeId);

        String email = response.path("email");
        System.out.println("email = " + email);

        String phoneNumber = response.path("phone_number");
        System.out.println("phoneNumber = " + phoneNumber);

        int salary = response.path("salary");
        System.out.println("salary = " + salary);

        int managerId = response.path("manager_id") ;
        System.out.println("managerId = " + managerId);

        int departmentId = response.path("department_id");
        System.out.println("departmentId = " + departmentId);

         // get href!!!!!
        int[] array= new int[5];
        System.out.println(array[0]);
        // here  the same when you get first_name from
        // Json Object you provide key
        // here the same
        // System.out.println(array[0]) you GET one Json Object
        //and then you provide the KEY
        System.out.println(response.path("links[0].href").toString());

        // what  if  I  want to get all Array



        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json", response.contentType());


    }


}
