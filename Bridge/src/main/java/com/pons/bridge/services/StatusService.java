package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.web3j.EthereumStatus;

@Service("statusService")
public class StatusService {

	@Autowired
	private EthereumStatus status;
	
	public Response getBalance(String address){
		return new SuccessfulResponse("Retreived balance for " + address, status.getBalance(address));
	}
	
}
