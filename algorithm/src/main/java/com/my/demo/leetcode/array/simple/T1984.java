package com.my.demo.leetcode.array.simple;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T1984 {

    public static void main(String[] args) {
        int[] nums = {9,1,4,7};
        int k = 2;
        System.out.println(minimumDifference(nums, k));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            result = Math.min(result, nums[i + k - 1] - nums[i]);
        }
        return result;
    }

}
