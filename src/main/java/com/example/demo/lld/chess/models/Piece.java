package com.example.demo.lld.chess.models;


import com.example.demo.lld.chess.enums.Color;

import java.util.List;

abstract public class Piece {
    protected final Color color;
    protected Position position;
    public Piece(Color color, Position position){
        this.color = color;
        this.position = position;
    }
    public Color getColor(){
        return color;
    }
    public Position getPosition(){
        return position;
    }
    public void setPosition(Position pos){
        this.position = pos;
    }
    public abstract List<Move> getValidMoves(Board board);

    protected void addMoveIfValid(Board board, List<Move> moves, Position newPos){
        if(!board.isValidPositon(newPos)){
            return;
        }
        if(board.isEmpty(newPos) || board.hasOpponent(newPos, color)){
            moves.add(new Move(position, newPos));
        }
    }
}
