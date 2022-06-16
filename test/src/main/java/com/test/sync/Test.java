package com.test.sync;

import java.util.concurrent.CompletableFuture;

/**
 * @author ffdeng2
 * @date 2022-6-15 11:35
 */
public class Test {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(1000L);
                return "test";
            } catch (Exception e){
                return "failed test";
            }
        });
        future.complete("manual test");
        System.out.println(future.join());
    }
}
