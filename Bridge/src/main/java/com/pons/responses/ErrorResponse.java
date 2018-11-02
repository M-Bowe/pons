package com.pons.responses;

public class ErrorResponse extends Response{
	
	public ErrorResponse(String errorMessage){
		super(errorMessage, true, null);
	}
	
}
