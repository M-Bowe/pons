package com.pons.bridge.responses;

public class ErrorResponse extends Response{
	
	public ErrorResponse(String errorMessage){
		super(errorMessage, true, null);
	}
	
}
