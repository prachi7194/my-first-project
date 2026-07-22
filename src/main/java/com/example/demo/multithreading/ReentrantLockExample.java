package com.example.demo.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource1{
    boolean isAvailable = false;
    public void produce(ReentrantLock reentrantLock){
        try {
            reentrantLock.lock();
            System.out.println("lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("lock released by : " + Thread.currentThread().getName());
            reentrantLock.unlock();



        }
    }
}
public class ReentrantLockExample {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        SharedResource1 sharedResource1 = new SharedResource1();
        Thread t1 = new Thread(() -> sharedResource1.produce(reentrantLock));
        SharedResource1 sharedResource2 = new SharedResource1();
        Thread t2 = new Thread(() -> sharedResource2.produce(reentrantLock));
        t1.start();
        t2.start();

    }

}
