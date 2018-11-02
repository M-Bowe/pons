package com.pons.web3j;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.contracts.MonetaryToken;
import com.pons.contracts.PonsERC721;

@Service("createTokens")
public class CreateTokens {

//	String walletFileName = WalletUtils.generateFullNewWalletFile(password,new File("Keystore path"));

	private Web3j web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	
	public CreateTokens(){
		masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
		
	public boolean createERC20(){
		System.out.println("Deploying smart contract ERC721");
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
        masterNode.setErc20Token(erc20contract);
        return true;
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
        masterNode.setErc721Contract(erc721Contract);
        return true;
	}
   
}
