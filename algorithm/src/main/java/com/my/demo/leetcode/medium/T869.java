package com.my.demo.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffdeng2
 */
public class T869 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(reorderedPowerOf2(n));
    }

    static Set<String> powerOf2Digits = new HashSet();

    public static boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public static void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    public static String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }

}
