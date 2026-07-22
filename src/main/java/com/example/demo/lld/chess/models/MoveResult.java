package com.example.demo.lld.chess.models;

public class MoveResult {
    private final boolean success;
    private final String message;
    public MoveResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess(){
        return this.success;
    }
    public String getMessage(){
        return this.message;
    }
}
