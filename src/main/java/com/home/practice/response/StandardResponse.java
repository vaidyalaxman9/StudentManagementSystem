package com.home.practice.response;

public class StandardResponse {
	public boolean status;
	public String message;

	public StandardResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}