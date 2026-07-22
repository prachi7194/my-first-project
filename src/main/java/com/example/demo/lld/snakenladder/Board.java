package com.example.demo.lld.snakenladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakeAndLadders;
    Board(int size, List<BoardEntity> entityList){
        this.size  = size;
        this.snakeAndLadders = new HashMap<>();
        for(BoardEntity board : entityList){
            snakeAndLadders.put(board.getStart(), board.getEnd());
        }
    }

    public int getSize(){
        return size;
    }

    public int getFinalPosition(int position){
        return snakeAndLadders.getOrDefault(position, position);
    }
}
