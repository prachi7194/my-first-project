package com.example.demo.lld.tictactoe;

import lombok.Data;

@Data
public class Game implements GameFlow{

    private Board gameBoard;
    Game(Board gameBoard){
        this.gameBoard = gameBoard;
    }
    @Override
    public void run() {
        initialSetUp();
        int size = gameBoard.getBoard().getN();

        while(gameBoard.getBoard().getMoves() < size * size){
            if(gameBoard.getBoard().getSituation() == EventType.WIN){
                announceWinner();
                break;
            }
            System.out.println("Game Situation = "+ gameBoard.getBoard().getSituation());
            gameBoard.makeMove();
            System.out.println("############# BOARD #################");
            gameBoard.getBoard().display();
            System.out.println("############# BOARD #################");


        }
        if(gameBoard.getBoard().getMoves() == size * size){
            gameBoard.judge();
            if(gameBoard.getBoard().getSituation().equals(EventType.WIN)){
                announceWinner();
            }else if(gameBoard.getBoard().getSituation().equals(EventType.DRAW)){
                System.out.println(EventType.DRAW.getValue());
            }
        }


    }

    @Override
    public void announceWinner() {

    }

    @Override
    public void initialSetUp() {
        gameBoard.getBoard().initialize();
        gameBoard.getBoard().display();

    }
}
