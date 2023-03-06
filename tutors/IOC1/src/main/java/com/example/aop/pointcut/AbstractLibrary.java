package com.example.aop.pointcut;

public abstract class AbstractLibrary {
    abstract   public void getBook(String name);
    abstract   public Book returnBook(String name,String author);
    abstract public void findBook(String name);
    abstract void getSilence();
    abstract void findDocument(String name);
}
