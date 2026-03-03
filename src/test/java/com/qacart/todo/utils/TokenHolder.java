package com.qacart.todo.utils;

public class TokenHolder {
// Solution : Stocker le token dans une variable statique partagée
	
	//stocker le token
	
	private static String accessToken;  // Variable statique = partagée entre TOUTES les classes


    public static String getToken() {
        return accessToken;
    }

    public static void setToken(String token) {
        accessToken = token;
    }
	
	
	

}
