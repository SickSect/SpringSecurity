package com.example.ioc1.InitAndDestroy;

public class Phone {
    private String firm;

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void init(){
        System.out.println("This is init Phone.class");
    }

    public void destroy(){
        System.out.println("This is destroy Phone.class");
    }
}


