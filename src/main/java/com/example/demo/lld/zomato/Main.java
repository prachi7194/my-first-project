package com.example.demo.lld.zomato;

import com.example.demo.lld.zomato.model.Order;
import com.example.demo.lld.zomato.model.Restuarant;
import com.example.demo.lld.zomato.model.User;
import com.example.demo.lld.zomato.strategies.UpiPaymentStrategy;

public class Main {
    public static void main(String[] args) {
        Tomato tomato = new Tomato();
        User user = new User("Prachi", 101, "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurants by location
        java.util.List<Restuarant> restaurantList = tomato.searchRestuarant("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restuarant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }
        tomato.selectRestuarant(user, restaurantList.get(0));
        // User adds items to the cart
        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);
        Order order = tomato.checkOutNow(user,"delivery",new UpiPaymentStrategy("13231"));
        tomato.payForOrder(user,order );


    }



}
