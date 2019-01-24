package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.MonetaryToken;

@Service("erc20ContractService")
public class ERC20ContractService {

	private Web3j web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	
	public ERC20ContractService(){
		masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
		
	public boolean createERC20(){
		System.out.println("Deploying smart contract ERC20");
        ContractGasProvider contractGasProvider = new DeployGasProvider();
        MonetaryToken erc20contract;
        try{
        	erc20contract = MonetaryToken.deploy(web3j, credentials, contractGasProvider).send();
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
        String contractAddress = erc20contract.getContractAddress();
        System.out.println("ERC20 deployed to: " + contractAddress);
        masterNode.setErc20TokenAddress(erc20contract.getContractAddress());
        return true;
	}
	
	public MonetaryToken loadERC20Token(Credentials credentials){
		String contractAddress = masterNode.getErc20TokenAddress();
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return MonetaryToken.load(contractAddress, web3j, credentials, contractGasProvider);
	}

	public void transfer(String address, String amount) {
		MonetaryToken contract = loadERC20Token(credentials);
		try {
			contract.transfer(address, new BigInteger(amount)).send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBalance(String address) {
		MonetaryToken contract = loadERC20Token(credentials);
		try {
			return contract.balanceOf(address).send().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
