package com.my.demo.leetcode.string;

/**
 * @author ffdeng2
 */
public class T641 {

    public static void main(String[] args) {
        String s = "abcdef";
        int k = 3;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        char[] arr = s.toCharArray();
        // 循环数组没 2 * k 为迭代
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k, length) - 1;
            // 交换位置
            while (right > left) {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return new String(arr);
    }
}
