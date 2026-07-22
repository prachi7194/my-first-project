package com.example.demo.lld.chess.models;

public class ValidationResult {
    private final boolean valid;
    private final String reason;
    public ValidationResult(boolean valid, String reason){
        this.valid = valid;
        this.reason = reason;
    }
    public boolean isValid(){
        return this.valid;
    }
    public String getReason(){
        return this.reason;
    }
}
