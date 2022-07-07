package com.my.demo.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2022-7-7 17:23
 */
public class T648 {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("rat");
        dictionary.add("bat");
        String sentence = "the cattle was rattled by the battery";
        // ["a","b","c"]
        // "aadsfasf absbs bbab cadsfafs"
        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : s) {
            int length = Integer.MAX_VALUE;
            String temp = str;
            for (String con : dictionary) {
                if (str.startsWith(con)) {
                    if (con.length() < length) {
                        temp = con;
                        length = con.length();
                    }
                }
            }
            stringBuilder.append(temp).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
