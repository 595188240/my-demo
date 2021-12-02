package com.my.demo.leetcode.array.simple;

import java.util.*;

/**
 * @author ffdeng2
 * 相对名次
 */
public class T506 {

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    public static String[] findRelativeRanks(int[] score) {
        int[] result = Arrays.copyOf(score, score.length);
        Arrays.sort(score);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            map.put(score[i], index++);
        }
        index = 0;
        String[] resultStr = new String[result.length];
        for (int i : result) {
            resultStr[index++] = getRank(map.get(i));
        }
        return resultStr;
    }

    public static String getRank(int n) {
        if (n == 1) {
            return "Gold Medal";
        } else if (n == 2) {
            return "Silver Medal";
        } else if (n == 3) {
            return "Bronze Medal";
        } else {
            return String.valueOf(n);
        }
    }

}
