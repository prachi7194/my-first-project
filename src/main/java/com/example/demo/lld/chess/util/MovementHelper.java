package com.example.demo.lld.chess.util;

import lld.chess.models.Board;
import lld.chess.models.Move;
import lld.chess.models.Piece;
import lld.chess.models.Position;


import java.util.ArrayList;
import java.util.List;

public class MovementHelper {
    public static List<Move> getLinearMoves(Board board, Piece piece, int[][] directions) {
        List<Move> moves = new ArrayList<>();
        for(int[] dir:directions){
            int row = piece.getPosition().getRow();
            int col = piece.getPosition().getCol();
            while(true){
                row = row + dir[0];
                col = col + dir[1];
                Position next = new Position(row, col);
                if(!board.isValidPositon(next))
                    break;
                if(board.isEmpty(next)){
                    moves.add(new Move(piece.getPosition(),next));
                }else{
                    if(board.hasOpponent(next, piece.getColor())){
                        moves.add(new Move(piece.getPosition(),next));
                    }
                    break;
                }
            }
        }
        return moves;

    }

}
