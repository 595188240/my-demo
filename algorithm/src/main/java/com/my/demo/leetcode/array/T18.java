package com.my.demo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2021-7-30 10:36
 * 四数之和
 */
public class T18 {

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int four = length - 1;
                    int temp = -1;
                    while (k < four) {
                        if (temp == nums[four]) {
                            four--;
                            continue;
                        } else {
                            temp = nums[four];
                        }
                        int sum = nums[i] + nums[j] + nums[k] + nums[four];
                        if (sum == target) {
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[four]));
                        }
                        four--;
                    }
                }
            }
        }
        return resultList;
    }

}
