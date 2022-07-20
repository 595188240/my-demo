package com.my.demo.leetcode.array.hard;

/**
 * @author ffdeng2
 * @date 2022-7-14 13:49
 */
public class T745 {

    public static void main(String[] args) {
        String[] words = {"abbba", "abba"};
        WordFilter wordFilter = new WordFilter(words);
        String pref = "ab";
        String suff = "ba";
        System.out.println(wordFilter.f(pref, suff));
    }

    static class WordFilter {
        String[] word;

        public WordFilter(String[] words) {
            this.word = words;
        }

        // 超时
        public int f(String pref, String suff) {
            int n = pref.length();
            int m = suff.length();

            for (int i = word.length - 1; i >= 0; i--) {
                int length = word[i].length();
                if (length < n || length < m) {
                    continue;
                }
                boolean flag = Boolean.TRUE;
                for (int j = 0; j < n; j++) {
                    if (word[i].charAt(j) != pref.charAt(j)) {
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                for (int k = 0; k < m && flag; k++) {
                    if (word[i].charAt(length - m + k) != suff.charAt(k)) {
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                if (Boolean.TRUE.equals(flag)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
