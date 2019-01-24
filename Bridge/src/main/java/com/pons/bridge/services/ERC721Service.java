package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.ErrorResponse;
import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.tempModels.EscrowAddresses;
import com.pons.bridge.web3j.ERC721ContractService;
import com.pons.bridge.web3j.EscrowContractService;

// TODO: Add block checking 
@Service("erc721Service")
public class ERC721Service {

	@Autowired
	private ERC721ContractService erc721ContractService;
	
	public Response createContract() {
		erc721ContractService.createERC721();
		return new SuccessfulResponse("Successfully Created Escrow", true);
	}
	
	public Response transfer(String address, String tokenId){
		erc721ContractService.transfer(address, tokenId);
		return new SuccessfulResponse("Transfered RokenId: " + tokenId + " to " + address, true);
	}

	public Response balance(String address) {
		String balance = erc721ContractService.getBalance(address);
		return new SuccessfulResponse(address + " checking balance", balance);
	}

	public Response mint(String name, String address, String balance) {
		if(erc721ContractService.mint(name, address, balance)){
			return new SuccessfulResponse("Successfully Minted to " + address, address);
		}
		return new ErrorResponse("Issue Creating Loan");
	}
}
