package com.example.demo.lld.zomato.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    CreditCardPaymentStrategy(String card){
        this.cardNumber = card;
    }


    @Override
    public void pay(double amount) {

        System.out.println("Paid ₹" + amount + " using Credit Card (" + cardNumber + ")");
    }
}
