package com.example.demo.lld.ratelimiter.limiter;

import lld.ratelimiter.enums.RateLimitType;
import lld.ratelimiter.model.RateLimitConfig;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter extends RateLimiter {

    private static class Bucket{
        int tokens;
        long lastRefillTime;

        Bucket(int tokens, long lastRefillTime){
            this.tokens = tokens;
            this.lastRefillTime = lastRefillTime;
        }
    }

    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();
    private int maxRequests;
    private int windowSizeInSeconds;
    public TokenBucketRateLimiter(RateLimitConfig rateLimitConfig) {
        super(RateLimitType.TOKEN_BUCKET, rateLimitConfig);
        this.maxRequests = rateLimitConfig.getMaxRequests();
        this.windowSizeInSeconds = rateLimitConfig.getWindowInSeconds();
    }

    @Override
    public boolean allowRequest(String userId) {

        long now = System.currentTimeMillis();
        Bucket bucket = buckets.computeIfAbsent(userId, id -> new Bucket(maxRequests, now));
        synchronized (bucket){
            refill(bucket, now);
            if(bucket.tokens > 0){
                bucket.tokens = bucket.tokens - 1;
                return true;
            }
            return false;
        }

    }

    private void refill(Bucket bucket, long now) {
        double refillRate = (double)windowSizeInSeconds/maxRequests;
        long elapsedSeconds = (now - bucket.lastRefillTime)/ 1000;
        int tokens = (int) (elapsedSeconds / refillRate);
        if(tokens > 0){
            bucket.tokens = Math.min(maxRequests, bucket.tokens + tokens);
            bucket.lastRefillTime = now;
        }

    }
}
