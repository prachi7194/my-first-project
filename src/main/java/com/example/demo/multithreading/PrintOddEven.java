package com.example.demo.multithreading;

public class PrintOddEven {
    volatile static int count = 1;
    int n;
    PrintOddEven(int limit){
        this.n = limit;
    }
    public synchronized void printOddNumber(){
        while(count < n){
            if(count % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + count);
                count = count + 1;
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEvenNumber(){
        while(count <= n){
            if(count % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + count);
                count = count + 1;
                notifyAll();
            }else{
                try{
                    wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven printOddEven = new PrintOddEven(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printOddNumber();
            }
        });
        t1.setName("odd");
        Thread t2;
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printEvenNumber();
            }
        });
        t2.setName("even");
        t1.start();
        t2.start();
    }
}
