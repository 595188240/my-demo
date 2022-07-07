package com.my.demo.leetcode.array.medium;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2022-6-28 9:37
 */
public class T324 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,2,2,1};
        //wiggleSort2(nums);
        wiggleSort3(nums);
    }

    public static void wiggleSort3(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
