package com.qacart.todo.testcases;

import org.testng.annotations.Test;

import com.qacart.todo.models.User;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

//1.register
public class UserTest {
	@Test
public void userShouldBeRegister() { 
//		1er methode 
   //     String body = "{" 
     //               + "\"firstName\":\"Yamina\","
	 //              + "\"lastName\":\"Achour\","
	 //               + "\"email\":\"yamina41@example.com\","
	 //                + "\"password\":\"Abc@1236\""
	 //                + "}";

		//2eme methode 	
//        User user=new User();     
//        user.setFirstName("Yamina");
//        user.setLastName("Achour");
//        user.setEmail("yamina41@example.com");
//        user.setPassword("Abc@1236");
   //  3eme methode --> constructor
		
        User user=new User("Yamina","Achour","yamina41@example.com","Abc@1236");
        
        // Prepare the HTTP request
        given()  
            .baseUri("https://qacart-todo.herokuapp.com") // Base URL of API
            .contentType(ContentType.JSON)                 // Request type JSON
            //      .body(body) 
            .body(user)    // Request payload       // userId = null, accessToken = null doit  doit doit import com.fasterxml.jackson.annotation.JsonInclude;

        // Send request (POST)
        .when() 
            .post("/api/v1/users/register")  
        // Validate response		
        .then()                                      
            .log().all() // Print full response for debugging
        // Check response 		
            .assertThat()                  
            .statusCode(201)                 // Expect HTTP 201 Created
            .body("firstName", equalTo("Yamina")); // Verify firstName in response
    }
    
	@Test
public void shouldNotBeAbleToRegisterWithTheSameEmail() {

		       String body = "{" 
	                    + "\"firstName\":\"Yamina\","
		              + "\"lastName\":\"Achour\","
		              + "\"email\":\"yamina41@example.com\","
		               + "\"password\":\"Abc@1236\""
		               + "}";

        // Prepare the HTTP request
        given()
            .baseUri("https://qacart-todo.herokuapp.com/") // Base URL
            .contentType(ContentType.JSON)                 // JSON payload
           .body(body)
          
        // Send request (POST)
        .when()
            .post("/api/v1/users/register")
        // Validate response	;, 	
        .then()
            .log().all() // Print full response
        // Check response
            .assertThat()
            .statusCode(400) // Expect HTTP 400 Bad Request
            .body("message", equalTo("Email is already exists in the Database")); // Verify error message
    }

	@Test
	public void shouldBeAbleToLogin() {

//    String body = "{"
//               
//                + "\"email\":\"yamina41@example.com\","
//                + "\"password\":\"Abc@1236\""
//                + "}";
 // 3 eme methode ---> constructor
	   User user=new User("yamina41@example.com","Abc@1236");
    // Prepare the HTTP request
    given()
        .baseUri("https://qacart-todo.herokuapp.com") // Base URL
        .contentType(ContentType.JSON)                 // JSON payload
        .body(user)
        //.body(body)
    // Send request (POST)
    .when()
        .post("/api/v1/users/login")
    // Validate response		
    .then()
        .log().all() // Print full response
    // Check response
        .assertThat().statusCode(200) // Expect HTTP 400 Bad Request
        .assertThat().body("firstName", equalTo("Yamina"))
        .assertThat().body("access_token", not(equalTo(null)));
        
}
}