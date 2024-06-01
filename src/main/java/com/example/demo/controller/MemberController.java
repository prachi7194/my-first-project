package com.example.demo.controller;


import com.example.demo.constants.VoteType;
import com.example.demo.dto.Answer;
import com.example.demo.dto.Comment;
import com.example.demo.dto.Entity;
import com.example.demo.dto.Questions;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberController {

    public void addQuestion(Questions question){

    }

    //can add comment to question, answer
    private void addComment(Entity entity, Comment comment){

    }

    private void addAnswer(Questions question, Answer answer){

    }
    private void vote(Entity entity, VoteType voteType){

    }

}
