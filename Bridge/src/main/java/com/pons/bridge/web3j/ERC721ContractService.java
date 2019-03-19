package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.Loan;
import com.pons.bridge.contracts.MonetaryToken;

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
        Loan erc721Contract;
		try {
			erc721Contract = Loan.deploy(web3j, credentials, contractGasProvider).send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        String contractAddress = erc721Contract.getContractAddress();
        System.out.println("ERC721 deployed to: " + contractAddress);
        masterNode.setErc721ContractAddress(erc721Contract.getContractAddress());
        return true;
	}

	public Loan loadERC721Token(Credentials credentials){
		String contractAddress = masterNode.getErc721ContractAddress();
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return Loan.load(contractAddress, web3j, credentials, contractGasProvider);
	}

	public String getBalance(String address) {
		Loan contract = loadERC721Token(credentials);
		try {
			return contract.balanceOf(address).send().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean mint(String name, String address, String balance) {
		Loan contract = loadERC721Token(credentials);
		try {
			return contract.createLoan(name, address, new BigInteger(balance)).send().isStatusOK();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void tranferToken(String addressTo, String tokenId) {
		Loan contract = loadERC721Token(credentials);
		try {
			contract.transfer_token(new BigInteger(tokenId), addressTo).send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
