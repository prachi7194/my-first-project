package com.example.demo.lld.snakenladder;

public class BoardEntity {
    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    final private int start;
    final private int end;

}
