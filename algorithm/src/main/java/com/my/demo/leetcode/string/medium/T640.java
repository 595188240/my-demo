package com.my.demo.leetcode.string.medium;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2022-8-10 14:00
 */
public class T640 {

    public static void main(String[] args) {
        // x+5-3+x=6+x-2 x=2
        // x=x Infinite solutions
        // 2x=x x = 0
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(equation));
    }

    public static String solveEquation(String equation) {
        // 把x移到左边，把其他移到右边
        String[] arr1 = equation.split("=");
        int left = 0;
        int right = 0;

        String[] arr2 = arr1[0].replace("-", "+-").split("\\+");
        String[] arr3 = arr1[1].replace("-", "+-").split("\\+");
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        // 等式左边的处理
        for (String s : arr2) {
            if (s.equals("x")) {
                left += 1;
            } else if (s.equals("-x")) {
                left += -1;
            } else if (s.contains("x")) {
                left += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right -= Integer.parseInt(s);
            }
        }

        // 等式右边的处理
        for (String s : arr3) {
            if (s.equals("x")) {
                left -= 1;
            } else if (s.equals("-x")) {
                left -= -1;
            } else if (s.contains("x")) {
                left -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right += Integer.parseInt(s);
            }
        }

        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right/left;
        }
    }

}
