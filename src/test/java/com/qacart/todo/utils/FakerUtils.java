package com.qacart.todo.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	
	    private static Faker faker = new Faker();

	    public static String generateFirstName() {
	        return faker.name().firstName();
	    }

	    public static String generateLastName() {
	        return faker.name().lastName();
	    }

	    public static String generateEmail() {
	        return faker.internet().emailAddress();
	    }

	    public static String generatePassword() {
	        return "Abc@" + faker.number().digits(4);
	    }
	}
	

