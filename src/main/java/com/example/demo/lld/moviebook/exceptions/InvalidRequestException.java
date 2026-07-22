package com.example.demo.lld.moviebook.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message){
        super(message);
    }
}
