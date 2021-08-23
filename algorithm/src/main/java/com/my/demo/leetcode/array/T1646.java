package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T1646 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(getMaximumGenerated(n));
    }

    public static int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 1; i < (n + 1) / 2; i++) {
            if (i * 2 <= n) {
                result[2 * i] = result[i];
            }
            if (2 * i + 1 <= n) {
                result[2 * i + 1] = result[i] + result[i + 1];
            }
        }
        Arrays.sort(result);
        return result[result.length - 1];
    }

}
