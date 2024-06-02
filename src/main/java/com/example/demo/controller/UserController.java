package com.example.demo.controller;

import com.example.demo.dto.Questions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/v1/questions/{searchString}")
    private List<Questions> getQuestions(@PathVariable String searchString){
        List<Questions> questions = new ArrayList<>();
        return questions;
    }
}
