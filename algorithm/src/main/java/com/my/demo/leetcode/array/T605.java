package com.my.demo.leetcode.array;

/**
 * Date        Author
 * 2021/4/23     ffdeng
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 **/
public class T605 {

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // count初始为1 避免 0,0,1 情况
        int count = 1;
        int result = 0;
        for (int i : flowerbed) {
            if (i == 0) {
                count++;
                if (count == 3) {
                    result++;
                    count = 1;
                }
            } else {
                count = 0;
            }
        }

        // 避免 1,0,0
        if (count == 2) {
            result++;
        }

        return result >= n;
    }
}
