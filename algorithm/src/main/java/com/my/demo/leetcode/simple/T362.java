package com.my.demo.leetcode.simple;

/**
 * @author ffdeng2
 */
public class T362 {

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
        System.out.println(isPowerOfThree2(n));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return  false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return  false;
        }
        int num = 3;
        while (num < n) {
            num *= 3;
        }
        return num == n;
    }
}
