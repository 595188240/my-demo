package com.my.demo.leetcode.array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ffdeng2
 * @date 2022-8-12 14:24
 */
public class T1282 {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        // 3,3,3,3,3,1,3
        // [[5],[0,1,2],[3,4,6]]
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> integers = map.get(groupSizes[i]);
                integers.add(i);
                if (integers.size() == groupSizes[i]) {
                    result.add(integers);
                    integers = new ArrayList<>();
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                if (groupSizes[i] == 1) {
                    result.add(list);
                } else {
                    map.put(groupSizes[i], list);
                }
            }
        }
        return result;
    }
}
