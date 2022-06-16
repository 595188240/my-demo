package com.test.sync;

/**
 * @author ffdeng2
 * @date 2022-6-14 11:24
 */
public class LoadStore {

    static volatile int num = 0;

    public static void main(String[] args) {
        int temp = 100;
        num += temp;
    }
}
