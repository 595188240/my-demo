package com.my.demo.leetcode.array.simple;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T66 {

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int tmp = digits[digits.length - 1];
        tmp += 1;
        int jin;
        if (tmp > 9) {
            tmp = 10 - tmp;
            jin = 1;
            digits[digits.length - 1] = tmp;
        } else {
            digits[digits.length - 1] = tmp;
            return digits;
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            if (jin == 0) {
                break;
            }
            if (digits[i] + jin > 9) {
                digits[i] = digits[i] + jin - 10;
                jin = 1;
            } else {
                digits[i] = digits[i] + jin;
                jin = 0;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

}
