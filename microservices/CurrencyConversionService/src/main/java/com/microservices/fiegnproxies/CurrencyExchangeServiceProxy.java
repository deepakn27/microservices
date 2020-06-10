package com.microservices.fiegnproxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.model.CurrencyConversionBean;


//@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyConversionBean> getMultiplicationFactor(@PathVariable("from") String fromCurrency, @PathVariable("to") String toCurrency);
	
}
