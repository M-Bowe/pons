package com.pons.bridge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.bridge.responses.ErrorResponse;
import com.pons.bridge.responses.Response;
import com.pons.bridge.responses.SuccessfulResponse;
import com.pons.bridge.tempModels.EscrowAddresses;
import com.pons.bridge.web3j.ERC20ContractService;
import com.pons.bridge.web3j.EscrowContractService;
import com.pons.bridge.web3j.MasterNode;

// TODO: Add block checking 
@Service("blockchainService")
public class BlockchainService {
	
	private MasterNode master;
	
	public BlockchainService(){
		master = MasterNode.getInstance();
	}
	
	public Response getLatestBlock(){
		return new SuccessfulResponse("Retreived Latest Block Number", master.getLatestBlockNum());
	}
	
	public Response getBlock(String blockNum){
		return new SuccessfulResponse("Retreived Block", master.getTransactionsByBlockNum(blockNum));
	}

	public Response getTransactions(int numOfTransactions) {
		return new SuccessfulResponse("Retreived " + numOfTransactions + " Transactions", master.getTransactions(numOfTransactions));
	}

}
