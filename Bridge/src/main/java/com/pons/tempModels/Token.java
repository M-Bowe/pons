package com.pons.tempModels;

public class Token {

	String token;
	
	int spoofUserId;
	
	public Token() {}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getSpoofUserId() {
		return spoofUserId;
	}

	public void setSpoofUserId(int spoofUserId) {
		this.spoofUserId = spoofUserId;
	}
}
