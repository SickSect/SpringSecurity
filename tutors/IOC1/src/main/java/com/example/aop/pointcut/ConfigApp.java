package com.example.aop.pointcut;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.aop.pointcut")
@EnableAspectJAutoProxy // this let us hide using spring proxy
public class ConfigApp {
}
