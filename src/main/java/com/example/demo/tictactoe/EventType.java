package com.example.demo.tictactoe;

public enum EventType {
    WIN("win"),
    DRAW("draw"),
    ONGOING("ongoing");
    private String val;

    EventType(String c){
        this.val = c;
    }
    public String getValue(){
        return val;
    }
}
