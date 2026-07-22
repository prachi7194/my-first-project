package com.example.demo.lld.chess.models;

import com.example.demo.lld.chess.enums.Color;
import com.example.demo.lld.chess.util.MovementHelper;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color, Position position){
        super(color, position);
    }
    @Override
    public List<Move> getValidMoves(Board board) {
      return MovementHelper.getLinearMoves(board, this, new int[][]{
              {-1,-1},
              {-1,1},
              {1,-1},
              {1,1}});

    }
}
