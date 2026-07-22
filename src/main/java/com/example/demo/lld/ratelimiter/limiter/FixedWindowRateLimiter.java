package com.example.demo.lld.ratelimiter.limiter;

import lld.ratelimiter.enums.RateLimitType;
import lld.ratelimiter.model.RateLimitConfig;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter extends RateLimiter {
    private final ConcurrentHashMap<String, WindowStates> windowStatesMap = new ConcurrentHashMap<>();
    private int maxRequests;
    private int windowSizeInSeconds;
    public FixedWindowRateLimiter(RateLimitConfig rateLimitConfig) {

        super(RateLimitType.FIXED_WINDOW, rateLimitConfig);
        this.maxRequests = rateLimitConfig.getMaxRequests();
        this.windowSizeInSeconds = rateLimitConfig.getWindowInSeconds();
    }

    @Override
    public boolean allowRequest(String userId) {
        long currentWindow = System.currentTimeMillis()/1000/windowSizeInSeconds;
        WindowStates windowStates = windowStatesMap.computeIfAbsent(userId, id -> new WindowStates(currentWindow));
        synchronized (windowStates){
            if(currentWindow != windowStates.windowId){
                windowStates.windowId = currentWindow;
                windowStates.requestCount = 0;

            }
            if(windowStates.requestCount >= maxRequests){
                return false;
            }
            windowStates.requestCount = windowStates.requestCount + 1;
            return true;
        }

    }

private static class WindowStates{
        long windowId;
        int requestCount;
        WindowStates(long windowId){
            this.windowId = windowId;
            this.requestCount = 0;

        }

    }
}


