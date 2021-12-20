package com.my.demo.leetcode.string.simple;

/**
 * @author ffdeng2
 *截断句子
 */
public class T1816 {

    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(truncateSentence(s, k));
        System.out.println(truncateSentence2(s, k));
    }

    public static String truncateSentence2(String s, int k) {
        int index = 0;
        int n = s.length();
        while (index < n) {
            if (s.charAt(index) == ' ' && --k == 0) {
                break;
            }
            index++;
        }
        return s.substring(0, index);
    }

    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(s1[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
