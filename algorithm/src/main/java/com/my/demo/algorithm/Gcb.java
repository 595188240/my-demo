package com.my.demo.algorithm;

/**
 * Date        Author
 * 2021/2/7     ffdeng
 *
 * 欧几里得算法又称辗转相除法，是指用于计算两个非负整数a，b的最大公约数。
 * 应用领域有数学和计算机两个方面。计算公式gcd(a,b) = gcd(b,a mod b)
 **/
public class Gcb {

    public static void main(String[] args) {
        int a = 1024;
        int b = 1023;
        System.out.println(gcb(a, b));
    }

    public static int gcb(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcb(b, a - a / b * b);
    }
}
