package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2021-7-19 18:21
 */
public class T1838 {

    public static void main(String[] args) {
        int[] nums = {1,4,8,13};
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        long total = 0;
        int l = 0;
        int result = 0;
        for (int i = 1; i < length; i++) {
            total += (nums[i] - nums[i - 1]) * (i - l);
            while (total > k) {
                total -= nums[i] - nums[l];
                l++;
            }
            result = Math.max(result, i - l + 1);
        }
        return result;
    }

}
