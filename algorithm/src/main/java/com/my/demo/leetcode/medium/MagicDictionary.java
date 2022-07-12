package com.my.demo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ffdeng2
 * @date 2022-7-11 17:41
 */
public class MagicDictionary {

    Map<Integer, List<String>> map;

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = {"MagicDictionary", "buildDict", "search", "hello"};
        magicDictionary.buildDict(dictionary);
        String searchWord = "hhllo";
        System.out.println(magicDictionary.search(searchWord));
    }

    public MagicDictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            int length = str.length();
            if (map.containsKey(length)) {
                List<String> list = map.get(length);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(length, list);
            }
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        if (map.containsKey(length)) {
            List<String> list = map.get(length);
            char[] chars = searchWord.toCharArray();
            for (String str : list) {
                boolean flag = true;
                int time = 0;
                char[] chars1 = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != chars1[i]) {
                        time++;
                        if (time > 1) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (time == 1) {
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
