package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserCreateWithConstructor {
	
	
	
	private String firstName;
	private String lastName;
    private String email;
    private String password;
	
    
    
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	
	  // Constructeur vide (nécessaire pour Jackson)
    public UserCreateWithConstructor() {}	

	  //methode register 
	    public UserCreateWithConstructor(String firstName, String lastName, String email, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	    }
	    //methode register 
	    public UserCreateWithConstructor(String email, String password) {
	        this.email = email;
	        this.password = password;
	    }

}

