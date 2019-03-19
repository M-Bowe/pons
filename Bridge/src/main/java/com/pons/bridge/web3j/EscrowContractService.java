package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.EscrowERC20;
import com.pons.bridge.contracts.EscrowERC721;
import com.pons.bridge.contracts.Loan;
import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.responses.Response;

@Service("escrowContractService")
public class EscrowContractService {

	private Quorum erc20Web3j;
	private Quorum erc721Web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	private ContractGasProvider gasProvider;
	
	public EscrowContractService(){
		masterNode = MasterNode.getInstance();
		erc20Web3j = masterNode.getWeb3j();
		erc721Web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
		gasProvider = new DeployGasProvider();
	}
	
	/***************************************************************************************************************
	 ************************************************ ERC 20 *******************************************************
	 **************************************************************************************************************/
	
	public String createEscrowOnERC20(String from, String to, BigInteger quantity, String passcode){
		System.out.println("Deploying Escrow to ERC20 Chain");
		EscrowERC20 escrowContract;
		try {
			escrowContract = EscrowERC20.deploy(erc20Web3j, credentials, gasProvider).send();
			escrowContract.setParams(from, to, passcode, quantity).send();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        String contractAddress = escrowContract.getContractAddress();
        System.out.println("Escrow deployed to ERC20 Chain: " + contractAddress);
        return contractAddress;
	}
	
	public EscrowERC20 loadEscrowfromERC20Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowERC20.load(contractAddress, erc20Web3j, credentials, contractGasProvider);
	}
	
	public boolean approveERC20(String address, String passcode) {
		EscrowERC20 erc20 = loadEscrowfromERC20Chain(address);
		try {
			return erc20.freeFromEscrow(masterNode.getErc20TokenAddress(), passcode).send().isStatusOK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/***************************************************************************************************************
	 ************************************************ ERC 721 ******************************************************
	 **************************************************************************************************************/
	
	public String createEscrowOnERC721(String from, String to, BigInteger tokenId, String passcode){
        System.out.println("Deploying Escrow to ERC721 Chain");
        EscrowERC721 escrowContract;
		try {
			escrowContract = EscrowERC721.deploy(erc721Web3j, credentials, gasProvider).send();
			escrowContract.setParams(from, to, passcode, tokenId).send();
			System.out.println("From: " + from + "  To: " + to + "  Passcode: " + passcode + "  TokenID: " + tokenId);		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        String contractAddress = escrowContract.getContractAddress();
        System.out.println("Escrow deployed to ERC721 Chain: " + contractAddress);
        return contractAddress;
	}
	
	public EscrowERC721 loadEscrowfromERC721Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowERC721.load(contractAddress, erc721Web3j, credentials, contractGasProvider);
	}

	public boolean approveERC721(String address, String passcode) {
		EscrowERC721 erc721 = loadEscrowfromERC721Chain(address);
		System.out.println("Addeess: " + address + "  Passcode: " + passcode + "  erc721Address: " + masterNode.getErc721ContractAddress());
		try {
			return erc721.freeFromEscrow(masterNode.getErc721ContractAddress(), passcode).send().isStatusOK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
   
}