package com.example.demo.tictactoe;

public enum Symbol {
    START('*'),
    ZERO('O'),
    CROSS('X');
    private Character val;

    Symbol(Character c){
        this.val = c;
    }
    public Character getValue(){
        return val;
    }
}
