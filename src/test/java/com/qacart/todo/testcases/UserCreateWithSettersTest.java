package com.qacart.todo.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qacart.todo.utils.FakerUtils;
import com.qacart.todo.api.ApiRequest;
import com.qacart.todo.models.UserCreateWithSetters;

import io.restassured.response.Response;

public class UserCreateWithSettersTest {


    @Test(priority = 1)
    public void userShouldBeRegister() {
        
        // Créer l'objet user avec Setters
        UserCreateWithSetters user = new UserCreateWithSetters();
        user.setFirstName("Yamina");
        user.setLastName("Achour");
        user.setEmail("yamina9@example.com");
        user.setPassword("Abc@1236");

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
    UserCreateWithSetters user = new UserCreateWithSetters();
    user.setEmail("yamina9@example.com");
    user.setPassword("Abc@1236");


    Response response = ApiRequest.post("/api/v1/users/login", user);

    // Vérifications
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.path("firstName"), "Yamina");
    Assert.assertNotNull(response.path("access_token"));
    Assert.assertNotNull(response.path("userID"));
    
    // 🔑 Récupérer le token pour les prochains tests
 
    
    // Récupérer le token
    String accessToken = response.path("access_token");
    System.out.println("✅ Login réussi! Token: " + accessToken);
 
   

}


//---> getteur




//with faker :Impossible de lancer Login seul

// ⭐ Variables de classe pour stocker les données générées
private String generatedEmail;
private String generatedPassword;
private String generatedFirstName;
// with faker 
@Test(priority = 1)
public void userShouldBeRegisterwithfaker() {
    
    //  Utiliser FakerUtils pour générer des données dynamiques
	 //  Générer les données avec FakerUtils
    generatedFirstName = FakerUtils.generateFirstName();
    generatedEmail = FakerUtils.generateEmail();
    generatedPassword = FakerUtils.generatePassword();
    
    UserCreateWithSetters user = new UserCreateWithSetters();
    
    user.setFirstName(generatedFirstName);
    user.setLastName(FakerUtils.generateLastName());
    user.setEmail(generatedEmail);
    user.setPassword(generatedPassword);

    Response response = ApiRequest.post("/api/v1/users/register", user);

    Assert.assertEquals(response.getStatusCode(), 201);
    Assert.assertEquals(response.path("firstName"), user.getFirstName());
    
    System.out.println("✅ Register réussi avec: " + generatedEmail);

}    
@Test(priority = 2)
public void shouldBeAbleToLoginfaker() {
    
    // ✅ Réutiliser email/password du register
    UserCreateWithSetters user = new UserCreateWithSetters();
    user.setEmail(generatedEmail);      // eli l9ita lzem n7ota houni
    user.setPassword(generatedPassword);  // Réutilisé!

    Response response = ApiRequest.post("/api/v1/users/login", user);

    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.path("firstName"), generatedFirstName);
    Assert.assertNotNull(response.path("access_token"));
    
    String accessToken = response.path("access_token");
    System.out.println("✅ Login réussi! Token: " + accessToken);
    
}
}




