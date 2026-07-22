package com.example.demo.lld.snakenladder;

public class Dice {
    private int maxValue;
    private int minValue;

    public Dice(int maxValue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public int roll(){
        return (int)(Math.random()*(maxValue-minValue + 1) + minValue);
    }
}
