package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StringChangerLoggingAspect {

    @Pointcut("execution(* convertString()) && args(input)")
    public void stringConversion(String input) {}

    @Before("stringConversion(input)")
    public void logStringConversion(JoinPoint joinPoint, String input) {
        System.out.println("Initial String: " + input);
    }

}
