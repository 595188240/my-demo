package com.my.demo.sort;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 **/
public class MergeSort implements ArraysSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = mergeSort.getArr();
        mergeSort.sort(arr);
        mergeSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    public void merge(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (end - start) / 2 + start;
            merge(arr, start, mid);
            merge(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
    }

    public void mergeSort(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int begin = start;
        int midd = mid + 1;
        int index = 0;
        while (begin <= mid && midd <= end) {
            if (arr[begin] <= arr[midd]) {
                result[index++] = arr[begin++];
            } else {
                result[index++] = arr[midd++];
            }
        }

        while (begin <= mid) {
            result[index++] = arr[begin++];
        }
        while (midd <= end) {
            result[index++] = arr[midd++];
        }

        index = 0;
        while (start <= end) {
            arr[start++] = result[index++];
        }
    }
}
