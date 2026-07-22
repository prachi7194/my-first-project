package com.example.demo.lld.chess.models;

import lld.chess.enums.Color;
import lld.chess.util.MovementHelper;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, Position position){
        super(color, position);
    }
    @Override
    public List<Move> getValidMoves(Board board) {
      return MovementHelper.getLinearMoves(board, this, new int[][]{{-1,0},
              {1,0},
              {0,-1},
              {0,1}});

    }
}
