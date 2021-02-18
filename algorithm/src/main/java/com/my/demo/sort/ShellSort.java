package com.my.demo.sort;

/**
 * Date        Author
 * 2021/2/6     ffdeng
 **/
public class ShellSort implements ArraysSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = shellSort.getArr();
        shellSort.sort(arr);

        shellSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        int length = ArraysSort.length;
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
