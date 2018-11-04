package com.pons.bridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pons.bridge.responses.Response;
import com.pons.bridge.services.InitService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "init")
@EnableAutoConfiguration
public class InitController {
	
	@Autowired
	public InitService initService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc20")
    public Response createERC20() {
		return initService.initERC20();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/erc721")
    public Response createERC721() {
		return initService.initERC721();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/stop")
    public Response stop() {
		System.exit(0);
		return null;
	}
}
