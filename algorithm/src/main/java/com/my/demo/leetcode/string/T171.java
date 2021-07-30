package com.my.demo.leetcode.string;

/**
 * @author ffdeng2
 * @date 2021-7-30 16:45
 * Excel 表列序号
 */
public class T171 {

    public static void main(String[] args) {
        String columnTitle = "FXSHRXW";
        System.out.println(titleToNumber(columnTitle));
    }

    public static int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int index = 1;
        int result = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
           int temp = arr[i] - 'A' + 1;
           result += temp * index;
           index *= 26;
        }
        return result;
    }

}
