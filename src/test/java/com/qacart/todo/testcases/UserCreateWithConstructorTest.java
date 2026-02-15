package com.qacart.todo.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qacart.todo.api.ApiRequest;
import com.qacart.todo.models.UserCreateWithConstructor;

import io.restassured.response.Response;

public class UserCreateWithConstructorTest {


    @Test(priority = 1)
    public void userShouldBeRegister() {
        
    	  // Création de l'utilisateur avec le constructeur complet
        UserCreateWithConstructor user = new UserCreateWithConstructor(
            "Yamina", "Achour", "yamina9@example.com", "Abc@1236");

        // Envoyer la requête POST
        Response response = ApiRequest.post("/api/v1/users/register", user);

        // Vérifications
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.path("firstName"), "Yamina");
        
        System.out.println("✅ Register réussi!");
    }
 //2.login

@Test(priority = 2)
public void shouldBeAbleToLogin() {
    
    // Pour login: seulement email et password
	UserCreateWithConstructor user = new UserCreateWithConstructor("yamina9@example.com","Abc@1236");
    

    Response response = ApiRequest.post("/api/v1/users/login", user);

    // Vérifications
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.path("firstName"), "Yamina");
    Assert.assertNotNull(response.path("access_token"));
    Assert.assertNotNull(response.path("userID"));
    
    // 🔑 Récupérer le token pour les prochains tests
    String accessToken = response.path("access_token");
    System.out.println("✅ Login réussi! Token: " + accessToken);
}
}

//---> getteur








