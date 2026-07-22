package com.example.demo.lld.ratelimiter.factory;


import com.example.demo.lld.ratelimiter.enums.RateLimitType;
import com.example.demo.lld.ratelimiter.limiter.FixedWindowRateLimiter;
import com.example.demo.lld.ratelimiter.limiter.RateLimiter;
import com.example.demo.lld.ratelimiter.limiter.SlidingWindowRateLimiter;
import com.example.demo.lld.ratelimiter.limiter.TokenBucketRateLimiter;
import com.example.demo.lld.ratelimiter.model.RateLimitConfig;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType rateLimitType, RateLimitConfig rateLimitConfig){
        return switch (rateLimitType){
            case FIXED_WINDOW -> new FixedWindowRateLimiter(rateLimitConfig);
            case SLIDING_WINDOW_LOG -> new SlidingWindowRateLimiter(rateLimitConfig);
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(rateLimitConfig);
            default -> throw new IllegalArgumentException("unknown algorithm" +rateLimitType);
        };
    }
}
