package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T611 {

    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i > 1 ; i--) {
            int target = nums[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= target) {
                    left++;
                } else {
                    result += right - left;
                    right--;
                }
            }
        }
        return result;
    }

}
