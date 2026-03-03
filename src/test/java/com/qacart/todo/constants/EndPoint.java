package com.qacart.todo.constants;

public enum EndPoint {

	//  User endpoints
    REGISTER("/api/v1/users/register"),
    LOGIN("/api/v1/users/login"),
    // Todo endpoints  
    TODOS("/api/v1/tasks"),
    TODO_BY_ID("/api/v1/tasks/{id}"); 
    
    
	public final String url;

	EndPoint(String url) {
		this.url = url;
	}
    /**
     * Remplacer {id} par un vrai ID
     * Exemple : EndPoint.TODO_BY_ID.withId("abc123") 
     *           → "/api/v1/tasks/abc123"
     */
    public String withId(String id) {
        return this.url.replace("{id}", id);}
	
	
}
