package com.qacart.todo.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qacart.todo.api.ApiRequest;
import com.qacart.todo.models.ToDoWithSetters;
import com.qacart.todo.utils.TokenHolder;

import io.restassured.response.Response;

public class ToDoWithSettersTest {
	@Test(priority = 3)
	public void shouldBeAbleToAddTodo() {
		// Token → Header
		// Body → JSON (POJO nécessaire)(payload)
	

		ToDoWithSetters add = new ToDoWithSetters();
		add.setItem("TestAPI1");
		add.setIsCompleted(false);
	//String token = "JIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5OTFjNDkxNzdhYTYxMDAxNThkYWJkMyIsImZpcnN0TmFtZSI6IllhbWluYSIsImxhc3ROYW1lIjoiQWNob3VyIiwiaWF0IjoxNzcxMTY4OTU3fQ.Ynzh-XtZfR51yw0Vl6jr5_1DFP97GTg9hjeAJRHbDvg";
		  //  Récupérer le token automatiquement -->Utiliser le token stocké
	    String token = TokenHolder.getToken();
		Response response = ApiRequest.postWithAuth("/api/v1/tasks", add, token);
		

		// Vérifications

		// ✅ Mapper en POJO
		ToDoWithSetters todo = response.as(ToDoWithSetters.class);

		// ✅ Clean et lisible
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(todo.getIsCompleted(), false);
		Assert.assertEquals(todo.getItem(), "TestAPI1");// (response.path("item"), "TestAPI1");

		System.out.println("✅ add réussi!");
	}

	@Test
	public void shouldNotBeAbleToAddTodoIfIsCompletedIsMissing() {
		// Créer le payload

		ToDoWithSetters add = new ToDoWithSetters();
		add.setItem("TestAPI1");

		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5OTFjNDkxNzdhYTYxMDAxNThkYWJkMyIsImZpcnN0TmFtZSI6IllhbWluYSIsImxhc3ROYW1lIjoiQWNob3VyIiwiaWF0IjoxNzcxMTY4NTQ2fQ.av2_qns6eOihgOhA2hAqfu1NHDisxyxkAPOj8qYlW8E";
		Response response = ApiRequest.postWithAuth("/api/v1/tasks", add, token);
		// Vérifications
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.path("message"), "\"isCompleted\" is required");

	}// Get
//ID → URL
//Token → Header
//Body → VIDE
	@Test
	public void shouldBeAbleToGetATodoByID() {
		// JSON body for adding a task

		String taskID = "6991c49177aa6100158dabd3";
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5N2Y0ZjVhNjBjODNhMDAxNTE5YjQ4MCIsImZpcnN0TmFtZSI6IllhbWluYSIsImxhc3ROYW1lIjoiQWNob3VyIiwiaWF0IjoxNzY5OTY4MzIyfQ.al9jPmhss_RuLACNUNAVPJp4yuJxjY61jkJEpEPOQlw";
		Response response = ApiRequest.getWithAuth("/api/v1/tasks/" + taskID, token);
		// Vérifications
		Assert.assertEquals(response.getStatusCode(), 200);

		ToDoWithSetters todo = response.as(ToDoWithSetters.class);

		Assert.assertEquals(response.path("_id"), taskID);
		Assert.assertEquals(todo.getIsCompleted(), false);
		Assert.assertEquals(todo.getItem(), "TestAPI1");// (response.path("item"), "TestAPI1");
		Assert.assertEquals(todo.getId(), taskID);
	}

	@Test
//delete

	public void shouldBeAbleToDeleteATodo() {
		String taskID = "697f98a960c83a001519b778";
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5N2Y0ZjVhNjBjODNhMDAxNTE5YjQ4MCIsImZpcnN0TmFtZSI6IllhbWluYSIsImxhc3ROYW1lIjoiQWNob3VyIiwiaWF0IjoxNzY5OTY4MzIyfQ.al9jPmhss_RuLACNUNAVPJp4yuJxjY61jkJEpEPOQlw";
		Response response = ApiRequest.deleteWithAuth("/api/v1/tasks/" + taskID, token);
//	  // Vérifications

		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
