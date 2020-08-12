package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/test")
public class DefaultController {

	
	 @RequestMapping(value = { "/abc" }, method = RequestMethod.GET)
	    public String welcomePage(Model model) {
		 System.out.println("123");
		 return "1";
	    }
}
