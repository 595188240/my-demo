package com.my.demo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 */
public class T1447 {

    public static void main(String[] args) {
        // 1 <= n <= 100
        int n = 4;
        System.out.println(simplifiedFractions(n));
    }


    public static List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcb(i, j) == 1) {
                    result.add(i + "/" + j);
                }
            }
        }
        return result;
    }

    public static int gcb(int a, int b) {
        return b == 0 ? a : gcb(b, a - a / b * b);
    }
}
