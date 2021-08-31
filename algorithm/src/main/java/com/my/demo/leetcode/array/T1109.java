package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T1109 {

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{1,3,20}};
        int n = 3;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        //int[] result = new int[n];
        //for (int[] i : bookings) {
        //    for (int j = i[0] - 1; j <= i[1] - 1; j++) {
        //        result[j] += i[2];
        //    }
        //}
        //return result;
        /**
         * 解题思路：
         * 换一种思路理解题意，将问题转换为：
         * 1.某公交车共有 n 站，第 i 条记录 bookings[i] = [i, j, k] 表示在 i 站上车 k 人，
         * 乘坐到 j 站，在 j+1 站下车，需要按照车站顺序返回每一站车上的人数
         * 2.根据 1 的思路，定义 counter[] 数组记录每站的人数变化，counter[i] 表示第 i+1 站。
         * 遍历 bookings[]：bookings[i] = [i, j, k] 表示在 i 站增加 k 人即 counters[i-1] += k，
         * 在 j+1 站减少 k 人即 counters[j] -= k
         * 3.遍历（整理）counter[] 数组，得到每站总人数： 每站的人数为前一站人数加上当前人数变化
         * counters[i] += counters[i - 1]
         */
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            // 可以理解为最后若小于n表示下完则为负数，方便后面叠加
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
