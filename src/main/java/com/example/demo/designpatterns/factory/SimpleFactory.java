package com.example.demo.designpatterns.factory;

interface Burger{
    public void prepare();
}

class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BurgerFactory{
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        }else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger();
        }else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger();
        }
        else{
            System.out.println("invalid burger type");
            return null;
        }


    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        String type = "standard";
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger burger = burgerFactory.createBurger(type);
        burger.prepare();
    }


}
