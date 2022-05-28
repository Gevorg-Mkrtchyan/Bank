package com.example.bank.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class BankLoggingAspect {
    @Around("execution(* com.example.bank.cotroller.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice
            (ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        log.info("begin of " + methodName);
        Object targetMethodResult =  proceedingJoinPoint.proceed();
        log.info("end of " + methodName);
        return targetMethodResult;
    }
}
