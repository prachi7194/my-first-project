package com.example.demo.lld.ratelimiter.model;


import com.example.demo.lld.ratelimiter.enums.UserTier;

public class User {
    private String userId;
    private UserTier userTier;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserTier getUserTier() {
        return userTier;
    }

    public void setUserTier(UserTier userTier) {
        this.userTier = userTier;
    }

    public User(String userId, UserTier userTier) {
        this.userId = userId;
        this.userTier = userTier;
    }
}
