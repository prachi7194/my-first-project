package com.example.demo.lld.zomato.model;

public class User {
    private String name;
    private int userId;
    private String address;
    private Cart cart;

    public User(String name, int userId, String address){
        this.name = name;
        this.userId = userId;
        this.address = address;
        this.cart = new Cart();
    }

    //add getters and setters
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAddress(String add){
        this.address = add;
    }

    public String getAddress(){
        return address;
    }


    public Cart getCart(){
        return cart;
    }


}
