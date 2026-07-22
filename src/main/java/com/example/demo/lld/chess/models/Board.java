package com.example.demo.lld.chess.models;

import lld.chess.enums.Color;

public class Board {
    private final int rows;
    private final int cols;
    private final Piece[][] grid;
    public Board(int rows, int cols){
        if(rows != 8 && cols != 8){
            throw new IllegalArgumentException("Standard chess required 8*8 board.");
        }
        this.rows = rows;
        this.cols = cols;
        this.grid = new Piece[rows][cols];
    }
    public int getRows(){
        return this.rows;
    }
    public int getCols(){
        return this.cols;
    }
    public boolean isValidPositon(Position pos){
        return pos != null && pos.isValid(rows, cols);
    }
    public Piece getPiece(Position pos){
        if(!isValidPositon(pos)){
            return null;
        }
        return grid[pos.getRow()][pos.getCol()];
    }

    public void placePiece(Piece piece, Position pos){
        if(!isValidPositon(pos)){
            throw new IllegalArgumentException("Invalid board position");
        }
        grid[pos.getRow()][pos.getCol()] = piece;
        if(piece != null){
            piece.setPosition(pos);
        }

    }

    public boolean isEmpty(Position pos){
        return getPiece(pos) == null;
    }
    public boolean hasOpponent(Position pos, Color color){
        Piece piece = getPiece(pos);
        return piece != null && piece.getColor() != color;

    }

    public void movePiece(Move move){
        Piece movingPiece = getPiece(move.getFrom());
        placePiece(movingPiece, move.getTo());
        placePiece(null,move.getFrom());
    }
}
