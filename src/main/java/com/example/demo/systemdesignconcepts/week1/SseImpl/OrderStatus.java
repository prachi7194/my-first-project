package com.example.demo.systemdesignconcepts.week1.SseImpl;

public class OrderStatus {
    private String orderId;
    private String status;

    public OrderStatus(){

    }

    public OrderStatus(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}
