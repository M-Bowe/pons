package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.EscrowContract;
import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

@Service("escrowContractService")
public class EscrowContractService {

	private Web3j erc20Web3j;
	private Web3j erc721Web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	
	public EscrowContractService(){
		masterNode = MasterNode.getInstance();
		erc20Web3j = masterNode.getWeb3j();
		erc721Web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
	
	public String createEscrowOnERC721(String from, String to, String tokenId, String passcode){
        System.out.println("Deploying Escrow to ERC721 Chain");
        String contractAddress = createEscrow(erc721Web3j, to, from, tokenId, passcode);
        System.out.println("Escrow deployed to ERC721 Chain: " + contractAddress);
        return contractAddress;
	}
	
	public String createEscrowOnERC20(String from, String to, String quantity, String passcode){
		System.out.println("Deploying Escrow to ERC20 Chain");
		String contractAddress = createEscrow(erc20Web3j, to, from, quantity, passcode);
        System.out.println("Escrow deployed to ERC20 Chain: " + contractAddress);
        return contractAddress;
	}
	
	private String createEscrow(Web3j web3j, String to, String from, String quantity, String passcode){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
        EscrowContract escrowContract;
		try {
			escrowContract = EscrowContract.deploy(web3j, credentials, contractGasProvider).send();
			escrowContract.setParams(from, to, passcode, new BigInteger(quantity)).sendAsync();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        return escrowContract.getContractAddress();
	}
	
	public EscrowContract loadEscrowfromERC20Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowContract.load(contractAddress, erc20Web3j, credentials, contractGasProvider);
	}
	
	public EscrowContract loadEscrowfromERC721Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowContract.load(contractAddress, erc721Web3j, credentials, contractGasProvider);
	}
   
}