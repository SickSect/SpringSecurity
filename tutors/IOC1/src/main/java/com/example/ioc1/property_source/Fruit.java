package com.example.ioc1.property_source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Fruit {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("${name}")
    private String name;
}
