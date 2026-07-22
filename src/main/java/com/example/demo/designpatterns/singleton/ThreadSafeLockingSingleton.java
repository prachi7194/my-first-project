package com.example.demo.designpatterns.singleton;

public class ThreadSafeLockingSingleton {

    private static ThreadSafeLockingSingleton instance = null;

    private ThreadSafeLockingSingleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public synchronized static  ThreadSafeLockingSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeLockingSingleton();
        }
        return instance;

    }

    public static void main(String[] args) {
        ThreadSafeLockingSingleton s1 = ThreadSafeLockingSingleton.getInstance();
        ThreadSafeLockingSingleton s2 = ThreadSafeLockingSingleton.getInstance();
        System.out.println(s1 == s2);


    }
}
