package com.my.demo.leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ffdeng2
 */
public class T299 {

    public static void main(String[] args) {
        String secret = "11";
        String guess = "10";
        System.out.println(getHint(secret, guess));
        System.out.println(getHint2(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int length = secret.length();
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                list.add(guess.charAt(i));
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for (Character character : list) {
            if (map.containsKey(character) && map.get(character) > 0) {
                b++;
                map.put(character, map.get(character) - 1);
            }
        }

        return a + "A" + b + "B";
    }

    public static String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<s.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
            }
            else {
                list.add(g[i]);
                if (map.containsKey(s[i])) {
                    map.put(s[i], map.get(s[i]) + 1);
                }
                else {
                    map.put(s[i], 1);
                }
            }
        }

        for (Character character : list) {
            if (map.containsKey(character)) {
                cows++;
                if ((map.get(character) - 1) >0) {
                    map.put(character, map.get(character) - 1);
                }
                else {
                    map.remove(character);
                }
            }
        }

        return bulls+"A"+cows+"B";
    }
}
