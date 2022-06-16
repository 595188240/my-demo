package com.test.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ffdeng2
 * @date 2022-6-13 18:51
 */
public class VolatileTest {

    static volatile int num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
