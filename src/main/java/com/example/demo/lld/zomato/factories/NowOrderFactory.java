package com.example.demo.lld.zomato.factories;

import com.example.demo.lld.zomato.model.*;
import com.example.demo.lld.zomato.strategies.PaymentStrategy;
import com.example.demo.lld.zomato.utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Restuarant restuarant, List<MenuItem> menuItemList, PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;
        if(orderType.equals("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }else{
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restuarant.getLocation());
            order = pickupOrder;

        }
        order.setUser(user);
        order.setRestuarant(restuarant);
        order.setItems(menuItemList);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotal(totalCost);
        order.setScheduled(TimeUtils.getCurrentTime());
        return order;
    }
}
