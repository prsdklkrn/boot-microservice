package com.spt.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	private final Environment env;

	@Autowired
	public WelcomeService(Environment env) {
		this.env = env;
	}

	public Map<String, String> getWelcomeMessage() {
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("message", env.getProperty("welcome.message"));
		return messageMap;
	}

	public Map<String, String> getWelcomeName() {
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("name", env.getProperty("welcome.name"));
		return messageMap;
	}

}
