package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.EscrowContract;
import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

@Service("erc721ContractService")
public class ERC721ContractService {

	private Web3j web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	
	public ERC721ContractService(){
		masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
    
	public boolean createERC721(){
        System.out.println("Deploying smart contract ERC721");
        ContractGasProvider contractGasProvider = new DeployGasProvider();
        PonsERC721 erc721Contract;
		try {
			erc721Contract = PonsERC721.deploy(web3j, credentials, contractGasProvider).send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        String contractAddress = erc721Contract.getContractAddress();
        System.out.println("ERC721 deployed to: " + contractAddress);
        masterNode.setErc721ContractAddress(erc721Contract.getContractAddress());
        return true;
	}
	
	public PonsERC721 loadERC721Token(Credentials credentials){
		String contractAddress = masterNode.getErc721ContractAddress();
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return PonsERC721.load(contractAddress, web3j, credentials, contractGasProvider);
	}
	
	public void transfer(String address, String tokenID) {
		PonsERC721 contract = loadERC721Token(credentials);
		try {
			contract.safeTransferFrom(credentials.getAddress(), address, new BigInteger(tokenID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBalance(String address) {
		PonsERC721 contract = loadERC721Token(credentials);
		try {
			return contract.balanceOf(address).send().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
