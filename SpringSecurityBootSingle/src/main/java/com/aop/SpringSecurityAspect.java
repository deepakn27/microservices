package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringSecurityAspect {

	@Before(value = "execution (* com.springsecurity.controller.*.*(..))")
	public void before(JoinPoint joinpoint)
	{
		System.out.println("Allowed execution - " + joinpoint);
	}
	
	
	  @AfterReturning(value = "execution (* com.springsecurity.controller.*.*(..))", returning="result")
	  public void afterReturning(JoinPoint joinpoint, Object result) {
	  System.out.println("After Execution of - " + joinpoint.getSignature() +" --- Returning - " + result); 
	  }
	 
	
	@After(value = "execution (* com.springsecurity.controller.*.*(..))")
	public void after(JoinPoint joinpoint)
	{
		System.out.println("after execution - " + joinpoint);
	}
	
}
