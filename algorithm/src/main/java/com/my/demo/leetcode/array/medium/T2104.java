package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 * @date 2022-3-4 10:14
 */
public class T2104 {

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};
        System.out.println(subArrayRanges(nums));
    }

    public static long subArrayRanges(int[] nums) {
        long result = 0L;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                result += max - min;
            }
        }
        return result;
    }

}
