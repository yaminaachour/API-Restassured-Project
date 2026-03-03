package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Les champs null ne sont pas envoyés

//3.les objet json POJO : les modules des donnees  page -->pojo
public class UserCreateWithSetters {


    // ══════════════════════════════════════════
    // 📤 Champs de la REQUÊTE (ce que TU envoies)
    // ══════════════════════════════════════════
    // Register/Login
	private String firstName;
	private String lastName;
    private String email;
    private String password;
    
    // ══════════════════════════════════════════
    //  Champs de la RÉPONSE (ce que l'API te renvoie)
    // ══════════════════════════════════════════
    //la réponse Login
 
    @JsonProperty("access_token")   // "access_token" dans JSON → accessToken en Java
    private String accessToken;
    
    @JsonProperty("userID")         // "userID" dans JSON → userId en Java
    private String userId;
	

    
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
    // --- accessToken (de la réponse) ---
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    // --- userId (de la réponse) ---
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
	
	

