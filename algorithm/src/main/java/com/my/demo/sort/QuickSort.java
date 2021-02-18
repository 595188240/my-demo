package com.my.demo.sort;

/**
 * @author dengff
 * @date 2021/2/18-13:26
 **/
public class QuickSort implements ArraysSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = quickSort.getArr();
        quickSort.sort(arr);
        quickSort.printArr(arr);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int piont = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < piont) {
                l++;
            }
            while (arr[r] > piont) {
                r--;
            }

            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == piont) {
                r --;
            }

            if (arr[r] == piont) {
                l ++;
            }
        }

        if (l == r) {
            l ++;
            r --;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int temp = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) {
                l++;
            }
            arr[r] = arr[l];
        }

        arr[l] = temp;
        quickSort2(arr, l + 1, right);
        quickSort2(arr, left, l - 1);
    }
}
