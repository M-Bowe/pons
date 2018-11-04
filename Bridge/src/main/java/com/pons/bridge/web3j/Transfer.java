package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("tansfer")
public class Transfer {
	
	private Web3j web3j;
	private MasterNode masterNode;
	
	@Autowired
	private TokenFactory tokenFactory;
	
	public Transfer(){
		masterNode = MasterNode.getInstance();
		web3j = masterNode.getWeb3j();
	}
	
	public boolean ERC20Transfer(String toAddress, String value){
		TransactionReceipt trans;
		try {
			trans = tokenFactory.loadERC20Token(masterNode.getCredentials()).transfer(toAddress, new BigInteger(value)).send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return trans.isStatusOK();
	}
	
	public boolean changePassword(){
		TransactionReceipt trans;
		try {
			trans = tokenFactory.loadERC20Token(masterNode.getCredentials()).setPassword("password123").send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return trans.isStatusOK();
	}
	
	public boolean checkLock(){
		Boolean isLockOk;
		try {
			isLockOk = tokenFactory.loadERC20Token(masterNode.getCredentials()).checkLockStatus("password123", masterNode.getCredentials().getAddress()).send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return isLockOk;
	}
	
	
}
