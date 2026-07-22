package com.example.demo.lld.zomato.model;


import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restuarant r;
    private List<java.awt.MenuItem> menuItemList = new ArrayList<>();

    public Cart(){
        r = null;
    }

    public void addItems(java.awt.MenuItem menuItem){
        if(r == null){
            System.out.println("set a restuarant before adding items");
        }
        menuItemList.add(menuItem);
    }

    public double getTotalCost(){
        double sum = 0;
        for(java.awt.MenuItem menuItem  :menuItemList){
            sum = sum + menuItem.getPrice();
        }
        return sum;
    }

    public boolean isEmpty(){
        return r == null || menuItemList.isEmpty();
    }

    public void clear(){
        menuItemList.clear();
        r = null;
    }
    public void setRestaurant(Restuarant r) {
        this.r = r;
    }

    public Restuarant getRestaurant() {
        return r;
    }

    public List<MenuItem> getItems() {
        return menuItemList;
    }

}
