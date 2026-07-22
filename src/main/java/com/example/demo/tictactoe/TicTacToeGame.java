package com.example.demo.tictactoe;

public class TicTacToeGame {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(3);
        Board board = new Board(gameBoard);
        Game game = new Game(board);
        game.run();
    }
}
