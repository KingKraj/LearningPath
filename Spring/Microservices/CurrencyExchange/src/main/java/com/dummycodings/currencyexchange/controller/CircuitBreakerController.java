package com.dummycodings.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

	@Retry(name = "sample-api", fallbackMethod = "fallbackCircuitBreaker")
	@GetMapping("/circuitbreaker")
	public String checkCircuitBreaker() {
		log.info("i am trying");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://some-api/sampleapi", String.class);
		return "hello world";
	}

	public String fallbackCircuitBreaker(Exception ex) {
		log.info(" circuit breaker entered in here...!");
		return "i am from Fallback Circuite breaker";
	}

}
