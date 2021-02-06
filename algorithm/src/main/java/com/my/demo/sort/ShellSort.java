package com.my.demo.sort;

import java.util.Arrays;

/**
 * Date        Author
 * 2021/2/6     ffdeng
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = CreateArrays.getArray();

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
