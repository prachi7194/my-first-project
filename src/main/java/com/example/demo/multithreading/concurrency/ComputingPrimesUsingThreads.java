package com.example.demo.multithreading.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComputingPrimesUsingThreads {
    private static final int LIMIT = 1000000000;

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();
        int chunkSize = LIMIT / 4;
        for(int i = 0; i < 4; i++){
            int start = i*chunkSize;
            int end = start + chunkSize;
            futures.add(executorService.submit(() -> {
                int localCount = 0;
                for(int j = start; j < end; j++){
                    if(j % 2 != 0 && j % 3 != 0 && j % 5 != 0){
                        localCount = localCount + 1;

                    }
                }
                return localCount;

            }));

        }
        int totalCount = 0;
        for(Future<Integer> future:futures){
            totalCount = totalCount + future.get();
        }
        executorService.shutdown();
        long endTime = System.nanoTime();
        System.out.println("Count = " + totalCount);
        System.out.printf("Time taken = %.3f seconds%n",
                (endTime - startTime) / 1_000_000_000.0);


    }
}
