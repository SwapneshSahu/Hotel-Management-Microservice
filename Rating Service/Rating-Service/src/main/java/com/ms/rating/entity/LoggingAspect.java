package com.ms.rating.entity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	   @Around("execution(* Calculator.add(..)) || execution(* Calculator.subtract(..))")
	   public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	       long startTime = System.currentTimeMillis();
	       System.out.println("Swap");
	       Object proceed = joinPoint.proceed();
	       long endTime = System.currentTimeMillis();
	       System.out.println(joinPoint.getSignature() + " executed in " + (endTime - startTime) + " ms");
	       return proceed;
	   }
}
