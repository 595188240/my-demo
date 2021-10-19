package com.my.demo.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ffdeng2
 * T211
 */
public class WordDictionary {

    private Map<Integer, Set<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if (map.containsKey(word.length())) {
            Set<String> strings = map.get(word.length());
            strings.add(word);
        } else {
            Set set = new HashSet();
            set.add(word);
            map.put(word.length(), set);
        }
    }

    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }

        Set<String> strings = map.get(word.length());
        if (!word.contains(".")) {
            return strings.contains(word);
        } else {
            for (String string : strings) {
                char[] chars = string.toCharArray();
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    if (word.charAt(i) == '.') {
                        index++;
                        continue;
                    }
                    if (chars[i] == word.charAt(i)) {
                        index++;
                    }
                }
                if (index == word.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
