package com.test.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ffdeng2
 * @date 2022-6-10 17:45
 */
public class UnLock {

    static volatile Object A = new Object();
    static Object B = new Object();
    
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                try {
                    System.out.println(Thread.currentThread().getName() + "拿到A等待3秒去拿B");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + "拿到B");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B) {
                try {
                    System.out.println(Thread.currentThread().getName() + "拿到B等待3秒去拿A");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + "拿到A");
                }
            }
        }).start();
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
