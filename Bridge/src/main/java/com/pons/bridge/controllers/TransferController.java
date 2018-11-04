package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.ActionService;

@CrossOrigin
@RestController
@RequestMapping(value = "transfer")
@EnableAutoConfiguration
public class TransferController {
	
	@Autowired
	public ActionService actions;
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc20")
    public Response transferERC20(@RequestParam("address") String toAddress, @RequestParam("value") String value) {
		System.out.println("Transfering " + value + " to " + toAddress);
		return actions.transferERC20(toAddress, value);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/createWallet")
    public Response createWallet() {
		System.out.println("Creating new Wallet");
		return actions.createWallet();
	}
	
	
	
}

