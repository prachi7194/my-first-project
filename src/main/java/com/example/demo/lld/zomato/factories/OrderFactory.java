package com.example.demo.lld.zomato.factories;

import lld.zomato.model.*;
import lld.zomato.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {

    Order createOrder(User user, Restuarant restuarant, List<MenuItem> menuItemList, PaymentStrategy paymentStrategy,
                      double totalCost, String orderType);
}
