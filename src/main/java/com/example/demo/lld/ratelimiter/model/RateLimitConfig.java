package com.example.demo.lld.ratelimiter.model;

public class RateLimitConfig {
    private int maxRequests;
    private int windowInSeconds;

    public RateLimitConfig(int maxRequests, int windowInSeconds) {
        this.maxRequests = maxRequests;
        this.windowInSeconds = windowInSeconds;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
    }

    public int getWindowInSeconds() {
        return windowInSeconds;
    }

    public void setWindowInSeconds(int windowInSeconds) {
        this.windowInSeconds = windowInSeconds;
    }

}
