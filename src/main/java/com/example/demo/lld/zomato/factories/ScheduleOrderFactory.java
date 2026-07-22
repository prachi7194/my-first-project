package com.example.demo.lld.zomato.factories;

import com.example.demo.lld.zomato.model.*;
import com.example.demo.lld.zomato.strategies.PaymentStrategy;

import java.util.List;

public class ScheduleOrderFactory implements OrderFactory {

    private String scheduleTime;
    public ScheduleOrderFactory(String s){
        this.scheduleTime = s;
    }
    @Override
    public Order createOrder(User user,Restuarant restuarant, List<MenuItem> menuItemList, PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;
        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restuarant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestuarant(restuarant);
        order.setItems(menuItemList);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }
}
