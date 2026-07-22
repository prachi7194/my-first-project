package com.example.demo.lld.snakenladder;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
        if(start >= end){
            throw new IllegalArgumentException("ladder head must be at a lower position compared to tail");
        }
    }
}
