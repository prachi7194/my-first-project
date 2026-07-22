package com.example.demo.arpitbhayani.week1.cachestampede;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class SingleFlightCache {
    private final ConcurrentHashMap<String, CompletableFuture<String>> inflight = new ConcurrentHashMap<>();

    public String get(String key){
        String value = cacheGet(key);
        if(value != null){
            return value;
        }
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture<String> existing = inflight.putIfAbsent(key, future);
        if(existing != null){
            return existing.join();
        }
        try{
            value = dbGet(key);
            cachePut(key, value);
            future.complete(value);
            return value;
        } catch(Exception e){
            future.completeExceptionally(e);
            throw e;
        }finally{
            inflight.remove(key);
        }
    }

    private void cachePut(String key, String value) {
    }

    private String dbGet(String key) {
        return "data";
    }

    private String cacheGet(String key) {
        return null;
    }
}
