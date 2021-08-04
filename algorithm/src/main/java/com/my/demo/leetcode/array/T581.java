package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2021-8-3 14:41
 */
public class T581 {

    public static void main(String[] args) {
        int[] nums = {5,4,3,1,2};
        System.out.println(findUnsortedSubarray(nums));
        // 官方解题一趟遍历
        System.out.println(findUnsortedSubarray2(nums));
        System.out.println(findUnsortedSubarray3(nums));
    }

    public static int findUnsortedSubarray3(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        boolean falg = true;
        boolean falg2 = true;
        int back = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (!falg && !falg2) {
                break;
            }

            if (nums[i] != arr[i] && falg) {
                start = i;
                falg = false;
            }
            if (nums[back - i] != arr[back - i] && falg2) {
                end = back - i;
                falg2 = false;
            }
        }

        return end > start ? end - start + 1 : 0;
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = -1;
        int right = -1;
        boolean leftFlag = true;
        boolean rightFlag = true;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!leftFlag && !rightFlag) {
                break;
            }
            if (nums[i] != clone[i] && leftFlag) {
                left = i;
                leftFlag = false;
            }
            if (nums[n - 1 - i] != clone[n - 1 - i] && rightFlag) {
                right = n - 1 - i;
                rightFlag = false;
            }
        }
        return right > left ? right - left + 1 : 0;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
