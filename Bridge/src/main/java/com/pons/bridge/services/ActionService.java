package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.ErrorResponse;
import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.web3j.Transfer;
import com.pons.bridge.web3j.WalletStore;

// TODO: Add block checking 
@Service("actionService")
public class ActionService {

	@Autowired
	private Transfer transfer;

	@Autowired
	private WalletStore wallet;

	private String password;

	public Response transferERC20(String toAddress, String value){
		if(transfer.ERC20Transfer(toAddress, value)){
			return new SuccessfulResponse(value + " has been transfered to " + toAddress, true);
		}
		return new ErrorResponse(value + " has been transfered to " + toAddress);
	}

	public Response createWallet(){
		return new SuccessfulResponse("Wallet created", wallet.createWallet());
	}

	public Response generatePassword(){
		// TODO: Replace with hashed value
		password = "password123"
		return new SuccessfulResponse("Password created: " + password, true)
	}

}
