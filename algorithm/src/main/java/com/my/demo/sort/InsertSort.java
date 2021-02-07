package com.my.demo.sort;

import java.util.Arrays;
import java.util.SortedMap;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 **/
public class InsertSort implements ArraysSort {

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = insertSort.getArr();
        insertSort.sort(arr);
        insertSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < ArraysSort.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
