package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.EscrowService;

@CrossOrigin
@RestController
@RequestMapping(value = "escrow")
@EnableAutoConfiguration
public class EscrowController {

	@Autowired
	public EscrowService escrowService;

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public Response createAndDeployContracts(
			@RequestParam("erc20from") String erc20from,
			@RequestParam("erc20to") String erc20to,
			@RequestParam("erc20Amount") String erc20Amount,
			@RequestParam("erc721from") String erc721from,
			@RequestParam("erc721to") String erc721to,
			@RequestParam("erc721Id") String erc721Id,
			@RequestParam("timelimit") String timelimit,
			@RequestParam("passcode") String passcode
			) {
		System.out.println("Creating Escrow Contracts");
		return escrowService.createContracts(erc20from, erc20to, erc20Amount, erc721from, erc721to, erc721Id, timelimit, passcode);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc20/approve")
	public Response approveERC20(
			@RequestParam("address") String address,
			@RequestParam("passcode") String passcode
			){
		return escrowService.approveERC20(address, passcode);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc721/approve")
	public Response approveERC721(
			@RequestParam("address") String address,
			@RequestParam("passcode") String passcode
			){
		return escrowService.approveERC721(address, passcode);
	}
}
