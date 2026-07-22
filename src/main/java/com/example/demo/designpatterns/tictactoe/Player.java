package com.example.demo.designpatterns.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String username;
    private Symbol symbol;

}
