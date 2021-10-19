package com.my.demo.leetcode.simple;

/**
 * @author ffdeng2
 */
public class T476 {

    public static void main(String[] args) {
        int num = 1;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
        return Integer.valueOf(String.valueOf(chars), 2);
    }

}
