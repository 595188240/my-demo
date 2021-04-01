package com.my.demo.leetcode;

import java.util.Arrays;

/**
 * Date        Author        Version        Comments
 * 2021/3/16     ffdeng         1.0       Initial Version
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 **/
public class T59 {

    public static void main(String[] args) {
        int n = 3;
        dayin(generateMatrix(n));
        dayin(generateMatrix2(n));
    }

    private static void dayin(int[][] result) {
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints) + " ");
        }
    }

    public static int[][] generateMatrix(int n) {
        int l = 0, r = n -1, t = 0, b = n - 1;
        int begin = 1;
        int end = n * n;
        int [][] result = new int[n][n];
        while (begin <= end) {
            for (int i = l; i <= r; i++) {
                result[t][i] = begin++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                result[i][r] = begin++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                result[b][i] = begin++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                result[i][l] = begin++;
            }
            l++;
        }
        return result;
    }


    public static int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
