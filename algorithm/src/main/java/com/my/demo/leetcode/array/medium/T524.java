package com.my.demo.leetcode.array.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ffdeng2
 */
public class T524 {

    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> dictionary = Arrays.asList(new String[]{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"});
        System.out.println(findLongestWord(s, dictionary));
        System.out.println(findLongestWord2(s, dictionary));
    }

    /**
     * 双指针，将符合的放入集合然后在筛选
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < dictionary.size(); k++) {
            int i = 0;
            int j = 0;
            String str = dictionary.get(k);
            while (i < str.length() && j < s.length()) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;

                if (i == str.length()) {
                    map.put(k, str.length());
                }
            }
        }
        if (map.size() == 0) {
            return "";
        }

        Integer max = map.values().stream().max(Integer::compareTo).get();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue().equals(max)) {
                result.add(dictionary.get(integerIntegerEntry.getKey()));
            }
        }

        return  result.stream().sorted().collect(Collectors.toList()).get(0);
    }

    /**
     * 先对字典进行排序，根据长度排序，若长度一直再按字母字典排
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord2(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });

        int length = s.length();
        for (String str : dictionary) {
            int i = 0;
            int j = 0;
            while (i < str.length() && j < length) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;

                if (i == str.length()) {
                    return str;
                }
            }
        }
        return "";
    }
}
