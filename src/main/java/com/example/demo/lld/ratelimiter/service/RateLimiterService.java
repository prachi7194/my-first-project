package com.example.demo.lld.ratelimiter.service;

import lld.ratelimiter.enums.RateLimitType;
import lld.ratelimiter.enums.UserTier;
import lld.ratelimiter.factory.RateLimiterFactory;
import lld.ratelimiter.limiter.RateLimiter;
import lld.ratelimiter.model.RateLimitConfig;
import lld.ratelimiter.model.User;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    private Map<UserTier, RateLimiter> rateLimiterServiceMap = new HashMap<>();
    public RateLimiterService(){
        rateLimiterServiceMap.put(UserTier.FREE, RateLimiterFactory.createRateLimiter(RateLimitType.TOKEN_BUCKET, new RateLimitConfig(10, 60)));
        rateLimiterServiceMap.put(UserTier.PREMIUM, RateLimiterFactory.createRateLimiter(RateLimitType.FIXED_WINDOW, new RateLimitConfig(100, 60)));

    }

    public boolean allowRequest(User user){
        RateLimiter limiter = rateLimiterServiceMap.get(user.getUserId());
        if(limiter == null){
            throw new IllegalArgumentException("no limiter configured for tier "+user.getUserTier());
        }
        return limiter.allowRequest(user.getUserId());
    }
}
