package com.example.ioc1.step1;

public class Owner {
    private Item item;

    public Owner(Item item) {
        this.item = item;
    }
    public void showItem(){
        System.out.println(item.getItem());
    }
}
