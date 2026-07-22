package com.example.demo.arpitbhayani.week1.ShortPolling;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final Map<String, OrderStatus> orders = new ConcurrentHashMap<>();
    public OrderStatus find(String orderId){
        return orders.get(orderId);
    }
    public void save(OrderStatus orderStatus){
        orders.put(orderStatus.getOrderId(), orderStatus);
    }
}
