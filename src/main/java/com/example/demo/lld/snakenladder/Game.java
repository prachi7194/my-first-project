package com.example.demo.lld.snakenladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> playerQueue;
    private final Dice dice;
    private GameStatus gameStatus;
    private Player winner;
    public Game(int n, List<BoardEntity> boardEntities, List<String> players){
        this.board = new Board(n, boardEntities);
        this.playerQueue = new LinkedList<Player>();
        for (String playerName : players) {
            playerQueue.add(new Player(playerName));
        }
        this.dice = new Dice(6, 1);
        this.gameStatus = GameStatus.NOT_STARTED;

    }

    public void play(){
        if(playerQueue.size() < 2){
            System.out.println("Cannot start game. At least 2 players are required.");
            return;
        }
        this.gameStatus = GameStatus.RUNNING;
        System.out.println("Game started!");
        while(gameStatus == GameStatus.RUNNING){
            Player currentPlayer = playerQueue.poll();
            takeTurn(currentPlayer);
            if(gameStatus == GameStatus.RUNNING){
                playerQueue.add(currentPlayer);
            }
        }
        System.out.println("Game Finished!");
        if (winner != null) {
            System.out.printf("The winner is %s!%n", winner.getName());
        }
    }

    public void takeTurn(Player player){
        int roll = dice.roll();
        int currPos = player.getPosition();
        int nextPos = currPos + roll;
        if(nextPos > board.getSize()){
            System.out.printf(
                    "Oops, %s needs to land exactly on %d. Turn skipped.%n",
                    player.getName(), board.getSize()
            );
            return;
        }
        if(nextPos == board.getSize()){
            player.setPosition(nextPos);
            winner = player;
            this.gameStatus = GameStatus.FINISHED;
            System.out.printf(
                    "Hooray! %s reached the final square %d and won!%n",
                    player.getName(), board.getSize()
            );
            return;
        }
        int finalPosition = board.getFinalPosition(nextPos);
        if (finalPosition > nextPos) {
            System.out.printf(
                    "Wow! %s found a ladder at %d and climbed to %d.%n",
                    player.getName(), nextPos, finalPosition
            );
        } else if (finalPosition < nextPos) {
            System.out.printf(
                    "Oh no! %s was bitten by a snake at %d and slid down to %d.%n",
                    player.getName(), nextPos, finalPosition
            );
        } else {
            System.out.printf(
                    "%s moved from %d to %d.%n",
                    player.getName(), nextPos, finalPosition
            );
        }

        player.setPosition(finalPosition);
        if(roll == 6){
            System.out.printf("%s rolled a 6 and gets another turn!%n", player.getName());

            takeTurn(player);
        }
    }

}
