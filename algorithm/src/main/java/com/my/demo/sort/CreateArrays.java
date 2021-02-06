package com.my.demo.sort;

import java.util.Random;

/**
 * Date        Author
 * 2021/2/6     ffdeng
 **/
public class CreateArrays {

    public static int length = 500;

    public static int[] getArray() {
        int[] arr = new int[length];
        Random random = new Random(10000);
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}
