package com.my.demo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2021-7-29 17:38
 * 三数之和
 */
public class T15 {

    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int three = length - 1;
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (three > j && nums[i] + nums[j] + nums[three] > 0) {
                    three--;
                }
                if (three == j) {
                    break;
                }
                if (nums[i] + nums[j] + nums[three] == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[j], nums[three]));
                }
            }
        }
        return resultList;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int right = length - 1;
            for (int left = i + 1; left < length; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (right > left && num + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (right == left) {
                    break;
                }
                if (num + nums[left] + nums[right] == 0) {
                    resultList.add(Arrays.asList(num, nums[left], nums[right]));
                }
            }
        }

        return resultList;
    }
}
