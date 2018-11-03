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
public class WalletStore {
	
	public String createWallet(){
		String walletFileName = null;
		try {
			walletFileName = WalletUtils.generateFullNewWalletFile("",new File("/keys"));
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | CipherException | IOException e) {
			e.printStackTrace();
		}
		return walletFileName;
	}
   
}
