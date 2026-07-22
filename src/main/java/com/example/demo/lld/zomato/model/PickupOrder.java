package com.example.demo.lld.zomato.model;

public class PickupOrder extends Order {

    private String restuarantAddress;

    public PickupOrder() {
        restuarantAddress = "";
    }


    @Override
    public String getType() {
        return "Pickup";
    }

    public void setRestaurantAddress(String addr) {
        restuarantAddress = addr;
    }

    public String getRestaurantAddress() {
        return restuarantAddress;
    }
}
