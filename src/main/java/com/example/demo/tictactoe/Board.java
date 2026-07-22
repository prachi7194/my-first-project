package com.example.demo.tictactoe;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Data
public class Board implements BoardFeatures{
    Scanner scn = new Scanner(System.in);

    private GameBoard board;
    private Queue<Player> userChoices = new LinkedList<>();
    Player p1, p2;
    Board(GameBoard board){

        p1 = new Player();
        p2 = new Player();
        p1.setUsername("Alex");
        p1.setSymbol(Symbol.CROSS);
        p2.setUsername("Bob");
        p2.setSymbol(Symbol.ZERO);
        userChoices.add(p1);
        userChoices.add(p2);
        board.setSituation(EventType.ONGOING);
        this.board = board;
    }
    @Override
    public void judge() {
        int n = board.getN();
        //row check
        for(int i = 0;i<n;i++){
            Character start = board.getBoard()[i][0];
            int count = 0;
            for(int j = 0; j < n; j++){
                if(board.getBoard()[i][j].equals(start)){
                    count = count + 1;

                }
            }
            if(count == n){
                if(start.equals(Symbol.CROSS.getValue()) || start.equals(Symbol.ZERO.getValue())){
                    board.setSituation(EventType.WIN);

                }
            }
        }
        //column check
        for(int i = 0;i<n;i++){
            Character start = board.getBoard()[0][i];
            int count = 0;
            for(int j = 0; j < n; j++){
                if(board.getBoard()[j][i].equals(start)){
                    count = count + 1;

                }
            }
            if(count == n){
                if(start.equals(Symbol.CROSS.getValue()) || start.equals(Symbol.ZERO.getValue())){
                    board.setSituation(EventType.WIN);

                }
            }
        }
        //diagonalCheck
        int count = 0;
        Character start = board.getBoard()[0][0];
        for(int i = 0; i < n;i++){
            if(board.getBoard()[i][i].equals((start))){
                count = count + 1;
            }
        }
        if(count == n){
            if(start.equals(Symbol.CROSS.getValue()) || start.equals(Symbol.ZERO.getValue())){
                board.setSituation(EventType.WIN);

            }
        }
        //anti diagonal check
        count = 0;
        start = board.getBoard()[0][n-1];
        for(int i = 0; i < n;i++){
            if(board.getBoard()[i][n-i-1].equals(start)){
                count = count + 1;
            }
        }
        if(count == n){
            if(start.equals(Symbol.CROSS.getValue()) || start.equals(Symbol.ZERO.getValue())){
                board.setSituation(EventType.WIN);

            }
        }
        if(board.getMoves() < n*n) {
            if (!board.getSituation().equals(EventType.WIN)) {
                board.setSituation(EventType.ONGOING);
            }
        }
        else{
            if (!board.getSituation().equals(EventType.WIN)){
                board.setSituation(EventType.DRAW);
            }
        }


    }

    @Override
    public void announceTurn(Player p) {
        System.out.println(p.getUsername() + " turn");

    }

    @Override
    public Integer makeChoice(Player p) {
        System.out.println(p.getUsername() + " Please make a choice");
        Integer sc = scn.nextInt();
        return sc;
    }

    @Override
    public Boolean isValid(Integer choice) {
        return (choice>=0 && choice<board.getN() *board.getN()) &&
                (board.getBoard()[(int) choice / board.getN()][(int)choice % board.getN()].equals(Symbol.START.getValue()));
    }


    @Override
    public void doChanges(Integer choice, Player p) {
        int row =  choice/board.getN();
        int col = choice % board.getN();
        board.getBoard()[row][col] = p.getSymbol().getValue();
        userChoices.add(p);
        judge();
    }

    @Override
    public void makeMove() {
        Player p = userChoices.poll();
        announceTurn(p);
        int choice = makeChoice(p);
        if(!isValid(choice)){
            choice = makeChoice(p);
        }
        board.setMoves(board.getMoves() + 1);
        board.setSituation(board.getSituation());
        doChanges(choice,p);

    }
}
