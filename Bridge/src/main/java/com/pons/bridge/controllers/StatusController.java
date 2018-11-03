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

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "transfer")
@EnableAutoConfiguration
public class StatusController {
	
	@Autowired
	public ActionService actions;
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc20")
    public Response transferERC20(@RequestParam("address") String toAddress, @RequestParam("value") String value) {
		System.out.println("Transfering " + value + " to " + toAddress);
		return actions.transferERC20(toAddress, value);
	}
	
}
