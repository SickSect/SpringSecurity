package com.example.ioc1.step2;

public class Student {
    private Book book;

    public void setBook(Book book) {
        System.out.println("SET BOOK");
        this.book = book;
    }

    public void showBook(){
        System.out.println(book.getBook());
    }
}
