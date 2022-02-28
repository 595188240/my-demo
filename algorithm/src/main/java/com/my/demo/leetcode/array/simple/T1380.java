package com.my.demo.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2022-2-15 9:44
 */
public class T1380 {

    public static void main(String[] args) {
        int[][] matrix = {{7,8},{1,2}};
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] ii = matrix[i];
            int index = -1;
            int result = Integer.MAX_VALUE;
            for (int j = 0; j < ii.length; j++) {
                if (ii[j] < result) {
                    result = ii[j];
                    index = j;
                }
            }

            int top = i;
            Boolean topFlag = true;
            while (top >= 0) {
                int temp = matrix[top][index];
                if (result < temp) {
                    topFlag = false;
                    break;
                }
                top--;
            }

            int bottom = i;
            Boolean bottomFlag = true;
            while (bottom < matrix.length) {
                int temp = matrix[bottom][index];
                if (result < temp) {
                    bottomFlag = false;
                    break;
                }
                bottom++;
            }
            if (topFlag && bottomFlag) {
                list.add(result);
            }
        }
        return list;
    }
}
