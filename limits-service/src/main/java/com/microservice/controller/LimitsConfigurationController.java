package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.configuration.Configuration;
import com.microservice.model.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@Value("${service.check}")
	Integer check;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsromConfigurations()
	{
		System.out.println("check - " + check);
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
