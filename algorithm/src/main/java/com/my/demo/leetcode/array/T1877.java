package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2021-7-20 17:06
 */
public class T1877 {

    public static void main(String[] args) {
        int[] nums = {3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int length = nums.length - 1;
        int result = 0;
        for (int i = 0; i <n ; i++) {
            result = Math.max(result, nums[i] + nums[length - i]);
        }
        return result;
    }
}
