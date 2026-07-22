package com.example.demo.lld.connectfour;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private GameState gameState;
    private Player winner;

    Game(Board b, Player p1, Player p2){
        this.board = b;
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Board getBoard(){
        return board;
    }
    public GameState getGameState(){
        return gameState;
    }
    public Player getWinner(){
        return winner;
    }
    public boolean makeMove(Player player, int column){
        if(gameState != GameState.IN_PROGRESS){
            return false;
        }
        if(player != currentPlayer){
            return false;
        }
        int row = board.placeDisc(column, player.getDiscColor());
        if(row == -1){
            return false;
        }
        if(board.checkWin(row, column, player.getDiscColor())){
            gameState = GameState.WON;
            winner = player;
        }else if(board.isFull()){
            gameState = GameState.DRAW;
        }else{
            currentPlayer = (currentPlayer ==  player1) ? player1:player2;
        }
        return true;
    }


}
