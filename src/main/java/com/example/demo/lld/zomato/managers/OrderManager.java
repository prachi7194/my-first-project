package com.example.demo.lld.zomato.managers;

import lld.zomato.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Order> orders = new ArrayList<>();
    private static OrderManager instance = null;

    public static OrderManager getInstance(){
        if(instance == null){
            return new OrderManager();
        }
        return instance;
    }

    public void addRestuarant(Order order){
        orders.add(order);
    }
    public void listOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orders) {
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }
}
