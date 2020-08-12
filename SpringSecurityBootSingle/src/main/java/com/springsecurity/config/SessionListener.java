package com.springsecurity.config;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionListener implements HttpSessionListener {

	  @Override
	  public  void sessionCreated(HttpSessionEvent se) {
		  
		 HttpSession session =  se.getSession();
	     session.setMaxInactiveInterval(120);
	    }

}
