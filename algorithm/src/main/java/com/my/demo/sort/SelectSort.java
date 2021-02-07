package com.my.demo.sort;

import java.util.Arrays;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 **/
public class SelectSort implements ArraysSort {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = selectSort.getArr();
        selectSort.sort(arr);

        selectSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < ArraysSort.length - 1; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < ArraysSort.length; j++) {
                if (temp > arr[j]) {
                    int tmp = temp;
                    temp = arr[j];
                    arr[j] = tmp;
                }
            }
            arr[i] = temp;
        }
    }
}
