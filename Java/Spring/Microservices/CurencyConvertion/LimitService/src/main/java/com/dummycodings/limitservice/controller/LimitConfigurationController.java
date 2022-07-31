package com.dummycodings.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummycodings.limitservice.Configuration;
import com.dummycodings.limitservice.beans.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	@Autowired
	private Configuration limitConfig;

	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(limitConfig.getMinimum(), limitConfig.getMaximum());
	}

}
