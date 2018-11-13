package com.pons.bridge.tempModels;

public class EscrowAddresses {

	private String erc20EscrowAddress;
	private String erc721EscrowAddress;
	
	public EscrowAddresses(){}
	
	public EscrowAddresses(String erc20EscrowAddress, String erc721EscrowAddress){
		this.erc20EscrowAddress = erc20EscrowAddress;
		this.erc721EscrowAddress = erc721EscrowAddress;
	}

	public String getErc20EscrowAddress() {
		return erc20EscrowAddress;
	}

	public String getErc721EscrowAddress() {
		return erc721EscrowAddress;
	}
	
}
