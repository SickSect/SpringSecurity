package com.example.ioc1.step3;

public class Author {
    private Pencil pencil;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }
    public void info(){
        System.out.println(name + " " + pencil.getFirm());
    }
}
