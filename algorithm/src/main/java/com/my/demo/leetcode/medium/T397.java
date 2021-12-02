package com.my.demo.leetcode.medium;

/**
 * @author ffdeng2
 * 整数替换
 */
public class T397 {

    public static void main(String[] args) {
        int n = 65535;
        System.out.println(integerReplacement(n));
    }

    public static int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

}
