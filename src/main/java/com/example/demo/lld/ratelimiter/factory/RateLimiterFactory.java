package com.example.demo.lld.ratelimiter.factory;

import lld.ratelimiter.enums.RateLimitType;
import lld.ratelimiter.limiter.FixedWindowRateLimiter;
import lld.ratelimiter.limiter.RateLimiter;
import lld.ratelimiter.limiter.SlidingWindowRateLimiter;
import lld.ratelimiter.limiter.TokenBucketRateLimiter;
import lld.ratelimiter.model.RateLimitConfig;

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
