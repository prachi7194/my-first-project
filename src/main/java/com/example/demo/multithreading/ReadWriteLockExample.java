package com.example.demo.multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource3{
    public void produce(ReadWriteLock readWriteLock){
        try{
            readWriteLock.readLock().lock();
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally
        {
            readWriteLock.readLock().unlock();
            System.out.println("Read lock released by " + Thread.currentThread().getName());

        }
    }


    public void consume(ReadWriteLock readWriteLock){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally
        {
            readWriteLock.writeLock().unlock();
            System.out.println("Write lock released by " + Thread.currentThread().getName());

        }
    }

}
public class ReadWriteLockExample {
    public static void main(String[] args) {
        SharedResource3 obj = new SharedResource3();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(() -> obj.produce(lock));
        Thread t2 = new Thread(() -> obj.produce(lock));
        SharedResource3 obj1 = new SharedResource3();
        Thread t3 = new Thread(() -> obj1.consume(lock));
        t1.start();
        t2.start();
        t3.start();
    }
}
