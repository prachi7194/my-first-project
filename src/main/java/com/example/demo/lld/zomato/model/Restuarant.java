package com.example.demo.lld.zomato.model;


import java.util.ArrayList;
import java.util.List;


public class Restuarant {
    private int restuarantId;
    private String name;
    private String location;
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Restuarant(String name, String location){
        this.name = name;
        this.location = location;

        //add getters and setters;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setLocation(String loc){
        this.location = loc;
    }

    public String getLocation(){
        return location;
    }

    public void addMenuItem(MenuItem menuItem){
        menuItemList.add(menuItem);
    }
    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }

}
