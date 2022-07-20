package com.my.demo.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2022-7-20 15:42
 */
public class T1260 {

    public static void main(String[] args) {
        //int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] grid = {{1}};
        //int k = 2;
        int k = 100;
        System.out.println(shiftGrid(grid, k));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : grid) {
            for (int ii : i) {
                list.add(ii);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();
        k = k % list.size();
        int begin = list.size() - k;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (begin < list.size()) {
                copy.add(list.get(begin));
                begin++;
            } else {
                copy.add(list.get(index++));
            }
        }
        index = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                temp.add(copy.get(index++));
            }
            result.add(temp);
        }
        return result;
    }
}
