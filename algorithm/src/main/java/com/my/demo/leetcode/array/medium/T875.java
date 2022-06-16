package com.my.demo.leetcode.array.medium;

import java.util.Arrays;

/**
 * @author ffdeng2
 * @date 2022-6-7 18:56
 */
public class T875 {

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int k = high;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            long speed = speed(piles, mid);
            if (speed <= h) {
                k = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }

    public static long speed(int[] piles, int mid) {
        long time = 0;
        for (int pile : piles) {
            long t = (pile + mid - 1) / mid;
            time += t;
        }
        return time;
    }
}
