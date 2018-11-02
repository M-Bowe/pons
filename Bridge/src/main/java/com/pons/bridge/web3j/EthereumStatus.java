package com.pons.bridge.web3j;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

@Service("ethereumStatus")
public class EthereumStatus {

//	String walletFileName = WalletUtils.generateFullNewWalletFile(password,new File("Keystore path"));

	private Web3j web3j;
	
	public EthereumStatus(){
		MasterNode masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
	}
	
	public int getCurrentBlock() throws IOException{
		return web3j.ethBlockNumber().send().getBlockNumber().intValue();
	}
}
