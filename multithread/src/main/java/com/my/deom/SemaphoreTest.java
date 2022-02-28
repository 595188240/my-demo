package com.my.deom;

import java.util.concurrent.Semaphore;

/**
 * @author ffdeng2
 */
public class SemaphoreTest {

    private static volatile int count = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(20);
        for (int i = 1; i < 100; i++) {
            new Thread(() -> {
                //try {
                //    semaphore.acquire();
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                boolean b = semaphore.tryAcquire();
                //System.out.println("线程" + Thread.currentThread().getName() + "进入，当前有" + semaphore.availablePermits());
                if (b) {
                    //count++;
                    System.out.println("抢到了->" + count);
                } else {
                    System.out.println("很遗憾！");
                }
                //try {
                //    TimeUnit.SECONDS.sleep(6);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                //semaphore.release();
            }).start();
        }
    }
}
