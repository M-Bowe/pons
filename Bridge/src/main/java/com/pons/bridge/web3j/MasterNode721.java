package com.pons.bridge.web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;

import com.pons.bridge.contracts.MonetaryToken;

public class MasterNode721 {
	
	private static MasterNode721 masterNode;
	private Quorum web3j;
	private Credentials credentials;
	private String erc721ContractAddress;
	
	private MasterNode721(){
		System.out.println("\n\n***********************");
		System.out.println("http://localhost:22004");
		System.out.println("***********************\n\n");
		try {
			web3j = Quorum.build(new HttpService("http://localhost:22004"));
			System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
			credentials = WalletUtils.loadCredentials("", "/home/quorum-examples/examples/erc721Chain/keys/key1");
		} catch (IOException | CipherException e) {
			e.printStackTrace();
			System.out.println("MasterNode failed to load");
		}
	}
	
	public static MasterNode721 getInstance(){
		if(masterNode == null){
			masterNode = new MasterNode721();
		}
		return masterNode;
	}

	public Quorum getWeb3j() {
		return web3j;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public String getErc721ContractAddress() {
		return erc721ContractAddress;
	}

	public void setErc721ContractAddress(String address) {
		this.erc721ContractAddress = address;
	}
	
	public List<EthBlock.TransactionResult> getTransactionsByBlockNum(String blockNum){
		try {
			return web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(new BigInteger(blockNum)), true).send().getBlock().getTransactions();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BigInteger getLatestBlockNum(){
		try {
			return web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, true).send().getBlock().getNumber();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List getTransactions(int numOfTransactions) {
		ArrayList<EthBlock.TransactionResult> transactionList = new ArrayList<>();
		int latestBlock = getLatestBlockNum().intValue();
		while(transactionList.size() < numOfTransactions && latestBlock >= 0){
			transactionList.addAll(getTransactionsByBlockNum(String.valueOf(latestBlock)));
			latestBlock--;
		}
		return transactionList;
	}
}
