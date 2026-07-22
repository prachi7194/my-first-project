package com.example.demo.tictactoe;

import com.fasterxml.jackson.annotation.JsonValue;

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
