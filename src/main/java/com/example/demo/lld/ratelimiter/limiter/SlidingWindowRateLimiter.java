package com.example.demo.lld.ratelimiter.limiter;


import com.example.demo.lld.ratelimiter.enums.RateLimitType;
import com.example.demo.lld.ratelimiter.model.RateLimitConfig;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter extends RateLimiter {
    private final ConcurrentHashMap<String, SlidingWindowState> map = new ConcurrentHashMap<>();
    private int maxRequests;
    private int windowSizeInSeconds;
    public SlidingWindowRateLimiter(RateLimitConfig rateLimitConfig) {
        super(RateLimitType.SLIDING_WINDOW_LOG, rateLimitConfig);
        this.maxRequests = rateLimitConfig.getMaxRequests();
        this.windowSizeInSeconds = rateLimitConfig.getWindowInSeconds();
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis() / 1000;
        SlidingWindowState slidingWindowState = map.computeIfAbsent(userId, id -> new SlidingWindowState());
        synchronized (slidingWindowState){
            removeexpired(slidingWindowState, now);
            if(slidingWindowState.timestamps.size() >= maxRequests){
                return false;
            }
            slidingWindowState.timestamps.add(now);
            return true;
        }
    }

    private void removeexpired(SlidingWindowState slidingWindowState, long now) {
        while(!slidingWindowState.timestamps.isEmpty() &&  now - slidingWindowState.timestamps.poll() >= windowSizeInSeconds){
            slidingWindowState.timestamps.poll();
        }
    }

    private static class SlidingWindowState{
        Queue<Long> timestamps;

    }
}
