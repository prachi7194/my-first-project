package com.example.demo.designpatterns.tictactoe;

import lombok.Data;

@Data
public class GameBoard implements GameBoardFeature {
    private int n;
    private Character[][] board;
    private int moves;
    private EventType situation = EventType.ONGOING;

    public GameBoard(int boardSize){
        this.n = boardSize;
    }
    @Override
    public void initialize() {
        board = new Character[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                board[i][j] = Symbol.START.getValue();
            }
        }

    }

    @Override
    public void display() {
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
