package com.my.demo.leetcode.array.medium;

import java.util.*;

/**
 * @author ffdeng2
 */
public class T229 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.forEach((k, v) -> {
            if (v > count) {
                result.add(k);
            }
        });
        return result;
    }

}
