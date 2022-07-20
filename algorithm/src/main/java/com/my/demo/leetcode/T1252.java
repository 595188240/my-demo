package com.my.demo.leetcode;

/**
 * @author ffdeng2
 * @date 2022-7-12 10:11
 */
public class T1252 {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(m, n, indices));
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int result = 0;
        int[][] temp = new int[m][n];
        for (int[] ii : indices) {
            int hang = ii[0];
            int lie = ii[1];
            for (int i = 0; i < n; i++) {
                temp[hang][i]++;
            }
            for (int j = 0; j < m; j++) {
                temp[j][lie]++;
            }
        }
        for (int[] ii : temp) {
            for (int i : ii) {
                if ((i & 1) != 0) {
                    result++;
                }
            }
        }
        return result;
    }

}
