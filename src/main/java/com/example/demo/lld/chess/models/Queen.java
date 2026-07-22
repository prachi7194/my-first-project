package com.example.demo.lld.chess.models;

import lld.chess.enums.Color;
import lld.chess.util.MovementHelper;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, Position position){
        super(color, position);
    }
    @Override
    public List<Move> getValidMoves(Board board) {
      return MovementHelper.getLinearMoves(board, this, new int[][]{{-1,0},
              {1,0},
              {0,-1},
              {0,1},
              {-1,-1},
              {-1,1},
              {1,-1},
              {1,1}});

    }
}
