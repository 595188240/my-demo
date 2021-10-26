package com.my.demo.leetcode.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ffdeng2
 */
public class T496 {

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int temp = nums1[i];
            int num = -1;
            for (int j = map.get(temp); j < nums2.length; j++) {
                if (nums2[j] > temp) {
                    num = nums2[j];
                    break;
                }
            }
            result[i] = num;
        }
        return result;
    }

}
