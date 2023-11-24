package com.example.demo.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BonCourageAspect {

    @After("execution(* com.example.demo.services..get*(..))")
    public void bonCourageMessage() {
        System.out.println("Bon courage !");
    }
}
