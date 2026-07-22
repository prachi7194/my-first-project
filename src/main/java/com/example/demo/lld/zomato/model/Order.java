package com.example.demo.lld.zomato.model;

import lld.zomato.strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private int id;
    private User user;
    private Restuarant restuarant;
    private List<MenuItem> menuItemList;
    private PaymentStrategy paymentStrategy;
    private double total;
    private String scheduled;

    Order(){
        this.user = null;
        this.restuarant = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";

    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }else{
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }

    public abstract String getType();


    //add getters and setters
    public void setUser(User u){
        this.user = u;
    }
    public User getUser(){
        return this.user;
    }
    public void setRestuarant(Restuarant restuarant){
        this.restuarant = restuarant;
    }
    public Restuarant getRestuarant(){
        return restuarant;
    }
    public void setItems(List<MenuItem> its) {
        menuItemList = its;
        total = 0;
        for (MenuItem i : menuItemList) {
            total += i.getPrice();
        }
    }
    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }

    public void setPaymentStrategy(PaymentStrategy p) {
        paymentStrategy = p;
    }

    public void setScheduled(String s) {
        scheduled = s;
    }

    public String getScheduled() {
        return scheduled;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
