package com.example.ioc1.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("leadBean")
public class Lead {
    private Basic b;

    @Autowired
    public Lead(Basic b) {
        this.b = b;
    }
    /*Autowired can be user on methods constructors or fields of class*/
    public Basic getB() {
        return b;
    }

    public void setB(Basic b) {
        this.b = b;
    }
}
