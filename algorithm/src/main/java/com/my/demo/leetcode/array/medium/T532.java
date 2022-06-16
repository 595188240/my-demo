package com.my.demo.leetcode.array.medium;

import java.util.*;

/**
 * @author ffdeng2
 * @date 2022-6-16 13:55
 */
public class T532 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;
        System.out.println(findPairs(nums, k));
        System.out.println(findPairs2(nums, k));
        System.out.println(findPairs3(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        Set<Set<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    Set setInt = new HashSet();
                    setInt.add(nums[i]);
                    setInt.add(nums[j]);
                    set.add(setInt);
                }
            }
        }
        return set.size();
    }

    public static int findPairs2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int result = 0;
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            }
            if (k == 0) {
                if (map.get(i) > 1) {
                    result++;
                }
            } else {
                if (map.getOrDefault(i + k, 0) > 0) {
                    result++;
                }
                if (map.getOrDefault(i - k, 0) > 0) {
                    result++;
                }
            }
            map.put(i, 0);
        }
        return result;
    }

    public static int findPairs3(int[] nums, int k) {
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int num : nums) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int num : numToCnt.keySet()) {
            if (k == 0) {
                if (numToCnt.get(num) > 1) {
                    res++;
                }
            } else {
                if (numToCnt.containsKey(num + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
