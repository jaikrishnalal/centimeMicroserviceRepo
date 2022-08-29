package com.personal.application4.dtoservice.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodParamLoggingAdvice {

	
	@Before(value = "@annotation(com.personal.application4.dtoservice.annotation.LogMethodParam)")
	public void logMethodParams(JoinPoint joinPoint) {
		
		Logger  logger = LoggerFactory.getLogger(MethodParamLoggingAdvice.class);
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method args names:");
        Arrays.stream(signature.getParameterNames())
          .forEach(name -> logger.info("Method: "+ signature.getMethod().getName() + " ; arg name: " + name));

        logger.info("Method args types:");
        Arrays.stream(signature.getParameterTypes())
          .forEach(type -> logger.info("Method: "+ signature.getMethod().getName() + " ; arg type: " + type));

        logger.info("Method args values:");
        Arrays.stream(joinPoint.getArgs())
          .forEach(value -> logger.info("Method: "+ signature.getMethod().getName() + " ; arg value: " + value.toString()));
		  
	}
}
