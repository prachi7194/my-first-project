package com.example.demo.lld.chess.models;

public class Move {
    private final Position from;
    private final Position to;
    public Move(Position from, Position to){
        this.from = from;
        this.to = to;
    }
    public Position getFrom(){
        return this.from;
    }
    public Position getTo(){
        return this.to;
    }
}
