package com.example.demo.lld.zomato.model;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restuarant r;
    private List<com.example.demo.lld.zomato.model.MenuItem> menuItemList = new ArrayList<>();

    public Cart(){
        r = null;
    }

    public void addItems(MenuItem menuItem){
        if(r == null){
            System.out.println("set a restuarant before adding items");
        }
        menuItemList.add(menuItem);
    }

    public double getTotalCost(){
        double sum = 0;
        for(MenuItem menuItem  :menuItemList){
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
