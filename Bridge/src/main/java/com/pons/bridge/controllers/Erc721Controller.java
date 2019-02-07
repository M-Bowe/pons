package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.ERC20Service;
import com.pons.bridge.services.ERC721Service;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "/erc721")
@EnableAutoConfiguration
public class Erc721Controller {
	
	@Autowired
	public ERC721Service erc721Service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/init")
    public Response create() {
		return erc721Service.createContract();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/transfer")
    public Response transfer(
    		@RequestParam("addressFrom") String addressFrom,
    		@RequestParam("addressTo") String addressTo,
    		@RequestParam("tokenId") String tokenId) {
		return erc721Service.transfer(addressFrom, addressTo, tokenId); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/transfer_token")
    public Response transferToken(
    		@RequestParam("addressTo") String addressTo,
    		@RequestParam("tokenId") String tokenId) {
		return erc721Service.transferToken(addressTo, tokenId); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/balance")
    public Response balance(@RequestParam("address") String address) {
		return erc721Service.balance(address); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/createLoan")
    public Response createLoan(
    		@RequestParam("name") String name,
    		@RequestParam("addressTo") String address,
    		@RequestParam("balance") String balance
    		) {
		return erc721Service.mint(name, address, balance);
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/approve")
	public Response setApprove(
    		@RequestParam("addressTo") String address,
    		@RequestParam("id") String id
    		) {
		return erc721Service.setApprove(address, id);
	}
}
