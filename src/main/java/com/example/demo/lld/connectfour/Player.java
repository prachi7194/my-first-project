package com.example.demo.lld.connectfour;

public class Player {
    String name;
    DiscColor color;

    public Player(String name, DiscColor color){
        this.name = name;
        this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public DiscColor getDiscColor(){
        return color;
    }
}
