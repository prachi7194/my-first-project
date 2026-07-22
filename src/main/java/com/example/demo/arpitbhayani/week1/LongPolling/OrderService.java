package com.example.demo.arpitbhayani.week1.LongPolling;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    //pretend this is our db
    private final Map<String, OrderStatus> orders = new ConcurrentHashMap<>();

    //Stores waiting clients
    private final Map<String, DeferredResult<OrderStatus>> waitingRequests = new ConcurrentHashMap<>();

    public DeferredResult<OrderStatus> waitForUpdate(String orderId){
        DeferredResult<OrderStatus> result = new DeferredResult<>(30000L);
        waitingRequests.put(orderId, result);
        return result;
    }

    public void updateOrder(String orderId, String status){
        OrderStatus orderStatus = new OrderStatus(orderId, status);
        orders.put(orderId, orderStatus);
        DeferredResult<OrderStatus> client = waitingRequests.get(orderId);
        if(client != null){
            client.setResult(orderStatus);
            waitingRequests.remove(orderId);
        }
    }

}
