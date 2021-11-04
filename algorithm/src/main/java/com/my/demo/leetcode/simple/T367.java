package com.my.demo.leetcode.simple;

/**
 * @author ffdeng2
 */
public class T367 {

    public static void main(String[] args) {
        int num = 1;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int begin = 2;
        int end = num;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            int temp = mid * mid;
            if (temp == num) {
                return true;
            }
            else if (temp > num) {
                end = mid - 1;
            }
            else if (temp < num) {
                begin = mid + 1;
            }
        }
        return false;
    }

}
