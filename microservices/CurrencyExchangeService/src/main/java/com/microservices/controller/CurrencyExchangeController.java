package com.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.ExchangeValue;
import com.microservices.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepository exchangValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to)
	{
		ExchangeValue exchangeValue = exchangValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		return new ResponseEntity<ExchangeValue>(exchangeValue,HttpStatus.OK);
	}
}
