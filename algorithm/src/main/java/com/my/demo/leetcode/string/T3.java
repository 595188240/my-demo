package com.my.demo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Date        Author        Version        Comments
 * 2021/3/15     ffdeng         1.0       Initial Version
 *3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 **/
public class T3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.add(chars[i])) {
                if (set.size() > result) {
                    result = set.size();
                }
            } else {
                // aab
                i -= set.size();
                set.clear();
            }
        }
        return result;
    }
}
