package com.my.demo.leetcode.string.medium;

/**
 * @author ffdeng2
 * 重复叠加字符串匹配
 */
public class T686 {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }

    public static int repeatedStringMatch(String a, String b) {
        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        int[] charArr = new int[26];
        for (char aChar : chars) {
            charArr[aChar - 'a']++;
        }
        for (char bChar : chars1) {
            if (charArr[bChar - 'a'] == 0) {
                return -1;
            }
        }

        int k = b.length() / a.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(a);
        }
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return k + i;
            }
            sb.append(a);
        }

        return -1;
    }

}
