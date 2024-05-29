package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    String id;
    String title;
    String content;
    List<Answer> answerList;
    List<Comment> commentList;
    String createdBy;
    Date createdTime;
    VoteInfo voteInfo;
}
