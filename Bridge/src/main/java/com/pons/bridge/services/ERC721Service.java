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
		return new SuccessfulResponse("Successfully Created ERC 721", true);
	}
	
	public Response transfer(String addressFrom, String addressTo, String tokenId){
		erc721ContractService.transfer(addressFrom, addressTo, tokenId);
		return new SuccessfulResponse("Transfered RokenId: " + tokenId + " to " + addressTo, true);
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

	public Response setApprove(String address, boolean approved) {
		erc721ContractService.approve(address, approved);
		return new SuccessfulResponse("Attempted to approve " + address, address);
	}

	public Response transferToken(String addressTo, String tokenId) {
		erc721ContractService.tranferToken(addressTo, tokenId);
		return new SuccessfulResponse("Attempted to transfer " + tokenId + " to " + addressTo, addressTo);
	}
}
