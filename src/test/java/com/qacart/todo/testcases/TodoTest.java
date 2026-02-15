package com.qacart.todo.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TodoTest {
	//POST → ➕ Ajouter / Créer
public void shouldBeAbleToAddTodo() {
	        // JSON body for adding a task
//	        String body = "{"
//                    + "\"item\":\"houda\","       // Nom de la tâche
//                    + "\"isCompleted\": false"     // Champ requis par l'API
//                    + "}";
		
	        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5NjJiMDE3OTg0NjAwMDAxNTQ2YTQyOSIsImZpcnN0TmFtZSI6IllhbWluYSIsImxhc3ROYW1lIjoiQWNob3VyIiwiaWF0IjoxNzY4MDc1Mjg3fQ.iOayqs8MiI5F5hY_Rl_O83NBbwQ4NgAuQH7okiSeM7E";
	       
	        // Prepare the HTTP request
	        given()
	            .baseUri("https://qacart-todo.herokuapp.com/") 
	            .contentType(ContentType.JSON)                 
//	            .body(body)    // Request payload
	           
	            .auth().oauth2(token)
	        // Send POST request to add task
	        .when()
	            .post("/api/v1/tasks") 
	        // Validate response
	        .then()
	        	.log().all()                               // Print full response for debugging
	            .assertThat()
	            .statusCode(201)                               // Expect HTTP 201 Created
	            .body("item", equalTo("houda"))              // Verify that task name is correct
	            .body("isCompleted", equalTo(false))          // Verify that isCompleted is false
	            .body("_id", notNullValue());                 // Verify that _id is generated and not null
	    }
	
@Test
public void shouldNotBeAbleToAddTodoIfIsCompletedIsMissing() {
    // JSON body for adding a task
    String body = "{"
            + "\"item\":\"houda\","       
          
            + "}";

    String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5NjE2MGQ5OGU5OGFhMDAxNTdjZWM2ZCIsImZpcnN0TmFtZSI6IkhhdGVtIiwibGFzdE5hbWUiOiJIYXRlbUxhIiwiaWF0IjoxNzY3OTk0MDE5fQ.I3c4uR-PeBLanQMsVuPt3Fw_ZshMvFjt8XHvhx6FeO0";
    // Prepare the HTTP request
    given()
        .baseUri("https://qacart-todo.herokuapp.com/") 
        .contentType(ContentType.JSON)                 
        .body(body)    
        .auth().oauth2(token)
    .when()
        .post("/api/v1/tasks") 
    .then()
    .log().all()                          
        .assertThat()
        .statusCode(400)                                 
        .body(containsString("Bad Request"));
}

//Get 
@Test
public void shouldBeAbleToGetATodoByID() {
    // JSON body for adding a task
  
	String taskID ="696281d9984600001546a0de";
    String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5NjE2MGQ5OGU5OGFhMDAxNTdjZWM2ZCIsImZpcnN0TmFtZSI6IkhhdGVtIiwibGFzdE5hbWUiOiJIYXRlbUxhIiwiaWF0IjoxNzY3OTk0MDE5fQ.I3c4uR-PeBLanQMsVuPt3Fw_ZshMvFjt8XHvhx6FeO0";
    given()
        .baseUri("https://qacart-todo.herokuapp.com/") 
        .contentType(ContentType.JSON)                 
        .auth().oauth2(token)
    // Send POST request to add task
    .when()
        .get("/api/v1/tasks/"+taskID) //get  id=696281d9984600001546a0de
    
    .then()
    	.log().all()                            // Print full response for debugging
        .assertThat()
        .statusCode(200)                             
        .body("item", equalTo("houda"))              // Verify that task name is correct
        .body("isCompleted", equalTo(false))    ;      // Verify that isCompleted is false
}
@Test
//delete
 
public void shouldBeAbleToDeleteATodo() {
	  
		String taskID ="69628753984600001546a154";
	    String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5NjE2MGQ5OGU5OGFhMDAxNTdjZWM2ZCIsImZpcnN0TmFtZSI6IkhhdGVtIiwibGFzdE5hbWUiOiJIYXRlbUxhIiwiaWF0IjoxNzY3OTk0MDE5fQ.I3c4uR-PeBLanQMsVuPt3Fw_ZshMvFjt8XHvhx6FeO0";
	   
	    given()
	        .baseUri("https://qacart-todo.herokuapp.com/") 
	        .contentType(ContentType.JSON)                 
	        .auth().oauth2(token)
	    .when()
	        .delete("/api/v1/tasks/"+taskID) //get  id=69628753984600001546a154( tje crre puis delete)   
	    .then()
	    	.log().all()                         
	        .assertThat()
	        .statusCode(200)                              
	        .body("item", equalTo("houda"))          
	          ;    
	}
}
