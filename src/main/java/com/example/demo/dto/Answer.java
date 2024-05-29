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
public class Answer {
    String id;
    String title;
    String content;
    String questionId;
    List<Comment> commentList;
    String createdBy;
    Date createdTime;
    VoteInfo voteInfo;
}