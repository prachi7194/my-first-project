package com.example.demo.controller;


import com.example.demo.constants.VoteType;
import com.example.demo.dto.Answer;
import com.example.demo.dto.Comment;
import com.example.demo.dto.Entity;
import com.example.demo.dto.Questions;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberController {

    @PostMapping("/v1/question")
    public String addQuestion(@RequestBody Questions question){
        String title = question.getTitle();
        return "new question inserted " + title;

    }

    //can add comment to question, answer
    private void addComment(Entity entity, Comment comment){

    }

    private void addAnswer(Questions question, Answer answer){

    }
    private void vote(Entity entity, VoteType voteType){

    }

}
