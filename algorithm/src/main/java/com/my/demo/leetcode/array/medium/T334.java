package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 */
public class T334 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
        System.out.println(increasingTriplet2(nums));
    }

    public static boolean increasingTriplet2(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (a >= num) {
                a = num;
            } else if (b >= num) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int mid = nums[j];
                if (first >= mid) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int end = nums[k];
                    if (end > mid) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
