package com.my.demo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 **/
public interface ArraysSort {

    void sort(int[] arr);

    int length = 50;

    default int[] getArr() {
        int[] arr = new int[length];
        Random random = new Random(10);
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    default void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
