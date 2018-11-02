package com.pons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.responses.Response;
import com.pons.responses.SuccessfulResponse;
import com.pons.web3j.CreateTokens;

@Service("initService")
public class InitService {

	@Autowired
	private CreateTokens createToken;
	
	public Response initERC20() {
		boolean successful = createToken.createERC20();
		return new SuccessfulResponse("Initialized", successful);
	}
	
	public Response initERC721() {
		boolean successful = createToken.createERC721();
		return new SuccessfulResponse("Initialized", successful);
	}
	
}
