package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 */
public class T162 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement2(nums));
    }

    // O(n)
    public static int findPeakElement(int[] nums) {
        int begin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (begin > nums[i]) {
                return i - 1;
            } else {
                begin = nums[i];
            }

            if (i == nums.length - 1) {
                return i;
            }
        }
        return 0;
    }

    // 二分 O(logn)
    public static int findPeakElement2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 此处具有随机性，仅能找到高峰并不能找到最高峰
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
