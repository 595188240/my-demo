package com.my.demo.leetcode.array.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ffdeng2
 */
public class T1705 {

    public static void main(String[] args) {
        int[] apples = {2,1,10};
        int[] days = {2,10,1};
        System.out.println(eatenApples(apples, days));
    }

    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) {
                q.add(new int[]{time + days[time] - 1, apples[time]});
            }
            while (!q.isEmpty() && q.peek()[0] < time) {
                q.poll();
            }
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) {
                    q.add(cur);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }
}
