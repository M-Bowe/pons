package com.pons.bridge.web3j;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;

import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

@Service("ethereumStatus")
public class EthereumStatus {

//	String walletFileName = WalletUtils.generateFullNewWalletFile(password,new File("Keystore path"));

	private Web3j web3j;
	private Credentials credentials;
	
	@Autowired
	private TokenFactory tokenFactory;
	
	public EthereumStatus() {
		MasterNode masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
		credentials = masterNode.getCredentials();
	}
	
	public int getCurrentBlock() throws IOException{
		return web3j.ethBlockNumber().send().getBlockNumber().intValue();
	}
	
	public BigInteger getBalance(String account){
		try {
			return tokenFactory.loadERC20Token(credentials).balanceOf(account).send();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
