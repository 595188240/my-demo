package com.my.demo.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ffdeng2
 */
public class T1218 {

    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

}
