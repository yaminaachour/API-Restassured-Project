package com.qacart.todo.constants;

public enum EndPoint {

	LOGIN("/login"),
	APILOGIN(""),
	HOME("");


	public final String url;

	EndPoint(String url) {
		this.url = url;
	}
}
