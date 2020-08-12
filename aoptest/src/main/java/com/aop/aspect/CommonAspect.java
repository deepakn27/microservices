package com.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Aspect
public class CommonAspect {

	@Pointcut("execution(* com.aop.*.*.*(..))")  //Common pointcut that can be used in advice
	public void pointcutmethod()
	{
		
	}
	@Before("execution(String getData())") // Pointcut for method execution
	public void entering(JoinPoint joinpoint)
	{
		log.info("entering the method {}",joinpoint.getStaticPart().getSignature().toString());
	}
	
	/*@After("pointcutmethod()") // common pointcut used for method execution
	public void exiting(JoinPoint joinpoint)
	{
		log.info("exiting the method after {}",joinpoint.getStaticPart().getSignature().toString());
		for(Object arg:joinpoint.getArgs())
		{
			log.info("args - {}",arg);
		}
	}
	
	@AfterThrowing(pointcut="pointcutmethod()",throwing="ex")
	public void aftherThrow(JoinPoint joinpoint,RuntimeException ex)
	{
		log.info("exiting the method throwing exception {}",joinpoint.getStaticPart().getSignature().toString());
		log.info("exiting the method throwing exception {}",ex.getMessage());
		for(Object arg:joinpoint.getArgs())
		{
			log.info("args - {}",arg);
		}
	}
	
	@AfterReturning(pointcut="pointcutmethod()",returning="s")
	public void aftherThrow(JoinPoint joinpoint,String s)
	{
		log.info("exiting the method returning {}",joinpoint.getStaticPart().getSignature().toString());
		log.info("exiting the method returning {}",s);
		for(Object arg:joinpoint.getArgs())
		{
			log.info("args - {}",arg);
		}
	}*/
	
	
	//@Around("execution(* com.aop.*.*.getDataAround(..))")
	@Around("@annotation(com.aop.annotation.Trace)")  //Annotation in pointcut 
	public Object aroundMethod(ProceedingJoinPoint pjoinpoint)
	{
		log.info("AROUND - entering the method {}",pjoinpoint.getStaticPart().getSignature().toString());
		String var = "";
		for(Object arg:pjoinpoint.getArgs())
		{
			log.info("AROUND - argument of method - {}",arg);
			var = arg.toString();
		}
		log.info("AROUND - initial work before calling method done");
		
		if(var.equals("present"))
			return "mnop";  //Directly return if we do not want to call method
		
		try
		{
			Object result = pjoinpoint.proceed(); // Proceed to run method
			log.info("AROUND - exiting the  returning {}",result);
			return result;
		}catch(Throwable ex) {
			log.info("AROUND - exception handled");
		}finally {
			log.info("AROUND - exiting after some work");
		}
		
		return "";
	}
	
}
