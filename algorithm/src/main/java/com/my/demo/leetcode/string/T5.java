package com.my.demo.leetcode.string;

/**
 * @author ffdeng
 * @date 2021-6-21 18:46
 */
public class T5 {

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        String s = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        System.out.println(longestPalindrome(s));
        System.out.println("haoshi:" + (System.currentTimeMillis() - b));

        long b2 = System.currentTimeMillis();

        System.out.println(longestPalindrome2(s));
        System.out.println("haoshi:" + (System.currentTimeMillis() - b2));

        long b3 = System.currentTimeMillis();

        System.out.println(longestPalindrome3(s));
        System.out.println("haoshi:" + (System.currentTimeMillis() - b3));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
           return s;
        }

        char[] arr = s.toCharArray();
        String result = arr[0] + "";
        for (int i = 0; i < arr.length - 1; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                stringBuffer.append(arr[j]);
                String temp = stringBuffer.toString();
                String pmet = stringBuffer.reverse().toString();
                if (temp.equals(pmet)) {
                    if (result.length() < temp.length()) {
                        result = temp;
                    }
                }
                stringBuffer.reverse();
            }
        }
        return result;
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public static String longestPalindrome2(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = test;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public static String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left , right;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
