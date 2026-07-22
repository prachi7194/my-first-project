package com.example.demo.lld.tictactoe;

public interface BoardFeatures {
    void judge();
    void announceTurn(Player p);
    Integer makeChoice(Player p);
    Boolean isValid(Integer choice);
    void doChanges(Integer choice, Player p);
    void makeMove();
}
