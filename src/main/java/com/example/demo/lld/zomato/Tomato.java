package com.example.demo.lld.zomato;

import com.example.demo.lld.zomato.factories.NowOrderFactory;
import com.example.demo.lld.zomato.factories.OrderFactory;
import com.example.demo.lld.zomato.factories.ScheduleOrderFactory;
import com.example.demo.lld.zomato.managers.OrderManager;
import com.example.demo.lld.zomato.managers.RestuarantManager;
import com.example.demo.lld.zomato.model.*;
import com.example.demo.lld.zomato.strategies.PaymentStrategy;

import java.util.List;

public class Tomato {

    public Tomato(){
        initializeRestuarants();
    }

    public void initializeRestuarants(){
        Restuarant restaurant1 = new Restuarant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restuarant restaurant2 = new Restuarant("Haldiram", "Kolkata");
        restaurant2.addMenuItem(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem("P3", "Dhokla", 50));

        Restuarant restaurant3 = new Restuarant("Saravana Bhavan", "Chennai");
        restaurant3.addMenuItem(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem("P3", "Filter Coffee", 30));

        RestuarantManager restuarantManager = RestuarantManager.getInstance();
        restuarantManager.addRestuarant(restaurant1);
        restuarantManager.addRestuarant(restaurant2);
        restuarantManager.addRestuarant(restaurant3);

    }

    public List<Restuarant> searchRestuarant(String addr){
        return RestuarantManager.getInstance().searchByLocation(addr);
    }

    public void selectRestuarant(User user, Restuarant restuarant){
        Cart cart = user.getCart();
        cart.setRestaurant(restuarant);

    }

    public void addToCart(User user, String itemCode){
        Restuarant r = user.getCart().getRestaurant();
        if(r == null){
            System.out.println("Please select a restuarant first");
            return;
        }
        for(MenuItem item: r.getMenuItemList()){
            if(item.getCode().equals(itemCode)){
                user.getCart().addItems(item);
                break;
            }
        }
    }

    public Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkOutOrder(user, orderType,paymentStrategy, new NowOrderFactory());
    }

    public Order checkOutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime){
        return checkOutOrder(user, orderType,paymentStrategy, new ScheduleOrderFactory(scheduleTime));
    }


    private Order checkOutOrder(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if(user.getCart().isEmpty()){
            return null;
        }
        Cart userCart = user.getCart();
        Restuarant restuarant = userCart.getRestaurant();
        double total = userCart.getTotalCost();
        List<MenuItem> menuItemList = userCart.getItems();
        Order order = orderFactory.createOrder(user, restuarant, menuItemList, paymentStrategy, total, orderType);
        OrderManager.getInstance().addRestuarant(order);
        return order;
    }

    public void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();
        if (isPaymentSuccess) {
//            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
    }


}
