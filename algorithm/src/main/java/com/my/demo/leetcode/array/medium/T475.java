package com.my.demo.leetcode.array.medium;

import java.util.Arrays;

/**
 * @author ffdeng2
 * 供暖器
 */
public class T475 {

    public static void main(String[] args) {
        int[] houses = {1,2,3};
        int[] heaters = {2};
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        int max;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            while (j < heaters.length && heaters[j] < house) {
                j++;
            }
            if (j == 0) {
                max = heaters[j] - house;
            } else if (j == heaters.length) {
                max = house - heaters[j - 1];
            } else {
                max = Math.min(heaters[j] - house, house - heaters[j - 1]);
            }

            result = Math.max(result, max);
        }
        return result;
    }

}
