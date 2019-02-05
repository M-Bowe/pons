package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.ErrorResponse;
import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.tempModels.EscrowAddresses;
import com.pons.bridge.web3j.ERC20ContractService;
import com.pons.bridge.web3j.EscrowContractService;

// TODO: Add block checking 
@Service("erc20Service")
public class ERC20Service {

	@Autowired
	private ERC20ContractService erc20ContractService;
	
	public Response createContract() {
		erc20ContractService.createERC20();
		return new SuccessfulResponse("Successfully Created ERC 20", true);
	}
	
	public Response transfer(String address, String amount){
		erc20ContractService.transfer(address, amount);
		return new SuccessfulResponse("Transfered " + amount + " to " + address, true);
	}

	public Response balance(String address) {
		String balance = erc20ContractService.getBalance(address);
		return new SuccessfulResponse(address + " checking balance", balance);
	}

}
