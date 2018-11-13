package com.pons.bridge.web3j;

import java.io.IOException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.contracts.PonsERC721;

public class MasterNode {
	
	private static MasterNode masterNode;
	private Web3j web3j;
	private Credentials credentials;
	private String erc20ContractAddress;
	private String erc721ContractAddress;
	
	private MasterNode(){
		System.out.println("\n\n***********************");
		System.out.println("http://localhost:22000");
		System.out.println("***********************\n\n");
		try {
			web3j = Web3j.build(new HttpService("http://localhost:22000"));
			System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
			credentials = WalletUtils.loadCredentials("", "/home/quorum-examples/examples/7nodes/keys/key1");
		} catch (IOException | CipherException e) {
			e.printStackTrace();
			System.out.println("MasterNode failed to load");
		}
	}
	
	public static MasterNode getInstance(){
		if(masterNode == null){
			masterNode = new MasterNode();
		}
		return masterNode;
	}

	public Web3j getWeb3j() {
		return web3j;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public String getErc20TokenAddress() {
		return erc20ContractAddress;
	}

	public void setErc20TokenAddress(String address) {
		this.erc20ContractAddress = address;
	}

	public String getErc721ContractAddress() {
		return erc721ContractAddress;
	}

	public void setErc721ContractAddress(String address) {
		this.erc721ContractAddress = address;
	}
}
