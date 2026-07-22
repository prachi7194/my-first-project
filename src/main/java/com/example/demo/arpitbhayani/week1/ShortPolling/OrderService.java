package com.example.demo.arpitbhayani.week1.ShortPolling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderStatus getStatus(String orderId){
        return orderRepository.find(orderId);
    }

    public void update(OrderStatus status){
        orderRepository.save(status);
    }
}
