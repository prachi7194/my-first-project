package com.example.demo.lld.chess.models;

import lld.chess.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Color color, Position position){
        super(color, position);
    }
    @Override
    public List<Move> getValidMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0; i < 8; i++){
            addMoveIfValid(board, moves, new Position(position.getRow() + dx[i],position.getCol() + dy[i]));

        }
        return moves;

    }
}
