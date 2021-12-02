package com.my.demo.leetcode.string;

/**
 * @author ffdeng2
 */
public class T495 {

    public static void main(String[] args) {
        int[] timeSeries = {1,5};
        int duration = 3;
        System.out.println(findPoisonedDuration(timeSeries, duration));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int first = timeSeries[0];
        int result = duration;
        for (int i = 1; i< timeSeries.length; i++) {
            if (first + duration <= timeSeries[i]) {
                result += duration;
            } else {
                result+= timeSeries[i] - first;
            }
            first = timeSeries[i];
        }
        return result;
    }

}
