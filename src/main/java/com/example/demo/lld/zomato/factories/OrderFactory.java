package com.example.demo.lld.zomato.factories;

import com.example.demo.lld.zomato.model.*;
import com.example.demo.lld.zomato.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {

    Order createOrder(User user, Restuarant restuarant, List<MenuItem> menuItemList, PaymentStrategy paymentStrategy,
                      double totalCost, String orderType);
}
