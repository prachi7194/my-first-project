package com.example.demo.multithreading;

import java.util.ArrayList;
import java.util.List;

class SharedResource{
    int capacity;
    List<Integer> arr;
    SharedResource(int capacity){
        this.capacity = capacity;
        arr = new ArrayList<>();
    }

    public synchronized void addItem(int item){
        if(arr.size() == capacity){
            try {
                System.out.println(Thread.currentThread() + " is waiting to add items");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread() + " item added successfully");

        arr.add(item);
        notifyAll();


    }

    public synchronized void consumeItem(){
        if(arr.isEmpty()){
            try {
                System.out.println(Thread.currentThread() + " is waiting to consume items");

                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread() + " consumed item successfully");

        arr.remove(arr.size() - 1);
        notifyAll();

    }

}
public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(1);
        Thread t1 = new Thread(() -> sharedResource.addItem(10));
        Thread t2 = new Thread(sharedResource::consumeItem);
        t1.start();
        t2.start();



    }
}
