package com.test.sync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ffdeng2
 * @date 2022-6-15 16:08
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(() -> 1);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
