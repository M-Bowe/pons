package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.ERC20Service;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "/erc20")
@EnableAutoConfiguration
public class Erc20Controller {
	
	@Autowired
	public ERC20Service erc20Service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/init")
    public Response createERC20() {
		return erc20Service.createContract();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/transfer")
    public Response transfer(
    		@RequestParam("address") String address,
    		@RequestParam("amount") String amount) {
		return erc20Service.transfer(address, amount); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/balance")
    public Response balance(@RequestParam("address") String address) {
		return erc20Service.balance(address); 
	}

}
