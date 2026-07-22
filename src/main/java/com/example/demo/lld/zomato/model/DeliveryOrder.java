package com.example.demo.lld.zomato.model;

public class DeliveryOrder extends Order {

    private String userAddress;
    public DeliveryOrder(){
        userAddress = "";
    }
    @Override
    public String getType() {
        return "Delivery";
    }

    public void setUserAddress(String addr) {
        userAddress = addr;
    }

    public String getUserAddress() {
        return userAddress;
    }

}
