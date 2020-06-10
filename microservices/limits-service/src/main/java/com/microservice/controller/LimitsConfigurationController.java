package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.configuration.Configuration;
import com.microservice.model.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsromConfigurations()
	{
		return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackConfiguration")
	public LimitConfiguration retrieveLimitsConfigurations()
	{
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallbackConfiguration()
	{
		return new LimitConfiguration(100,100);
	}
}
