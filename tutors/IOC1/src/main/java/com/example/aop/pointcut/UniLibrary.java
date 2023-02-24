package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("uni")
public class UniLibrary extends AbstractLibrary{

    @Override
    public void getBook(){
        System.out.println("Take book from Unilibrary.");
    }
}
