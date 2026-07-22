package com.example.demo.lld.snakenladder;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end);
        if(start <= end){
            throw new IllegalArgumentException("snake head must be at a higher position compared to tail");
        }
    }
}
