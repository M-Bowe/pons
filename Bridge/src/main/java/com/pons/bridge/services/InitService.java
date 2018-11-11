package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.web3j.TokenFactory;

@Service("initService")
public class InitService {

	@Autowired
	private TokenFactory createToken;
	
	public Response initERC20() {
		boolean successful = createToken.createERC20();
		return new SuccessfulResponse("Initialized", successful);
	}
	
	public Response initERC721() {
		boolean successful = createToken.createERC721();
		return new SuccessfulResponse("Initialized", successful);
	}

	public Response initEscrowERC20(String from, String to, String passcode, String quantity) {
		boolean successful = createToken.createEscrowERC20(from, to, passcode, quantity);
		return new SuccessfulResponse("Initialized", successful);
	}
	
}
