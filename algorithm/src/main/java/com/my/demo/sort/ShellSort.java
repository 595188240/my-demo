package com.my.demo.sort;

import java.util.Arrays;

/**
 * Licensed to CMIM,Inc. under the terms of the CMIM
 * Software License version 1.0.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date        Author        Version        Comments
 * 2021/2/6     ffdeng         1.0       Initial Version
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {352,46754754,5,32,32,4,234,23,469};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int gar = length / 2;

        while (gar > 0) {
            for (int i = gar; i < length; i++) {
                int temp = arr[i];
                int j = i - gar;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + gar] = arr[j];
                    j -= gar;
                }
                arr[j + gar] = temp;
            }
            gar /= 2;
        }
    }
}
