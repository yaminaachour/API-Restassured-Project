package com.qacart.todo.api;

import com.qacart.todo.utils.ConfigLoader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;


public class SpecBuilder {
    

	//1.centralise url(request/rep)
	
	 // ═══════════════════════════════════════════════════════════════
    // Pour requêtes JSON (POST/PUT/PATCH avec body JSON)
    // ═══════════════════════════════════════════════════════════════
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
        		.setBaseUri(ConfigLoader.getInstance().getBaseUrl())

                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    // ═══════════════════════════════════════════════════════════════
    // Pour requêtes FORM (login, formulaires HTML)
    // ═══════════════════════════════════════════════════════════════
    public static RequestSpecification getRequestSpecForm() {
        return new RequestSpecBuilder()
        		.setBaseUri(ConfigLoader.getInstance().getBaseUrl())
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL)
                .build();
    }

    // ═══════════════════════════════════════════════════════════════
    // Spécification de réponse (commune)
    // ═══════════════════════════════════════════════════════════════
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}

