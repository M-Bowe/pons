package com.pons.bridge.services;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.ErrorResponse;
import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.tempModels.EscrowAddresses;
import com.pons.bridge.web3j.EscrowContractService;

// TODO: Add block checking 
@Service("escrowService")
public class EscrowService {

	@Autowired
	private EscrowContractService escrowService;
	
	public Response createContracts(String erc20from, String erc20to, String erc20Amount, String erc721from, String erc721to, String erc721Id, String timelimit, String passcode) {
		String erc20EscrowAddress = createERC20Chain(erc20from, erc20to, erc20Amount, timelimit, passcode);
		String erc721EscrowAddress = createERC721Chain(erc721from, erc721to, erc721Id, timelimit, passcode);
		return new SuccessfulResponse("Successfully Created Escrow", new EscrowAddresses(erc20EscrowAddress, erc721EscrowAddress));
	}

	private String createERC721Chain(String erc721from, String erc721to, String erc721Id, String timelimit, String passcode) {
		return escrowService.createEscrowOnERC721(erc721from, erc721to, new BigInteger(erc721Id), passcode);
	}

	private String createERC20Chain(String erc20from, String erc20to, String erc20Amount, String timelimit, String passcode) {
		return escrowService.createEscrowOnERC20(erc20from, erc20to, new BigInteger(erc20Amount), passcode);
	}

	public Response approveERC20(String address, String passcode) {
		if(escrowService.approveERC20(address, passcode)){
			return new SuccessfulResponse("Funds for ERC20 have been released", address);
		}else{
			return new ErrorResponse("Password Incorrect");
		}
	}
	
	public Response approveERC721(String address, String passcode) {
		if(escrowService.approveERC721(address, passcode)){
			return new SuccessfulResponse("Funds for ERC721 have been released", address);
		}else{
			return new ErrorResponse("Password Incorrect");
		}
	}

}
