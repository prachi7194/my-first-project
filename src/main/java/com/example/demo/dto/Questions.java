package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class Questions extends Entity {
    List<Answer> answerList;
    private String title;
    private String description;
}
