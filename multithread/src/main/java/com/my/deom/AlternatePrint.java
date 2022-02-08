package com.my.deom;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ffdeng2
 */
public class AlternatePrint {

    public static int i = 0;

    public static Object lock = new Object();

    public static void main(String[] args) {
        //print();
        print1();
    }

    private static void print1() {
        CompletableFuture t1 = CompletableFuture.runAsync(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("线程1 -> " + i++);
                    lock.notifyAll();
                    try {
                        lock.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        CompletableFuture t2 = CompletableFuture.runAsync(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("线程2 -> " + i++);
                    lock.notifyAll();
                    try {
                        lock.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        CompletableFuture.allOf(t1, t2).join();
    }

    private static void print() {
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " i = " + i++);
                    lock.notify();
                    try {
                        lock.wait();
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " i = " + i++);
                    lock.notify();
                    try {
                        lock.wait();
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }
}

