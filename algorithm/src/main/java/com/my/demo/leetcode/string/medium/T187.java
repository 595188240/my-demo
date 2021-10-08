package com.my.demo.leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ffdeng2
 */
public class T187 {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
        System.out.println(findRepeatedDnaSequences2(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int length = 10;
        if (s.isEmpty() || s.length() < length) {
            return result;
        }
        Set<String> resultSet = new HashSet<>();
        Set<String> stringSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int begin = 0;
        while (begin <= chars.length - length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = begin; i < begin + length; i++) {
                stringBuilder.append(chars[i]);
            }
            if (!stringSet.add(stringBuilder.toString())) {
                resultSet.add(stringBuilder.toString());
            }
            begin++;
        }

        result.addAll(resultSet);
        return result;
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        int length = 10;
        Set result = new HashSet();
        Set set = new HashSet();
        for (int i = 0; i <= s.length() - length; i++) {
            String temp = s.substring(i, i + length);
            if (!set.add(temp)) {
                result.add(temp);
            }
        }
        return new ArrayList<>(result);
    }
}
