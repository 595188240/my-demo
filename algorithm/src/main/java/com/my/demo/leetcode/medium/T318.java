package com.my.demo.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffdeng2
 * 最大单词长度乘积
 */
public class T318 {

    public static void main(String[] args) {
        String[] words = {"edadc","ebbfe","aacdde","dfe","cb","fddddff","fabca","adccac","ece","ccaf","feba","bcb","edadc","aea","bacb","acefa","fcebffd","dfeebca","bedcbaa","deaccc","abedc","dadff","eef","ddebbb","abecab","cd","abdeee","eedce","deef","dceaddd","ced","fbbf","ba","eefeda","fb","cddc","adafbf","dded","aadbf","caefbaf","ccebf","dbb","ee","dadcecc","ddbcabb","afeaa","ec","aad","efde","cbcda","cdbdafd","cddc","ecaaa","ae","cfc","bccac","cdcc","abbbf","fcdface","ddbcdc","bfebb","daed","bc","dc","ecdfc","eeb","bb","dad","caecb","fbe","bbbc","cacea","dbc","fbe","bcfffbd","aeda","cff","ddfc","ea","bdfd","ccb","cb","ae","ceabefa","dcea","cbaed","bfedf","fa","ccd","fece","bceef","acabca","dafa","fdeec","dac","cae","adeeadb","ecacc","acfe","de"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j< words.length; j++) {
                if (getFlag(words[i], words[j])) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    public static boolean getFlag(String temp, String tmp) {
        Set<Character> set = new HashSet<>();
        char[] tempChars = temp.toCharArray();
        char[] tmpChars = tmp.toCharArray();
        for (char tempChar : tempChars) {
            set.add(tempChar);
        }
        for (char tmpChar : tmpChars) {
            if (set.contains(tmpChar)) {
                return false;
            }
        }
        return true;
    }
}
