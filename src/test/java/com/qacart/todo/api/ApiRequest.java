package com.qacart.todo.api;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.Map;
import java.util.Collections;
import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

    // ═══════════════════════════════════════════════════════════
    //  MÉTHODES SIMPLES (pour utilisation rapide):
	//2.methodes generi(post,get,...)
    // ═══════════════════════════════════════════════════════════

    // POST simple avec body JSON
    public static Response post(String endPoint, Object body) {
        return given(getRequestSpec())
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // GET simple
    public static Response get(String endPoint) {
        return given(getRequestSpec())
                .when()
                .get(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // PUT simple avec body JSON
    public static Response put(String endPoint, Object body) {
        return given(getRequestSpec())
                .body(body)
                .when()
                .put(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // DELETE simple
    public static Response delete(String endPoint) {
        return given(getRequestSpec())
                .when()
                .delete(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // PATCH simple avec body JSON
    public static Response patch(String endPoint, Object body) {
        return given(getRequestSpec())
                .body(body)
                .when()
                .patch(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // ═══════════════════════════════════════════════════════════
    // 🔐 MÉTHODES AVEC AUTHENTIFICATION (Token Bearer/OAuth2)
    // ═══════════════════════════════════════════════════════════

    public static Response postWithAuth(String endPoint, Object body, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getWithAuth(String endPoint, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .when()
                .get(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response putWithAuth(String endPoint, Object body, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(body)
                .when()
                .put(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response deleteWithAuth(String endPoint, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .when()
                .delete(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response patchWithAuth(String endPoint, Object body, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(body)
                .when()
                .patch(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    // ═══════════════════════════════════════════════════════════
    // 📝 MÉTHODES AVEC FORM PARAMS (pour login forms, etc.)
    // ═══════════════════════════════════════════════════════════

 // 📝 MÉTHODES AVEC FORM PARAMS (pour login forms, etc.)
 // ═══════════════════════════════════════════════════════════

 public static Response postForm(String endPoint, Map<String, Object> formParams) {
     return given(getRequestSpecForm())
             .formParams(safeMap(formParams))  // ✅ Ajout safeMap
             .when()
             .post(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }

 public static Response putForm(String endPoint, Map<String, Object> formParams) {
     return given(getRequestSpecForm())
             .formParams(safeMap(formParams))  // ✅ Ajout safeMap
             .when()
             .put(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }

 // ═══════════════════════════════════════════════════════════
 // 🔧 MÉTHODES COMPLÈTES (avec tous les paramètres optionnels)
 // ═══════════════════════════════════════════════════════════
//postComplete
 public static Response postComplete(String endPoint, 
                                     Object body,
                                     Map<String, Object> queryParams,
                                     Headers headers, 
                                     Cookies cookies,
                                     String token) {
     var request = given(getRequestSpec())
             .queryParams(safeMap(queryParams))  
             .headers(safeHeaders(headers))
             .cookies(safeCookies(cookies));
     
     if (token != null && !token.isEmpty()) {
         request.auth().oauth2(token);
     }
     if (body != null) {
         request.body(body);
     }
     
     return request
             .when()
             .post(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }
 //getcomplete

 public static Response getComplete(String endPoint,
                                    Map<String, Object> queryParams,
                                    Headers headers,
                                    Cookies cookies,
                                    String token) {
     var request = given(getRequestSpec())
             .queryParams(safeMap(queryParams))  
             .cookies(safeCookies(cookies));
     
     if (token != null && !token.isEmpty()) {
         request.auth().oauth2(token);
     }
     
     return request
             .when()
             .get(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }
 
//put
 public static Response putComplete(String endPoint, 
                                    Object body,
                                    Map<String, Object> queryParams,
                                    Headers headers, 
                                    Cookies cookies,
                                    String token) {
     var request = given(getRequestSpec())
             .queryParams(safeMap(queryParams))  
             .headers(safeHeaders(headers))
             .cookies(safeCookies(cookies));
     
     if (token != null && !token.isEmpty()) {
         request.auth().oauth2(token);
     }
     if (body != null) {
         request.body(body);
     }
     
     return request
             .when()
             .put(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }
 //delete

 public static Response deleteComplete(String endPoint,
                                       Map<String, Object> queryParams,
                                       Headers headers,
                                       Cookies cookies,
                                       String token) {
     var request = given(getRequestSpec())
             .queryParams(safeMap(queryParams)) 
             .headers(safeHeaders(headers))
             .cookies(safeCookies(cookies));
     
     if (token != null && !token.isEmpty()) {
         request.auth().oauth2(token);
     }
     
     return request
             .when()
             .delete(endPoint)
             .then()
             .spec(getResponseSpec())
             .extract()
             .response();
 }

 // ═══════════════════════════════════════════════════════════
 // 🛡️ MÉTHODES UTILITAIRES (protection contre NullPointer)
 // ═══════════════════════════════════════════════════════════

 private static Map<String, Object> safeMap(Map<String, Object> map) {
     return map != null ? map : Collections.emptyMap();
 }

 private static Headers safeHeaders(Headers headers) {
     return headers != null ? headers : new Headers();
 }

 private static Cookies safeCookies(Cookies cookies) {
     return cookies != null ? cookies : new Cookies();
 }}