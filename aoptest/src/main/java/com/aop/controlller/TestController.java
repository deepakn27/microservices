package com.aop.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aop.annotation.Trace;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController{

	
	@GetMapping("/getData")
	public String getData()
	{
		log.info("abcd");
		return "abc";
	}
	
	
	@GetMapping("/getDatawrap")
	public String getDatawrap()
	{
		return getData();
	}
	
	@GetMapping("/getData2/{name}")
	public String getDataArgument(@PathVariable("name")String name)
	{
		log.info("Original method called");
		return name;
	}
	
	@GetMapping("/getDataex/{name}")
	public String getDataEx(@PathVariable("name")String name) throws Exception
	{
		throw new RuntimeException("my exception");
	}
	
	@Trace
	@GetMapping("/getData3/{name}")
	public String getDataAround(@PathVariable("name")String name)
	{
		log.info("Original method called");
		return name;
	}
}
