package com.example.demo.multithreading;

public class MonitorLockExample {

    int count = 4;

    public synchronized void task1(){
        try{
            System.out.println("inside task 1 "+ count);
            count = 5;
            Thread.sleep(10000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void task2(){
        System.out.println(" task 2 but before synchronized " + count);
        synchronized (this){
            System.out.println(" task 2 but after synchronized " + count);
        }
    }

    public  void task3(){
        System.out.println("task3 without synchronized");
    }

    public static void main(String[] args) {
        MonitorLockExample obj1 = new MonitorLockExample();
        MonitorLockExample obj2 = new MonitorLockExample();
        Thread t1 = new Thread(obj1::task1);
        Thread t2 = new Thread(obj2::task2);
        Thread t3 = new Thread(obj1::task3);
        t1.start();
        t2.start();
        t3.start();

    }
}
