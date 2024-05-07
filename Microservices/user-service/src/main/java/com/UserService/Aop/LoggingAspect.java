package com.UserService.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.UserService.service.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method invoked====>: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.UserService.service.UserService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method returned====>: {}", result);
    }

    @Around(value = "execution(* com.UserService.service.UserService.*(..))")
    public Object logTime (ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("KPI:");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(joinPoint.getArgs(),","))
                .append(")");
        sb.append("\ttook: ");
        Object returnedValue = joinPoint.proceed();
        logger.info(sb.append(System.currentTimeMillis() - startTime).append("ms.").toString());
        return returnedValue;
    }

}
