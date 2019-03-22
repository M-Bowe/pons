package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.BlockchainService;
import com.pons.bridge.services.ERC20Service;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "/blockchain")
@EnableAutoConfiguration
public class BlockchainController {
	
	@Autowired
	public BlockchainService blockchainService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getLatestBlock")
    public Response getLatestBlock() {
		return blockchainService.getLatestBlock();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCurrentBlockNum")
    public Response getTransactionsFromBlockNum(@RequestParam("blockNum") String blockNum) {
		return blockchainService.getBlock(blockNum);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTransactions")
    public Response getTransac(@RequestParam("num") int numOfTransactions) {
		return blockchainService.getTransactions(numOfTransactions);
	}
}
