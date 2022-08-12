package com.my.demo.leetcode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ffdeng2
 * @date 2022-8-4 13:51
 */
public class T1403 {

    public static void main(String[] args) {
        int[] nums = {4,3,10,9,8};
        System.out.println(minSubsequence(nums));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        int count = Arrays.stream(nums).sum();
        List<Integer> collect = Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < collect.size(); i++) {
            result.add(collect.get(i));
            sum += collect.get(i);
            if (sum > (count - sum)) {
                return result.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
            }
        }
        return result;
    }
}
