package com.my.demo.leetcode.simple;

/**
 * @author ffdeng2
 * 亲密字符串
 */
public class T859 {

    public static void main(String[] args) {
        String s = "aaaaaaabc";
        String goal = "aaaaaaacb";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if (a != b) {
                sum++;
            }
        }
        // 检查全是相同字母情况
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                ok = true;
            }
        }
        return sum == 2 || (sum == 0 && ok);
    }
}
