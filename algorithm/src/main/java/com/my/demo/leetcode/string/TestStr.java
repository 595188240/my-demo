package com.my.demo.leetcode.string;

/**
 * @author ffdeng
 * @date 2021/6/9 17:18
 */
public class TestStr {

    public static void main(String[] args) {
        String strA = "sgdsljgds;gd;ls;lgkd;skgdsjklgjdlks";
        String strB = "sfkl";
        System.out.println(findStr(strA, strB));
    }

    public static int findStr(String strA, String strB) {
        int index = 0;
        char[] arrA = strA.toCharArray();
        char[] arrB = strB.toCharArray();
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == arrB[index]) {
                index++;
                if (index == arrB.length - 1) {
                    return 1;
                }
            } else {
                index = 0;
            }
        }
        return -1;
    }
}
