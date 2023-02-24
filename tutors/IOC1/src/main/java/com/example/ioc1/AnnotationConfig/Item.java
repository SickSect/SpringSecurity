package com.example.ioc1.AnnotationConfig;

import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {
    private String name;

    public Item() {
        System.out.println("CTR!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
