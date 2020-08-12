package com.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.fiegnproxies.CurrencyExchangeServiceProxy;
import com.microservices.model.CurrencyConversionBean;

@RestController
public class CurrencyConverter {

	private Logger logger = LoggerFactory.getLogger(CurrencyConverter.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvertedCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		ResponseEntity<CurrencyConversionBean> responseEntity = proxy.getMultiplicationFactor(from, to);
		CurrencyConversionBean response = responseEntity.getBody();
		logger.info("{}",response);
		return new CurrencyConversionBean(response.getId(),from,to,response.getConversionFactor(),quantity,quantity.multiply(response.getConversionFactor()),response.getPort());
	}
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvertedCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity("http://currency-exchange-service/exchange-service/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(),from,to,response.getConversionFactor(),quantity,quantity.multiply(response.getConversionFactor()),Integer.valueOf(environment.getProperty("local.server.port")));
	}
}
