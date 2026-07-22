package com.example.demo.lld.ratelimiter.limiter;


import com.example.demo.lld.ratelimiter.enums.RateLimitType;
import com.example.demo.lld.ratelimiter.model.RateLimitConfig;

public abstract class RateLimiter {
    private RateLimitType rateLimitType;
    private RateLimitConfig rateLimitConfig;

    public RateLimiter(RateLimitType rateLimitType, RateLimitConfig rateLimitConfig) {
        this.rateLimitType = rateLimitType;
        this.rateLimitConfig = rateLimitConfig;
    }

    public abstract boolean allowRequest(String userId);
}
