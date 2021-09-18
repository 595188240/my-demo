package com.my.demo.leetcode.simple;

/**
 * @author ffdeng2
 */
public class T292 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(canWinNim(n));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
