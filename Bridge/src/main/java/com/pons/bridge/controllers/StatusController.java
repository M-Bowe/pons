package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.ActionService;
import com.pons.bridge.services.InitService;
import com.pons.bridge.services.StatusService;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "status")
@EnableAutoConfiguration
public class StatusController {
	
	@Autowired
	public StatusService statusService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc20Balance")
    public Response transferERC20(@RequestParam("address") String address) {
		System.out.println("Checking balance of " + address);
		return statusService.getBalance(address);
	}
	
}
