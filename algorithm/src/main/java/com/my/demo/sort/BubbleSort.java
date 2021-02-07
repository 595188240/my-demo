package com.my.demo.sort;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 **/
public class BubbleSort implements ArraysSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = bubbleSort.getArr();
        bubbleSort.sort(arr);
        bubbleSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < ArraysSort.length - 1; i++) {
            for (int j = i + 1; j < ArraysSort.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
