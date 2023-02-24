package com.example.ioc1.BeanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Key {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
