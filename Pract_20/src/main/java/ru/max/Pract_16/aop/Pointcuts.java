package ru.max.Pract_16.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.max.Pract_16.service.impl.*.*(..))")
    public void servicesMethods(){}

}
