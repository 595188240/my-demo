package com.test.sync;

import java.util.concurrent.*;

/**
 * @author ffdeng2
 * @date 2022-6-15 11:36
 */
public class CallableTest {

    static String str = "a";
    static String str2 = "c";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 10; i++) {
            FutureTask<String> submit = new FutureTask<>(() -> str += "b");
            executorService.submit(submit);
            System.out.println(submit.get());

            Future<String> submit1 = executorService.submit(() -> str2 += "d");
            System.out.println(submit1.get());
        }
        executorService.shutdown();
    }

}
