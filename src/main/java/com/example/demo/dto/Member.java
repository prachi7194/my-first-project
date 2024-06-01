package com.example.demo.dto;

import lombok.Data;

@Data
public class Member extends User {
    private String emailId;
    private String password;
    private String userName;
}
