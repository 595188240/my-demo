package com.my.demo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffdeng2
 */
public class T345 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                letter.append(arr[i]);
            }
        }
        if (letter.length() == 0) {
            return s;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                result.append(letter.charAt(index));
                index++;
            } else {
                result.append(arr[i]);
            }
        }
        return result.toString();
    }

}
