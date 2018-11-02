package com.pons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pons.responses.Response;
import com.pons.services.InitService;

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
}
