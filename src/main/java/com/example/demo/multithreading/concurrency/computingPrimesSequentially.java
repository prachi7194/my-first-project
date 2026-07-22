package com.example.demo.multithreading.concurrency;

public class computingPrimesSequentially {
    public static void main(String[] args) {
        int count = 0;
        long startTime = System.nanoTime();

        for(int i = 0; i < 1000000000;i++){

            if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0){
                count = count + 1;
            }

        }

        long endTime = System.nanoTime();

        System.out.println("Count = " + count);

        long elapsedTime = endTime - startTime;
        System.out.println("Time (seconds): " + elapsedTime / 1_000_000_000.0);
    }
}
