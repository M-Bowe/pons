package com.pons.bridge.responses;

public class Response {
	private String message;
	private boolean error;
	private Object data;
	
	public Response(String message, Boolean error, Object data){
		this.message = message;
		this.error = error;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public boolean isError() {
		return error;
	}

	public Object getData() {
		return data;
	}
	
}
