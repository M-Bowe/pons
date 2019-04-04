package com.pons.bridge.tempModels;

public class EscrowParams {
	
	private String erc20from;
	private String erc20to;
	private String erc20Amount;
	private String erc721from;
	private String erc721to;
	private String erc721Id;
	
	//SETTERS
	public void setERC20Params(String to, String from, String amount){
		erc20to = to;
		erc20from = from;
		erc20Amount = amount;
	}
	
	public void setERC721Params(String to, String from, String id){
		erc721to = to;
		erc721from = from;
		erc721Id = id;;
	}
	
	//GETTERS
	public String getErc20from() {
		return erc20from;
	}
	public String getErc20to() {
		return erc20to;
	}
	public String getErc20Amount() {
		return erc20Amount;
	}
	public String getErc721from() {
		return erc721from;
	}
	public String getErc721to() {
		return erc721to;
	}
	public String getErc721Id() {
		return erc721Id;
	}
}
