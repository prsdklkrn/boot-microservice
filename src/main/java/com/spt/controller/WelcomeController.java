package com.spt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spt.service.WelcomeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "welcome", description = " Expose welcome and name API endpoints", position = 0)
@RestController
@RequestMapping
public class WelcomeController {

	private final WelcomeService welcomeService;

	@Autowired
	public WelcomeController(WelcomeService welcomeService) {
		this.welcomeService = welcomeService;
	}

	@ApiOperation(value = "Get welcome message text..", notes = "Reads welcome message text from a properties file and returns in a json format")
	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> welcomeMessage() {
		return welcomeService.getWelcomeMessage();
	}

	@ApiOperation(value = "Get welcome name..", notes = "Reads welcome name from a properties file and returns in a json format")
	@RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> welcomeName() {
		return welcomeService.getWelcomeName();
	}

}
