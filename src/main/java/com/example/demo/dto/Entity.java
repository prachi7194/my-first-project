package com.example.demo.dto;

import com.example.demo.constants.VoteType;
import lombok.Data;

import java.util.Map;

@Data
public class Entity {
    private String id;
    Member member;

    Map<VoteType, Integer> voteTypeMap;


}
