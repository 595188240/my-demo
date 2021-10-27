package com.test.sync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author ffdeng2
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture[] completableFutures =  new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // supplyAsync 需返回值
            //completableFutures[i] = CompletableFuture.supplyAsync(() -> finalI);
            // runAsync无返回值
            completableFutures[i] = CompletableFuture.runAsync(() -> {
                System.out.println(finalI);
            });
        }

        CompletableFuture.allOf(completableFutures).join();
        for (CompletableFuture completableFuture : completableFutures) {
            // supplyAsync为return值 runAsync为null
            System.out.println(completableFuture.get());
        }
    }

}
