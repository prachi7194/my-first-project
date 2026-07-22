package com.example.demo.lld.chess.models;

public class Position {
    private final int row;
    private final int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public boolean isValid(int rows, int cols){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
