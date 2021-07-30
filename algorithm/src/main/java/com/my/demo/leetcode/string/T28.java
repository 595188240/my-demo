package com.my.demo.leetcode.string;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2021-7-22 16:19
 * 实现这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符
 */
public class T28 {

    public static void main(String[] args) {
        String haystack = "abbccefeghryz";
        String needle = "efeg";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr2(haystack, needle));
        System.out.println(haystack.indexOf(needle));
        System.out.println(function(haystack, needle));

        String p = "abaabac";
        System.out.println(Arrays.toString(computePrefixFunction(p)));
    }

    public static int function(final String n, final String m) {
        int nLength = n.length();
        int mLength = m.length();
        int[] pi = new int[mLength];
        for (int i = 1,j = 0; i < mLength; i++) {
            while (j > 0 && m.charAt(i) != m.charAt(j)) {
                j = pi[j - 1];
            }
            if (m.charAt(i) == m.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < nLength; i++) {
            while (j > 0 && n.charAt(i) !=m.charAt(j)) {
                j = pi[j - 1];
            }
            if (n.charAt(i) == m.charAt(j)) {
                j++;
            }
            if (j == mLength) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] computePrefixFunction(final String P) {
        final int n = P.length();
        final int[] pi = new int[n];
        pi[0] = 0;
        int q = 0;
        for (int i = 1; i < n; i++) {
            while (q > 0 && P.charAt(q) != P.charAt(i)) {
                q = pi[q - 1];
            }

            if (P.charAt(q) == P.charAt(i)) {
                q++;
            }

            pi[i] = q;
        }
        return pi;
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < n - m + 1; i++) {
            while (haystack.charAt(i + index) == needle.charAt(index)) {
                index++;
                if (index == m) {
                    return i;
                }
            }
            index = 0;
        }
        return -1;
    }

    // kmp
    public static int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
