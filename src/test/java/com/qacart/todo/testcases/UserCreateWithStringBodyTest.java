package com.qacart.todo.testcases;


import org.testng.annotations.Test;

import com.qacart.todo.api.ApiRequest;



import org.testng.Assert;

import io.restassured.response.Response;


//1.register

public class UserCreateWithStringBodyTest {
	@Test
	public void userShouldBeRegister() { 
  String body = "{" 
                 + "\"firstName\":\"Yamina\","
	               + "\"lastName\":\"Achour\","
	                + "\"email\":\"yamina89@example.com\","
	                 + "\"password\":\"Abc@1236\""
	                 + "}";

  Response response =ApiRequest.post("/api/v1/users/register", body);

  Assert.assertEquals(response.getStatusCode(), 201);
  Assert.assertEquals(response.path("firstName"), "Yamina");
}

	@Test
public void shouldNotBeAbleToRegisterWithTheSameEmail() {
	
	   String body = "{" 
               + "\"firstName\":\"Yamina\","
             + "\"lastName\":\"Achour\","
             + "\"email\":\"yamina41@example.com\","
              + "\"password\":\"Abc@1236\""
              + "}";
	
	   Response response =ApiRequest.post("/api/v1/users/register", body);

	   Assert.assertEquals(response.getStatusCode(), 400);
	   Assert.assertEquals(response.path("message"), "Email is already exists in the Database");
	 }



//2.cnx 
@Test
public void shouldBeAbleToLogin() {

String body = "{"
           
            + "\"email\":\"yamina41@example.com\","
            + "\"password\":\"Abc@1236\""
            + "}";
Response response =ApiRequest.post("/api/v1/users/login", body);
Assert.assertEquals(response.getStatusCode(), 200);
Assert.assertEquals(response.path("firstName"), "Yamina");
Assert.assertNotNull(response.path("access_token"));
}}

//*cnx--->access_token*
  
  
