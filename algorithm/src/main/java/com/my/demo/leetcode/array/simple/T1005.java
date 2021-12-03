package com.my.demo.leetcode.array.simple;

import java.util.Arrays;

/**
 * @author ffdeng2
 * K 次取反后最大化的数组和
 */
public class T1005 {

    public static void main(String[] args) {
        int[] nums = {3,-1,0,2};
        int k = 3;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }
        int result = 0;
        if (k % 2 == 0) {
            result = Arrays.stream(nums).sum();
        } else {
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                result += num;
            }
            result = result - 2 * min;
        }
        return result;
    }

    public static int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            result += num;
        }

        return k % 2 == 0 ? result : result - 2 * min;
    }

}
