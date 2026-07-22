package com.example.demo.designpatterns.template;

abstract class PhoneOrderTemp{
    public final void createOrder(){
        selectProduct();
        makePayment();
        packProduct();
        deliverProduct();
    }

    abstract void selectProduct();
    abstract void makePayment();
    void packProduct(){
         System.out.println("packing the product");
     }
    abstract void deliverProduct();
}

class OnlineStore extends PhoneOrderTemp{

    @Override
    void selectProduct() {
        System.out.println("Selecting the product in online store");
    }

    @Override
    void makePayment() {
        System.out.println("make the payment in online store");
    }

    @Override
    void deliverProduct() {
        System.out.println("deliver the product in online store");

    }
}

class OfflineStore extends PhoneOrderTemp{

    @Override
    void selectProduct() {
        System.out.println("Selecting the product in offline store");
    }

    @Override
    void makePayment() {
        System.out.println("make the payment in offline store");
    }

    @Override
    void deliverProduct() {
        System.out.println("deliver the product in offline store");

    }
}
public class TemplatePattern {

    public static void main(String[] args) {
        PhoneOrderTemp orderTemp  = new OnlineStore();
        orderTemp.createOrder();

        PhoneOrderTemp orderTemp1  = new OnlineStore();
        orderTemp1.createOrder();

    }
}
