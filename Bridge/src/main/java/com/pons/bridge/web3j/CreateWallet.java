package com.pons.bridge.web3j;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

@Service("createWallet")
public class CreateWallet {

	private Web3j web3j;
	private Credentials credentials;
	private MasterNode masterNode;
	
	public CreateWallet(){
		masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
	
	public String createWallet(){
		String walletFileName = null;
		try {
			walletFileName = WalletUtils.generateFullNewWalletFile("",new File("${web3j.keystore}"));
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | CipherException | IOException e) {
			e.printStackTrace();
		}
		return walletFileName;
	}
   
}
